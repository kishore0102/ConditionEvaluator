import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class TruthTableEvaluator {

    public static boolean logicGateCalc(char a, char b, char op) {
        if (a == '0' && b == '0') return false;
        if (a == '0' && b == '1') return op != '&';
        if (a == '1' && b == '0') return op != '&';
        return a == '1' && b == '1';
    }

    public static void expressionEvaluator(Criteria expression, Criteria expression2) {

        Map<String, String> expressionInputs = new HashMap<>();
        getUniqueConditions(expression, expressionInputs);
        getUniqueConditions(expression2, expressionInputs);

        int incrementer = 65;
        for (Map.Entry<String, String> i: expressionInputs.entrySet()) {
            char temp = (char) incrementer;
            incrementer++;
            i.setValue(String.valueOf(temp));
        }
        System.out.println(expressionInputs);

        boolean ans = true;
        List<String> booleanInputs = BooleanInputGenerator.generateBooleanInputs(expressionInputs.size());
        for (String booleanInput : booleanInputs) {
            Map<Character, Character> input = new HashMap<>();
            int incrementer1 = 65;
            for (char a : booleanInput.toCharArray()) {
                input.put(((char) incrementer1), a);
                incrementer1++;
            }
            char op1 = calcExpression(expression, expressionInputs, input);
            char op2 = calcExpression(expression2, expressionInputs, input);
            System.out.println(input + " -> " + op1 + " - " + op2);
            if (op1 != op2) {
                ans = false;
            }
        }
        System.out.println("\nanswer = " + ans);

    }

    private static char calcExpression(Criteria expression, Map<String, String> expressionInputs, Map<Character, Character> input) {

        if (expression.getGroup_operator() == null) {
            String condition = expression.getOperand() + expression.getOperator() + expression.getValue();
            String value = expressionInputs.get(condition);
            return input.get(value.charAt(0));

        } else {
            char[] inputs = new char[expression.getGroup().size()];
            int x = 0;
            for (Criteria a: expression.getGroup()) {
                inputs[x] = calcExpression(a, expressionInputs, input);
                x++;
            }
            boolean ans = logicGateCalc(inputs[0], inputs[1], (expression.getGroup_operator().equals("and") ? '&' : '|'));
            return (ans) ? '1' : '0';
        }

    }

    private static void getUniqueConditions(Criteria expression, Map<String, String> expressionInputs) {

        if (expression.getGroup_operator() == null) {
            String condition = expression.getOperand() + expression.getOperator() + expression.getValue();
            expressionInputs.put(condition, "");

        } else {
            for (Criteria a: expression.getGroup()) {
                getUniqueConditions(a, expressionInputs);
            }

        }

    }

}
