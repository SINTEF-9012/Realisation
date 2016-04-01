package no.sintef.bvr.planner.repository;

import no.sintef.bvr.planner.Operators;

/**
 * Returns a predefined operator set.
 */
public class FakeOperatorsReader implements OperatorsReader {

    private final Operators operators;

    public FakeOperatorsReader(Operators operators) {
        this.operators = operators;
    }

    @Override
    public Operators read() throws ReaderException {
        return operators;
    }

}
