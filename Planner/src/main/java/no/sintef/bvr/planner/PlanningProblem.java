package no.sintef.bvr.planner;

import java.util.HashSet;
import java.util.Set;


public class PlanningProblem {
    
    private State origin;
    private State goal;
    private Operators operators;

    public PlanningProblem(Operators operators, State origin, State goal) {
        setOrigin(origin);
        setGoal(goal);
        setOperators(operators);
    }
    
    private void setOrigin(State state) {
        if (state == null) {
            throw new IllegalArgumentException("Invalid origin (null found)");
        }
        this.origin = state;
    }

    public State getOrigin() {
        return origin;
    }
    
    private void setGoal(State state) {
        if (state == null) {
            throw new IllegalArgumentException("Invalid goal (null found)");
        }
        this.goal = state;
    }

    public State getGoal() {
        return goal;
    }
    
    private void setOperators(Operators operators) {
        if (operators == null) {
            throw new IllegalArgumentException("Invalid operators (null found)");
        }
        this.operators = operators;
    }

    public Operators getOperators() {
        return operators;
    }
    
    public Plan solve() {
        Set<Solution> frontier = new HashSet<>();
        frontier.add(new Solution(new Plan(), origin));
        Set<Solution> explored = new HashSet<>();
        while (!frontier.isEmpty()) {
            Set<Solution> newFrontier = new HashSet<>();
            for (Solution eachSolution: frontier) {
                explored.add(eachSolution);
                for(Solution eachRefinement: eachSolution.refineWith(operators)) {
                    if (eachRefinement.satisfies(goal)) {
                        return eachRefinement.getPlan();
                    }
                    if (!explored.contains(eachRefinement)) {
                        newFrontier.add(eachRefinement);
                    }
                }
            }
            frontier = newFrontier;
        }
        return new Plan();
    }
    
}
