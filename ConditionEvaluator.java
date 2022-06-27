import java.util.Arrays;

public class ConditionEvaluator {

    public static void main(String[] args) {
        Criteria inputs1 = getInput1();
        Criteria inputs2 = getInput2();
        TruthTableEvaluator.expressionEvaluator(inputs1, inputs2);
    }

    public static Criteria getInput1() {
        Criteria a = new Criteria();
        Criteria b = new Criteria();
        Criteria c = new Criteria();
        a.setOperand("city");
        a.setOperator("=");
        a.setValue("chennai");
        b.setOperand("city");
        b.setOperator("=");
        b.setValue("vellore");
        c.setOperand("state");
        c.setOperator("=");
        c.setValue("tamilnadu");
        Criteria parent = new Criteria();
        Criteria child = new Criteria();
        child.setGroup(Arrays.asList(a, b));
        child.setGroup_operator("or");
        parent.setGroup_operator("and");
        parent.setGroup(Arrays.asList(child, c));
        return parent;
    }

    public static Criteria getInput2() {
        Criteria a = new Criteria();
        Criteria b = new Criteria();
        Criteria c = new Criteria();
        a.setOperand("city");
        a.setOperator("=");
        a.setValue("chennai");
        b.setOperand("city");
        b.setOperator("=");
        b.setValue("vellore");
        c.setOperand("state");
        c.setOperator("=");
        c.setValue("tamilnadu");
        Criteria parent = new Criteria();
        Criteria child = new Criteria();
        child.setGroup(Arrays.asList(a, b));
        child.setGroup_operator("or");
        parent.setGroup_operator("and");
        parent.setGroup(Arrays.asList(c, child));
        return parent;
    }

}
