/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package no.sintef.bvr.planner;

import java.util.Set;
import static no.sintef.bvr.planner.Status.*;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author franckc
 */
public class TestSolution {

    private final FeatureSet features;
    private final StateFactory aState;
    private final PlanFactory aPlan;
    private final Operators operators;

    public TestSolution() {
        features = new FakeFeatureSet(2);
        aState = new StateFactory(features);
        aPlan = new PlanFactory();
        operators = buildOperators();
    }

    private Operators buildOperators() {
        OperatorsBuilder builder = new OperatorsBuilder();
        builder.addPositivelyRealise(features.at(0));
        builder.addPositivelyRealise(features.at(1));
        return builder.getResult();
    }

    @Test
    public void shouldHaveNoRefinementIfNoOperatorApply() {
        Solution solution = new Solution(
                aPlan.empty(), 
                aState.with(POSITIVE, POSITIVE));

        Set<Solution> refinements = solution.refineWith(operators);

        assertTrue(refinements.isEmpty());
    }

    @Test
    public void shouldBeOnlyRefinedByOperatorsThatApply() {
        Solution solution = new Solution(
                new Plan(),
                aState.with(POSITIVE, PENDING));

        Set<Solution> refinements = solution.refineWith(operators);

        final Solution expected = new Solution(
                aPlan.with("+f2"),
                aState.with(POSITIVE, POSITIVE));
        assertTrue(refinements.contains(expected));
    }

    @Test
    public void refineShouldExpandPlanAndUpdateState() {
        Solution solution = new Solution(
                aPlan.empty(),
                aState.with(PENDING, PENDING));

        Solution actual = solution.refineWith(operators.get("+f1"));

        Solution expected = new Solution(
                aPlan.with("+f1"),
                aState.with(POSITIVE, PENDING)
        );
        assertEquals(expected, actual);
    }

    @Test
    public void twoSimilarSolutionShouldBeEqual() {
        Solution solution = new Solution(
                aPlan.with("+f1"),
                aState.with(POSITIVE, PENDING));
        Solution duplicate = new Solution(
                aPlan.with("+f1"),
                aState.with(POSITIVE, PENDING));

        assertEquals(solution, duplicate);
    }

    @Test
    public void twoDifferentSolutionShouldNotBeEqual() {
        Solution solution = new Solution(
                aPlan.with("+f1"),
                aState.with(POSITIVE, PENDING));
        Solution duplicate = new Solution(
                aPlan.with("+f2"),
                aState.with(PENDING, POSITIVE));

        assertNotEquals(duplicate, solution);
    }

}
