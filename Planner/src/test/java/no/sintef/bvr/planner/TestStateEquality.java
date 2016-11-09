
package no.sintef.bvr.planner;

import static no.sintef.bvr.planner.Status.NEGATIVE;
import static no.sintef.bvr.planner.Status.PENDING;
import static no.sintef.bvr.planner.Status.POSITIVE;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotEquals;
import org.junit.Test;

/**
 * Test The equality between state
 */
public class TestStateEquality {

    private final FeatureSet features;
    private final StateFactory aState;
    private final State state;

    public TestStateEquality() {
        features = new FakeFeatureSet(6, "f%1$d");
        aState = new StateFactory(features);
        state = aState.with(PENDING, POSITIVE, NEGATIVE, PENDING, POSITIVE, NEGATIVE);
    }

    @Test
    public void shouldEqualsItself() {
        assertEquals(state, state);
    }

    @Test
    public void shouldEqualsASimilarState() {
        State similarState = aState.with(PENDING, POSITIVE, NEGATIVE, PENDING, POSITIVE, NEGATIVE);
        assertEquals(state, similarState);
    }
    
    @Test
    public void shouldEqualsASimilarStateWithASimilarFeatureSet() {
        State similarState = new State(new FakeFeatureSet(6, "f%1$d"), PENDING, POSITIVE, NEGATIVE, PENDING, POSITIVE, NEGATIVE);
        assertEquals(state, similarState);
    }

    @Test
    public void shouldDifferFromAStateWithOneFeaturePOSITIVEInsteadOfPENDING() {
        State differentState = aState.with(POSITIVE, POSITIVE, NEGATIVE, PENDING, POSITIVE, NEGATIVE);
        assertNotEquals(state, differentState);
    }

    @Test
    public void shouldDifferFromAStateWithOneFeatureNEGATIVEInsteadOfPENDING() {
        State differentState = aState.with(NEGATIVE, POSITIVE, NEGATIVE, PENDING, POSITIVE, NEGATIVE);
        assertNotEquals(state, differentState);
    }

    @Test
    public void shouldDifferFromAStateWithOneFeaturePENDINGInsteadOfPOSITIVE() {
        State differentState = aState.with(PENDING, PENDING, NEGATIVE, PENDING, POSITIVE, NEGATIVE);
        assertNotEquals(state, differentState);
    }

    @Test
    public void shouldDifferFromAStateWithOneFeatureNEGATIVEInsteadOfPOSITIVE() {
        State differentState = aState.with(PENDING, NEGATIVE, NEGATIVE, PENDING, POSITIVE, NEGATIVE);
        assertNotEquals(state, differentState);
    }

    @Test
    public void shouldDifferFromAStateWithOneFeaturePENDINGInsteadOfNEGATIVE() {
        State differentState = aState.with(PENDING, POSITIVE, PENDING, PENDING, POSITIVE, NEGATIVE);
        assertNotEquals(state, differentState);
    }

    @Test
    public void shouldDifferFromAStateWithOneFeaturePOSITIVEInsteadOfNEGATIVE() {
        State differentState = aState.with(PENDING, POSITIVE, POSITIVE, PENDING, POSITIVE, NEGATIVE);
        assertNotEquals(state, differentState);
    }

    @Test
    public void shouldDifferFromNull() {
        assertNotEquals(state, null);
    }
    
    @Test
    public void shouldDifferFromNonStateObject() {
        assertNotEquals(state, new Object[]{});
    }
    
}
