package no.sintef.bvr.planner;


import no.sintef.bvr.planner.repository.PlanWriter;
import no.sintef.bvr.planner.repository.PropertiesStateReader;
import no.sintef.bvr.planner.repository.Repository;
import no.sintef.bvr.planner.ui.Controller;
import no.sintef.bvr.planner.ui.Display;

public class Settings {

    public static final String DEFAULT_PLAN_LOCATION = "plan.out";
    public static final String DEFAULT_GOAL_LOCATION = "goal.properties";
    public static final String DEFAULT_ORIGIN_LOCATION = "origin.properties";
    public static final String DEFAULT_OPERATORS_LOCATION = "operators.txt";
    public static final String DEFAULT_FEATURE_LOCATION = null;
    

    public static Settings defaultSettings() {
        return new Settings();
    }

    private String origin;
    private String goal;
    private String operators;
    private String plan;
    private String features;

    Settings() {
        this(DEFAULT_ORIGIN_LOCATION,
                DEFAULT_GOAL_LOCATION,
                DEFAULT_OPERATORS_LOCATION,
                DEFAULT_PLAN_LOCATION,
                DEFAULT_FEATURE_LOCATION);
    }

    Settings(String origin, String goal, String operators, String plan, String features) {
        this.origin = origin;
        this.goal = goal;
        this.operators = operators;
        this.plan = plan;
        this.features = features;
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

    public Repository getRepository(){
        return new Repository(
                new PropertiesStateReader(getOriginLocation()),
                new PropertiesStateReader(getGoalLocation()),
                null,
                new PlanWriter(getPlanLocation()));
    }

    public Display getDisplay() {
        return new Display(System.out);
    }

    public Controller buildController() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

	public String getFeatureModelLocation() {
		return features;
	}

	public void setFeatureModelLocation(String value) {
		features = value;
	}

}
