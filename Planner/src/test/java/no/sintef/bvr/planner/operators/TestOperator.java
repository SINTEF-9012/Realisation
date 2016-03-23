/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package no.sintef.bvr.planner.operators;

import no.sintef.bvr.planner.FakeFeatureSet;
import no.sintef.bvr.planner.FeatureSet;
import no.sintef.bvr.planner.Operators;
import no.sintef.bvr.planner.OperatorsBuilder;
import no.sintef.bvr.planner.State;
import no.sintef.bvr.planner.StateFactory;
import static no.sintef.bvr.planner.Status.*;
import static org.junit.Assert.*;
import org.junit.Test;

/**
 *
 * @author franckc
 */
public class TestOperator {

    private final FeatureSet features;
    private final StateFactory aState;
    private final Operators operators;

    public TestOperator() {
        features = new FakeFeatureSet(2, "f%1$d");
        aState = new StateFactory(features);
        operators = makeOperators();
    }

    private Operators makeOperators() {
        OperatorsBuilder builder = new OperatorsBuilder();
        builder.addPositivelyRealise("f1");
        builder.addPositivelyRealise("f2");
        return builder.getResult();

    }

    @Test
    public void shouldApplyToReleventState() {
        Operator operator = operators.get("+f1");
        State state = aState.with(PENDING, PENDING);

        assertTrue(operator.appliesTo(state));
    }

    @Test
    public void shouldNotApplyToIrreleventState() {
        Operator operator = operators.get("+f1");
        State state = aState.with(POSITIVE, PENDING);

        assertFalse(operator.appliesTo(state));

    }

}
