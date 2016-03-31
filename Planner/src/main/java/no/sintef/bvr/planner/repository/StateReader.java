
package no.sintef.bvr.planner.repository;

import no.sintef.bvr.planner.State;

/**
 * Read a state
 */
public interface StateReader {
    
    public State read() throws ReaderException;
    
}
