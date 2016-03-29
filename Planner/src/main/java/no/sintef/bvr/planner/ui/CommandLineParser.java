
package no.sintef.bvr.planner.ui;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import no.sintef.bvr.planner.Settings;

/**
 *
 * @author franckc
 */
public class CommandLineParser {
    
    Settings extractSettingsFrom(String... commandLine) throws UnknownArgumentException, InvalidArgumentException {
        final Settings settings = Settings.defaultSettings();
        final List<String> values = new ArrayList<>(Arrays.asList(commandLine));
        while (!values.isEmpty()) {
           Parameter parameter = matchNext(values);
           parameter.setIn(settings, values);
        }
        return settings;
    }

    
    private static Parameter matchNext(List<String> tokens) throws UnknownArgumentException {
        final String key = tokens.get(0);
        for (Parameter eachParameter: Parameter.values()) {
            if (eachParameter.match(key)) {
                return eachParameter;
            }
        }
        throw new UnknownArgumentException(key);
    }
 
    
}
