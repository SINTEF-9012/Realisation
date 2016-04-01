
package no.sintef.bvr.planner.repository;

import no.sintef.bvr.planner.Operators;
import no.sintef.bvr.planner.repository.interfaces.IOperatorsReader;

/**
 *
 * @author franckc
 */
public class FakeOperatorsReader implements IOperatorsReader {
    

    private final Operators operators;
    
    public FakeOperatorsReader(Operators operators) {
        this.operators = operators;
    }
    
    @Override
    public Operators read() throws ReaderException {
        return operators;
    }
 
    
    
}
