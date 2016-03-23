
package no.sintef.bvr.planner;

// TODO REMOVE
public class StateFactory {

    private final FeatureSet features;
    
    public StateFactory(FeatureSet features) {
        this.features = features;
    }

    public State with(Status... status) {
        return new State(features, status);
    }
    
}
