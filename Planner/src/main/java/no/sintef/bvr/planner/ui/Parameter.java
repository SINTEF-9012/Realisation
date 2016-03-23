package no.sintef.bvr.planner.ui;

public enum Parameter {

    OPERATORS("-op", "--operators", "operators.txt"),
    ORIGIN("-o", "--origin", "origin.properties"),
    GOAL("-g", "--goal", "goal.properties"),
    PLAN("-p", "--plan", "plan.out");

    private final String longName;
    private final String shortName;
    private final String defaultValue;

    private Parameter(String longName, String shortName, String defaultValue) {
        this.longName = longName;
        this.shortName = shortName;
        this.defaultValue = defaultValue;
    }

    public String longName() {
        return longName;
    }

    public String shortName() {
        return shortName;
    }

    public String defaultValue() {
        return defaultValue;
    }

    boolean match(String key) {
        return key.equals(longName) || key.equals(shortName);
    }

}
