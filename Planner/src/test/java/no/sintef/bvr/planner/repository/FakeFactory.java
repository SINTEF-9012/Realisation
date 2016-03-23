/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package no.sintef.bvr.planner.repository;

import no.sintef.bvr.planner.ui.Display;
import java.io.ByteArrayOutputStream;
import java.io.OutputStream;
import java.util.HashMap;
import java.util.Map;
import no.sintef.bvr.planner.Operators;
import no.sintef.bvr.planner.State;

/**
 * 
 */
public class FakeFactory implements Factory {

    private Map<String, StateReader> readers; 
    private OperatorsReader operatorsReader;
    private final PlanWriter planWriter;
    private final OutputStream output;
    private final Display display;

    public FakeFactory() { 
        readers = new HashMap<>();
        output = new ByteArrayOutputStream();
        display = new Display(output);
        planWriter = new FakePlanWriter();
    }

    @Override
    public StateReader getStateReaderFor(String location) {
        if (readers.containsKey(location)) {
            return readers.get(location);
        }
        return new FakeReaderThatFails(location);
    }
    
    @Override
    public OperatorsReader getOperatorsReader() {
        return operatorsReader;
    }

    @Override
    public PlanWriter getPlanWriter(String location) {
        return planWriter;
    }
    
    public Display getDisplay() {
        return display;
    }

    public String getDisplayedOutput() {
        return output.toString();
    }

    public void define(String location, State state) {
        readers.put(location, new FakeStateReader(state));
    }
    
    public void defineOperators(String location, Operators operators) {
        operatorsReader = new FakeOperatorsReader(operators);
    }

    
    private static class FakeReaderThatFails implements StateReader {

        private final String location;

        public FakeReaderThatFails(String location) {
            this.location = location;
        }

        @Override
        public State read() throws ReaderException {
            throw new ReaderException(location);
        }

    }

}
