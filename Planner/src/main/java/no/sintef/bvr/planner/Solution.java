/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package no.sintef.bvr.planner;

import java.util.HashSet;
import java.util.Objects;
import java.util.Set;
import no.sintef.bvr.planner.operators.Operator;

/**
 *
 * @author franckc
 */
public class Solution {

    private final Plan plan;
    private final State currentState;

    public Solution(Plan plan, State state) {
        this.plan = plan;
        this.currentState = state;
    }

    @Override
    public int hashCode() {
        int hash = 7;
        return hash;
    }

    @Override
    public boolean equals(Object obj) {
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        final Solution other = (Solution) obj;
        if (!Objects.equals(this.plan, other.plan)) {
            return false;
        }
        return Objects.equals(this.currentState, other.currentState);
    }
    
    
    Set<Solution> refineWith(Operators operators) {
        final Set<Solution> refinements = new HashSet<>();
        for(Operator anyOperator: operators) {
            if (anyOperator.appliesTo(currentState)) {
                refinements.add(this.refineWith(anyOperator));
            }
        }
        return refinements;
    }

    boolean satisfies(State goal) {
        return currentState.equals(goal);
    }

    Plan getPlan() {
        return plan;
    }

    protected Solution refineWith(Operator operator) {
        return new Solution(plan.extendWith(operator), operator.applyTo(currentState)); 
    }
    
}
