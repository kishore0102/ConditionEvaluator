import java.util.List;

public class Criteria {

    private String group_operator;
    private List<Criteria> group;
    private String operand;
    private String operator;
    private String value;

    public Criteria() {
    }

    public String getOperand() {
        return operand;
    }

    public void setOperand(String operand) {
        this.operand = operand;
    }

    public String getOperator() {
        return operator;
    }

    public void setOperator(String operator) {
        this.operator = operator;
    }

    public String getValue() {
        return value;
    }

    public void setValue(String value) {
        this.value = value;
    }

    public String getGroup_operator() {
        return group_operator;
    }

    public void setGroup_operator(String group_operator) {
        this.group_operator = group_operator;
    }

    public List<Criteria> getGroup() {
        return group;
    }

    public void setGroup(List<Criteria> group) {
        this.group = group;
    }

    @Override
    public String toString() {
        return "Criteria{" +
                "group_operator='" + group_operator + '\'' +
                ", group=" + group +
                ", operand='" + operand + '\'' +
                ", operator='" + operator + '\'' +
                ", value='" + value + '\'' +
                '}';
    }

}
