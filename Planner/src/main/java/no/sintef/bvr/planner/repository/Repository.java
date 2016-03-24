/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package no.sintef.bvr.planner.repository;

import java.io.Closeable;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import no.sintef.bvr.planner.Operators;
import no.sintef.bvr.planner.Plan;
import no.sintef.bvr.planner.State;

/**
 *
 * @author franckc
 */
public class Repository {

    private final Factory factory;
    
    private final StateReader state;
    private final OperatorsReader operators;
    private final PlanWriter plan;
    
    

    public Repository(Factory factory) {
        this(factory, null, null, null);
    }

    public Repository(Factory factory, StateReader state, OperatorsReader operators, PlanWriter plan) {
        this.factory = factory;
        this.state = state;
        this.operators = operators;
        this.plan = plan;
    }

    public State getOrigin(String location) throws ReaderException {
        return getState(location);
    }

    public State getGoal(String location) throws ReaderException {
        return getState(location);
    }

    private State getState(String location) throws ReaderException {
        InputStream source = null;
        try {
            source = factory.asInput(location);
            return state.readFrom(source);

        } catch (IOException ex) {
            throw new ReaderException(location, ex);

        } finally {
            close(source, location);
        }
    }

    public Operators getOperators(String location) throws ReaderException {
        InputStream source = null;
        try {
            source = factory.asInput(location);
            return operators.readFrom(source);

        } catch (IOException ex) {
            throw new ReaderException(location, ex);

        } finally {
            close(source, location);
        }
    }

    private void close(Closeable stream, String location) throws ReaderException {
        try {
            if (stream != null) {
                stream.close();
            }
            
        } catch (IOException ex) {
            throw new ReaderException(location, ex);
        }
    }

    public void store(Plan plan, String location) throws WriterException {
        OutputStream destination = null;
        try {
            destination = factory.asOutput(location);
            this.plan.write(plan, destination);
        } catch (IOException ex) {
            throw new WriterException(location, ex);
        } finally {
            try {
                if (destination != null) {
                    destination.close();
                }
            } catch (IOException ex) {
                throw new WriterException(location, ex);
            }
        }
    }

}
