
package no.sintef.bvr.planner;

import org.junit.Test;
import static org.junit.Assert.*;


public class TestPlan {
    private final static String[] OPERATORS = {"+f1", "-f2", "+f3"};
    private final PlanFactory aPlan;
    private final Plan plan;
    
    public TestPlan() {
        aPlan = new PlanFactory();
        plan = aPlan.with(OPERATORS);
    }

    @Test
    public void shouldEqualsItself() {
        assertEquals(plan, plan);
    }
    
    @Test
    public void shouldEqualsASimilarPlan() {
        Plan aSimilarPlan = aPlan.with(OPERATORS);
        assertEquals(plan, aSimilarPlan);
    }
    
    @Test
    public void shouldNotEqualsAPlanWithATheSameInvocationButShufflded() {
        Plan aSimilarPlan = aPlan.with("+f1", "+f3", "-f2");
        assertNotEquals(plan, aSimilarPlan);
    }
    
}
