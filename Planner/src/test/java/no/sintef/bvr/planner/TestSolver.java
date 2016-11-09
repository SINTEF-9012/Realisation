/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package no.sintef.bvr.planner;

import java.util.ArrayList;
import java.util.Collection;
import static no.sintef.bvr.planner.Status.*;
import org.junit.Test;
import static org.junit.Assert.*;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;

@RunWith(Parameterized.class)
public class TestSolver {

    private PlanningProblem problem;
    private Plan expected;

    public TestSolver(PlanningProblem problem, Plan expectation) {
        this.problem = problem;
        this.expected = expectation;
    }

    @Test
    public void shouldFindTheOnlyAndSinglePlanThatExist() {
        Plan actualPlan = problem.solve();
        assertEquals(expected, actualPlan);
    }

    private static PlanFactory aPlan = new PlanFactory();

    @Parameterized.Parameters
    public static Collection<Object[]> table() {
        Collection<Object[]> results = new ArrayList<>();

        results.add(oneStep());
        results.add(twoStepsChain());
        results.add(threeStepsChain());
        results.add(chainWithNegativeRealisation());
        results.add(noPossiblePlan());
        results.add(windTurbine());

        return results;
    }

    private static Object[] oneStep() {
        PlanningProblemBuilder builder = new PlanningProblemBuilder();
        builder.setFeatureCount(1);
        builder.setOrigin(PENDING);
        builder.setGoal(POSITIVE);
        builder.addPositivelyRealise("f1");

        Plan expected = aPlan.with("+f1");

        final Object[] testCase = new Object[]{builder.getResult(), expected};
        return testCase;
    }

    private static Object[] twoStepsChain() {
        PlanningProblemBuilder builder = new PlanningProblemBuilder();
        builder.setFeatureCount(2);
        builder.setOrigin(PENDING, PENDING);
        builder.setGoal(POSITIVE, POSITIVE);
        builder.addPositivelyRealise("f1");
        builder.addConditionalPositivelyRealise("f2", "f1");

        Plan expected = aPlan.with("+f1", "+f2");

        final Object[] testCase = new Object[]{builder.getResult(), expected};
        return testCase;
    }

    private static Object[] threeStepsChain() {
        PlanningProblemBuilder builder = new PlanningProblemBuilder();
        builder.setFeatureCount(3);
        builder.setOrigin(PENDING, PENDING, PENDING);
        builder.setGoal(POSITIVE, POSITIVE, POSITIVE);
        builder.addPositivelyRealise("f1");
        builder.addConditionalPositivelyRealise("f2", "f1");
        builder.addConditionalPositivelyRealise("f3", "f2");

        Plan expected = aPlan.with("+f1", "+f2", "+f3");

        final Object[] testCase = new Object[]{builder.getResult(), expected};
        return testCase;
    }

    private static Object[] chainWithNegativeRealisation() {
        PlanningProblemBuilder builder = new PlanningProblemBuilder();
        builder.setFeatureCount(3);
        builder.setOrigin(PENDING, PENDING, PENDING);
        builder.setGoal(POSITIVE, POSITIVE, NEGATIVE);
        builder.addPositivelyRealise("f1");
        builder.addConditionalPositivelyRealise("f2", "f1");
        builder.addConditionalNegativelyRealise("f3", "f2");

        Plan expected = aPlan.with("+f1", "+f2", "-f3");

        final Object[] testCase = new Object[]{builder.getResult(), expected};
        return testCase;
    }

    private static Object[] noPossiblePlan() {
        PlanningProblemBuilder builder = new PlanningProblemBuilder();
        builder.setFeatureCount(3);
        builder.setOrigin(PENDING, PENDING, PENDING);
        builder.setGoal(POSITIVE, POSITIVE, NEGATIVE);
        builder.addPositivelyRealise("f1");

        Plan expected = aPlan.empty();

        final Object[] testCase = new Object[]{builder.getResult(), expected};
        return testCase;
    }

    private static Object[] windTurbine() {
        PlanningProblemBuilder builder = new PlanningProblemBuilder();
        builder.setFeatureCount(6);
        builder.setOrigin(PENDING, PENDING, PENDING, PENDING, PENDING, PENDING);
        builder.setGoal(NEGATIVE, NEGATIVE, POSITIVE, POSITIVE, POSITIVE, NEGATIVE);
        for(int index=1 ; index <= 6; index++) {
            builder.addPositivelyRealise("f" + index);
            builder.addNegativelyRealise("f" + index);
        }

        Plan expected = aPlan.with("-f1", "-f2", "+f3", "+f4", "+f5", "-f6");

        final Object[] testCase = new Object[]{builder.getResult(), expected};
        return testCase;
    }

}
