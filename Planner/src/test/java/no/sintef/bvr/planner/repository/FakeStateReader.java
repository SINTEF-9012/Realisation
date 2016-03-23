
package no.sintef.bvr.planner.repository;

import no.sintef.bvr.planner.State;
import no.sintef.bvr.planner.repository.StateReader;
import no.sintef.bvr.planner.repository.ReaderException;


public class FakeStateReader implements StateReader {

    private State state;
    
    public FakeStateReader(State state) {
        this.state = state;
    }

    @Override
    public State read() throws ReaderException {
        return state;
    }
    
}
