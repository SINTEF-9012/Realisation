package no.sintef.bvr.planner;

public class Settings {

    public static final String DEFAULT_PLAN_LOCATION = "plan.out";
    public static final String DEFAULT_GOAL_LOCATION = "goal.properties";
    public static final String DEFAULT_ORIGIN_LOCATION = "origin.properties";
    public static final String DEFAULT_OPERATORS_LOCATION = "operators.txt";

    public static Settings defaultSettings() {
        return new Settings();
    }

    private String origin;
    private String goal;
    private String operators;
    private String plan;

    Settings() {
        this(DEFAULT_ORIGIN_LOCATION,
                DEFAULT_GOAL_LOCATION,
                DEFAULT_OPERATORS_LOCATION,
                DEFAULT_PLAN_LOCATION);
    }

    Settings(String origin, String goal, String operators, String plan) {
        this.origin = origin;
        this.goal = goal;
        this.operators = operators;
        this.plan = plan;
    }

    public String getOriginLocation() {
        return origin;
    }

    public void setOriginLocation(String location) {
        origin = location;
    }

    public String getGoalLocation() {
        return goal;
    }

    public void setGoalLocation(String location) {
        goal = location;
    }

    public String getOperatorsLocation() {
        return operators;
    }

    public void setOperatorsLocation(String location) {
        operators = location;
    }

    public String getPlanLocation() {
        return plan;
    }

    public void setPlanLocation(String location) {
        plan = location;
    }

}
