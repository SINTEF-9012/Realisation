/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package no.sintef.bvr.planner.operators;

import no.sintef.bvr.planner.State;
import no.sintef.bvr.planner.operators.interfaces.IAndExpression;
import no.sintef.bvr.planner.operators.interfaces.IExpression;

/**
 *
 * @author franckc
 */
public class And implements IAndExpression {

    private final IExpression left;
    private final IExpression right;

    public And(IExpression left, IExpression right) {
        this.left = left;
        this.right = right;
    }
    
    @Override
    public boolean evaluateOn(State state) {
        return left.evaluateOn(state) && right.evaluateOn(state);
    }

    @Override
    public State applyTo(State state) {
        throw new RuntimeException("Cannot apply AND operator!");
    }

    @Override
    public String toString() {
        return "(" + left + " and " + right + ")";
    }

	@Override
	public IExpression getLeftSide() {
		return left;
	}

	@Override
	public IExpression getRightSide() {
		return right;
	}
}
