package no.sintef.bvr.planner.ui;

import java.util.List;
import no.sintef.bvr.planner.Settings;

public enum Parameter {

    OPERATORS("-op", "--operators"),
    ORIGIN("-o", "--origin"),
    GOAL("-g", "--goal"),
    PLAN("-p", "--plan");

    private final String longName;
    private final String shortName;

    private Parameter(String shortName, String longName) {
        this.shortName = shortName;
        this.longName = longName;
    }

    public String longName() {
        return longName;
    }

    public String shortName() {
        return shortName;
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
            default: throw new RuntimeException("Unknown command line parameter '" + this + "'");
        }
    }
    
     protected String defaultValue() {
         switch (this) {
            case ORIGIN: return Settings.DEFAULT_ORIGIN_LOCATION;
            case GOAL: return Settings.DEFAULT_GOAL_LOCATION;
            case OPERATORS: return Settings.DEFAULT_OPERATORS_LOCATION;
            case PLAN: return Settings.DEFAULT_PLAN_LOCATION;
            default: throw new RuntimeException("Unknown command line parameter '" + this + "'");
        }
    }
 
}
