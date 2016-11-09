/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package no.sintef.bvr.planner.operators;

import no.sintef.bvr.planner.State;
import no.sintef.bvr.planner.operators.interfaces.IExpression;
import no.sintef.bvr.planner.operators.interfaces.IXorExpression;

/**
 *
 * @author franckc
 */
public class Xor implements IXorExpression {

    private final IExpression left;
    private final IExpression right;

    public Xor(IExpression left, IExpression right) {
        this.left = left;
        this.right = right;
    }
    
    @Override
    public boolean evaluateOn(State state) {
        return left.evaluateOn(state) && right.evaluateOn(state);
    }

    @Override
    public State applyTo(State state) {
        throw new RuntimeException("Cannot apply XOR operator!");
    }

    @Override
    public String toString() {
        return "(" + left + " xor " + right + ")";
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
