/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package no.sintef.bvr.planner;

import static no.sintef.bvr.planner.Status.*;
import static org.junit.Assert.*;
import org.junit.Test;

/**
 *
 * @author franckc
 */
public class TestState {

    private final FeatureSet features;
    private final StateFactory aState;

    public TestState() {
        features = new FakeFeatureSet(3, "f%1$d");
        aState = new StateFactory(features);
    }

    @Test
    public void shouldProvideStatusPerFeature() {
        State s1 = aState.with(PENDING, PENDING, PENDING);

        Status actual = s1.statusOf(features.at(0));

        assertEquals(PENDING, actual);
    }

    @Test
    public void shouldTellWhetherAFeatureIsRealised() {
        State state = aState.with(PENDING, POSITIVE, NEGATIVE);

        assertFalse("on pending", state.isRealised(features.at(0)));
        assertTrue("on positive", state.isRealised(features.at(1)));
        assertTrue("on negative", state.isRealised(features.at(2)));
    }

    @Test
    public void shouldTellWhetherAFeatureIsPositive() {
        State state = aState.with(PENDING, POSITIVE, NEGATIVE);

        assertFalse("on pending", state.isPositive(features.at(0)));
        assertTrue("on positive", state.isPositive(features.at(1)));
        assertFalse("on negative", state.isPositive(features.at(2)));
    }
    
      @Test
    public void shouldTellWhetherAFeatureIsNegative() {
        State state = aState.with(PENDING, POSITIVE, NEGATIVE);

        assertFalse("on pending", state.isNegative(features.at(0)));
        assertFalse("on positive", state.isNegative(features.at(1)));
        assertTrue("on negative", state.isNegative(features.at(2)));
    }

    @Test
    public void shouldSupportUpdatingStatusPerFeature() {
        State state = aState.with(PENDING, PENDING, PENDING);
        String feature = features.at(0);
        Status newStatus = Status.POSITIVE;

        state.setStatus(feature, newStatus);

        Status actual = state.statusOf(feature);
        assertEquals(newStatus, actual);
    }

    @Test
    public void shouldBeClonable() {
        State state = aState.with(PENDING, POSITIVE, PENDING);

        State clone = new State(state);

        assertEquals(state, clone);
        assertNotSame(state, clone);
    }
}
