import java.util.List;

public class CriteriaScaledDown {

    private String group_operator;
    private List<CriteriaScaledDown> group;
    private String condition;

    public CriteriaScaledDown() {
    }

    public String getGroup_operator() {
        return group_operator;
    }

    public void setGroup_operator(String group_operator) {
        this.group_operator = group_operator;
    }

    public List<CriteriaScaledDown> getGroup() {
        return group;
    }

    public void setGroup(List<CriteriaScaledDown> group) {
        this.group = group;
    }

    public String getCondition() {
        return condition;
    }

    public void setCondition(String condition) {
        this.condition = condition;
    }

    @Override
    public String toString() {
        return "CriteriaScaledDown{" +
                "group_operator='" + group_operator + '\'' +
                ", group=" + group +
                ", condition='" + condition + '\'' +
                '}';
    }

}
