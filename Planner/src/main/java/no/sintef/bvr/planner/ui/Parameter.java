package no.sintef.bvr.planner.ui;

import java.util.List;
import no.sintef.bvr.planner.Settings;

public enum Parameter {

    OPERATORS("-op", "--operators", "the list of operators available"),
    ORIGIN("-o", "--origin", "the starting state of base-product"),
    GOAL("-g", "--goal", "the product to realise"),
    PLAN("-p", "--plan", "the place where to store the plan"),
	FEATURE("-f", "--feature", "the place with a bvr model to generate operators (this option disables planner), -op is a location to store operators");

    private final String longName;
    private final String shortName;
    private final String description;

    private Parameter(String shortName, String longName, String description) {
        this.shortName = shortName;
        this.longName = longName;
        this.description = description;
    }

    public String longName() {
        return longName;
    }

    public String shortName() {
        return shortName;
    }
    
    public String description() {
        return description;
    }

    public boolean match(String key) {
        return key.equals(longName) || key.equals(shortName);
    }
    
    protected String getFrom(Settings settings){
        switch (this) {
            case ORIGIN: return settings.getOriginLocation();
            case GOAL: return settings.getGoalLocation();
            case OPERATORS: return settings.getOperatorsLocation();
            case PLAN: return settings.getPlanLocation();
            case FEATURE : return settings.getFeatureModelLocation();
            default: throw new RuntimeException("Unknown command line parameter '" + this + "'");
        }
    }
    
    protected void setIn(Settings settings, List<String> values) throws InvalidArgumentException {
        if (values.isEmpty()) throw new InvalidArgumentException(shortName());
        final String key = values.remove(0);
        if (values.isEmpty()) throw new InvalidArgumentException(shortName());
        final String value = values.remove(0);
        switch (this) {
            case ORIGIN: 
                settings.setOriginLocation(value);
                break;
            case GOAL: settings.setGoalLocation(value);
                break;
            case OPERATORS: 
                settings.setOperatorsLocation(value);
                break;
            case PLAN:
                settings.setPlanLocation(value);
                break;
            case FEATURE :
            	settings.setFeatureModelLocation(value);
            	break;
            default: throw new RuntimeException("Unknown command line parameter '" + this + "'");
        }
    }
    
     protected String defaultValue() {
         switch (this) {
            case ORIGIN: return Settings.DEFAULT_ORIGIN_LOCATION;
            case GOAL: return Settings.DEFAULT_GOAL_LOCATION;
            case OPERATORS: return Settings.DEFAULT_OPERATORS_LOCATION;
            case PLAN: return Settings.DEFAULT_PLAN_LOCATION;
            case FEATURE: return Settings.DEFAULT_FEATURE_LOCATION;
            default: throw new RuntimeException("Unknown command line parameter '" + this + "'");
        }
    }
 
}
