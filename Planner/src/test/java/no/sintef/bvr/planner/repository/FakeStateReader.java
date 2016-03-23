
package no.sintef.bvr.planner.repository;

import java.io.InputStream;
import no.sintef.bvr.planner.State;


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
