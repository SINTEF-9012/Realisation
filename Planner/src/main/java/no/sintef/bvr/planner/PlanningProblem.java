package no.sintef.bvr.planner;

import java.util.HashSet;
import java.util.Iterator;
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
            exploreRefinementOf(nextSolution);
            return nextSolution;
        }

        private Solution anyUnknown() {
            final Iterator<Solution> iterator = unknown.iterator();
            final Solution selected = iterator.next();
            iterator.remove();
            return selected;
        }

        private void exploreRefinementOf(Solution solution) {
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
