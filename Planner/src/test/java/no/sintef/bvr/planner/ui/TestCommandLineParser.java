package no.sintef.bvr.planner.ui;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import no.sintef.bvr.planner.Settings;
import org.junit.Test;
import static org.junit.Assert.*;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;

@RunWith(Parameterized.class)
public class TestCommandLineParser {

    static final String NOT_THE_DEFAULT_VALUE = "foo_input.txt";

    @Parameterized.Parameters(name="{0}")
    public static Collection<Object[]> createDataTable() {
        List<Object[]> table = new ArrayList<>(Parameter.values().length);
        for (Parameter eachParameter : Parameter.values()) {
            table.add(new Object[]{eachParameter});
        }
        return table;
    }

    private final Parameter parameter;

    public TestCommandLineParser(Parameter parameter) {
        this.parameter = parameter;
    }

    @Test
    public void shouldSupportShortName() throws UnknownArgumentException, InvalidArgumentException {
        Settings argument = parse(parameter.shortName(), NOT_THE_DEFAULT_VALUE);
        verifyArguments(argument, parameter, NOT_THE_DEFAULT_VALUE);
    }

    @Test
    public void shouldSupportLongName() throws UnknownArgumentException, InvalidArgumentException {
        Settings argument = parse(parameter.longName(), NOT_THE_DEFAULT_VALUE);
        verifyArguments(argument, parameter, NOT_THE_DEFAULT_VALUE);
    }
    
    @Test(expected = InvalidArgumentException.class)
    public void shouldRejectMissingValue() throws UnknownArgumentException, InvalidArgumentException {
        parse(parameter.longName());
    }

    private Settings parse(String... arguments) throws UnknownArgumentException, InvalidArgumentException {
        return new CommandLineParser().extractSettingsFrom(arguments);
    }

    private void verifyArguments(Settings arguments, Parameter parameter, String expectedValue) {
        for (Parameter eachParameter : Parameter.values()) {
            final String eachActualValue = eachParameter.getFrom(arguments); 
            if (eachParameter.equals(parameter)) {
                assertEquals(expectedValue, eachActualValue);
            } else {
                assertEquals(eachParameter.defaultValue(), eachActualValue);
            }
        }
    }
}
