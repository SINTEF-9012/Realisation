/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package no.sintef.bvr.planner.repository;

import java.io.ByteArrayInputStream;
import java.io.InputStream;
import no.sintef.bvr.planner.State;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author franckc
 */
public class TestPropertiesStateReader {

    private State result;

    @Test
    public void shouldReadFromProperties() throws ReaderException {
        String text
                = "feature1: pending\n"
                + "feature2: positive\n"
                + "feature3: negative\n";

        read(text);

        assertTrue(result.isPending("feature1"));
        assertTrue(result.isPositive("feature2"));
        assertTrue(result.isNegative("feature3"));
    }
    
    @Test 
    public void shouldReadPlusZeroAndMinusSymbols() throws ReaderException {
        String text
                = "feature1: 0\n"
                + "feature2: +\n"
                + "feature3: -\n";

        read(text);

        assertTrue(result.isPending("feature1"));
        assertTrue(result.isPositive("feature2"));
        assertTrue(result.isNegative("feature3"));
    }

    @Test
    public void shouldIgnoreCaptilisation() throws ReaderException {
        String text
                = "feature1: penDIng\n"
                + "feature2: POSITIVE\n"
                + "feature3: negatIVE\n";

        read(text);

        assertTrue(result.isPending("feature1"));
        assertTrue(result.isPositive("feature2"));
        assertTrue(result.isNegative("feature3"));
    }
    
    @Test(expected=ReaderException.class)
    public void shouldRejectInvalidStatus() throws ReaderException {
        String text = "feature1: this-is-an-invalid-status";
        
        read(text);
    }
    

    private void read(String text) throws ReaderException {
        InputStream input = new ByteArrayInputStream(text.getBytes());
        StateReader reader = new PropertiesStateReader();

        result = reader.readFrom(input);
    }

}
