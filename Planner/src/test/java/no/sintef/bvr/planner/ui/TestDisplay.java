/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package no.sintef.bvr.planner.ui;

import java.io.ByteArrayOutputStream;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author franckc
 */
public class TestDisplay {

    @Test
    public void shouldFormatUsageProperly() {
        ByteArrayOutputStream output = new ByteArrayOutputStream();
        Display display = new Display(output);

        display.showUsage();

        verifyUsage(output.toString());
    }

    private void verifyUsage(String output) {
        verifyText(output, Display.COMMAND_LINE_USAGE);
        for (Parameter eachParameter : Parameter.values()) {
            verifyText(
                    output, 
                    Display.PARAMETER_DETAILS, 
                    eachParameter.shortName(), 
                    eachParameter.longName(), 
                    eachParameter.description());
        }

    }

    private void verifyText(String text, String format, Object... values) {
        String patternText = String.format(format, values);
        Pattern pattern = Pattern.compile(patternText, Pattern.LITERAL);
        Matcher matcher = pattern.matcher(text);
        String error = String.format("Could not match pattern '%s' in text '%s'", patternText, text);
        assertTrue(error, matcher.find());

    }

}
