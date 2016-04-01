/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package no.sintef.bvr.planner.operators;

import no.sintef.bvr.planner.State;
import no.sintef.bvr.planner.operators.interfaces.IIsExpression;

import static no.sintef.bvr.planner.Status.POSITIVE;

/**
 *
 * @author franckc
 */
public class IsPositive implements IIsExpression {
    
    private final String featureName;

    public IsPositive(String featureName) {
        this.featureName = featureName;
    }

    @Override
    public boolean evaluateOn(State state) {
        return state.isPositive(featureName);
    }

    @Override
    public State applyTo(State currentState) {
        return currentState.copyAndSet(featureName, POSITIVE);
    }

    @Override
    public String toString() {
        return "IsPositive(" + featureName + ')';
    }
    
	@Override
	public String getFeatureName() {
		return featureName;
	}

    
}
