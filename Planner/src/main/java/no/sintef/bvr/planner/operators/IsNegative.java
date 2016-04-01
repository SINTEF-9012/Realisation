/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package no.sintef.bvr.planner.operators;

import no.sintef.bvr.planner.State;
import no.sintef.bvr.planner.Status;
import no.sintef.bvr.planner.operators.interfaces.IIsExpression;

/**
 *
 * @author franckc
 */
public class IsNegative implements IIsExpression {
    
    private final String featureName;

    public IsNegative(String feature) {
        this.featureName = feature;
    }

    @Override
    public boolean evaluateOn(State state) {
        return state.isNegative(featureName);
    }

    @Override
    public State applyTo(State state) {
        return state.copyAndSet(featureName, Status.NEGATIVE);
    }

    @Override
    public String toString() {
        return "IsNegative("+ featureName + ')';
    }

	@Override
	public String getFeatureName() {
		return featureName;
	}    
}
