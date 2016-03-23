/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package no.sintef.bvr.planner.operators;

import no.sintef.bvr.planner.State;

/**
 *
 * @author franckc
 */
public class And implements Expression {

    private final Expression left;
    private final Expression right;

    public And(Expression left, Expression right) {
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
    
      
    
    
}
