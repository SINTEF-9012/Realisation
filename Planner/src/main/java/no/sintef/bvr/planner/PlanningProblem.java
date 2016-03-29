package no.sintef.bvr.planner;

import java.util.HashSet;
import java.util.Iterator;
import java.util.Set;

public class PlanningProblem {

    private final State origin;
    private final State goal;
    private final Operators operators;

    public PlanningProblem(Operators operators, State origin, State goal) {
        this.origin = validateOrigin(origin);
        this.goal = validateGoal(goal);
        this.operators = validateOperators(operators);
    }

    private State validateOrigin(State state) {
        if (state == null) {
            throw new IllegalArgumentException("Invalid origin (null found)");
        }
        return state;
    }

    private State validateGoal(State state) {
        if (state == null) {
            throw new IllegalArgumentException("Invalid goal (null found)");
        }
        return state;
    }

    private Operators validateOperators(Operators operators) {
        if (operators == null) {
            throw new IllegalArgumentException("Invalid operators (null found)");
        }
        return operators;
    }

    public State getOrigin() {
        return origin;
    }

    public State getGoal() {
        return goal;
    }

    public Operators getOperators() {
        return operators;
    }

    public Plan solve() {
        for (Solution anySolution : solutionSpace()) {
            if (anySolution.satisfies(goal)) {
                return anySolution.getPlan();
            }
        }
        return new Plan();
    }

    private Iterable<Solution> solutionSpace() {
        return new Iterable<Solution>() {
            @Override
            public Iterator<Solution> iterator() {
                return new SolutionIterator();
            }
        };
    }

    private class SolutionIterator implements Iterator<Solution> {

        private final Set<Solution> unknown;
        private final Set<Solution> known;

        public SolutionIterator() {
            unknown = new HashSet<>();
            unknown.add(new Solution(new Plan(), origin));
            known = new HashSet<>();
        }

        @Override
        public boolean hasNext() {
            return !unknown.isEmpty();
        }

        @Override
        public Solution next() {
            Solution nextSolution = anyUnknown();
            expand(nextSolution);
            return nextSolution;
        }

        private Solution anyUnknown() {
            final Iterator<Solution> iterator = unknown.iterator();
            final Solution selected = iterator.next();
            iterator.remove();
            return selected;
        }

        private void expand(Solution solution) {
            known.add(solution);
            for (Solution anyRefinement : solution.refineWith(operators)) {
                if (isUnknown(anyRefinement)) {
                    unknown.add(anyRefinement);
                }
            }
        }

        private boolean isUnknown(Solution eachRefinement) {
            return !known.contains(eachRefinement);
        }
    }

}
