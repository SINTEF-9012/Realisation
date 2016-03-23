
package no.sintef.bvr.planner;

import no.sintef.bvr.planner.operators.And;
import no.sintef.bvr.planner.operators.IsNegative;
import no.sintef.bvr.planner.operators.IsPositive;
import no.sintef.bvr.planner.operators.IsRealised;
import no.sintef.bvr.planner.operators.Not;
import no.sintef.bvr.planner.operators.Operator;

/**
 *
 */
public class PlanningProblemBuilder {

    private FeatureSet features;
    private StateFactory aState;
    private State origin, goal;
    private Operators operators;

    public void setFeatureCount(int count) {
        features = new FakeFeatureSet(count);
        aState = new StateFactory(features);
        operators = new Operators();
    }

    public void setOrigin(Status... statuses) {
        origin = aState.with(statuses);
    }

    public void setGoal(Status... statuses) {
        goal = aState.with(statuses);
    }

    public void addStandardOperators() {
        for (String eachFeature : features.names()) {
            addPositivelyRealise(eachFeature);
            addNegativelyRealise(eachFeature);
        }
    }

    public void addPositivelyRealise(String featureName) {
        operators.add(
                new Operator(
                        "+" + featureName,
                        new Not(new IsRealised(featureName)),
                        new IsPositive(featureName))
        );
    }

    public void addNegativelyRealise(String feature) {
        operators.add(
                new Operator(
                        "-" + feature,
                        new Not(new IsRealised(feature)),
                        new IsNegative(feature))
        );
    }

    void addConditionalPositivelyRealise(String feature, String neededFeature) {
        operators.add(
                new Operator(
                        "+" + feature,
                        new And(new Not(new IsRealised(feature)), new IsPositive(neededFeature)),
                        new IsPositive(feature))
        );
    }
    
    void addConditionalNegativelyRealise(String feature, String neededFeature) {
        operators.add(
                new Operator(
                        "-" + feature,
                        new And(new Not(new IsRealised(feature)), new IsPositive(neededFeature)),
                        new IsNegative(feature))
        );
    }

    public PlanningProblem getResult() {
        assert operators != null : "Null operator";
        assert goal != null : "null goal";
        assert origin != null : "null origin";

        return new PlanningProblem(operators, origin, goal);
    }

}
