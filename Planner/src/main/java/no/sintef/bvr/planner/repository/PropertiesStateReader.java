package no.sintef.bvr.planner.repository;

import java.io.IOException;
import java.io.InputStream;
import java.util.Collection;
import java.util.HashMap;
import java.util.Map;
import java.util.Properties;
import java.util.Set;
import no.sintef.bvr.planner.FeatureSet;
import no.sintef.bvr.planner.State;
import no.sintef.bvr.planner.Status;

/**
 * Read states from properties file (*.properties)
 */
public class PropertiesStateReader implements StateReader {

    private final Map<String, Status> statuses;

    public PropertiesStateReader() {
        statuses = new HashMap<>();
        statuses.put("negative", Status.NEGATIVE);
        statuses.put("-", Status.NEGATIVE);        
        
        statuses.put("positive", Status.POSITIVE);
        statuses.put("+", Status.POSITIVE);
        
        statuses.put("pending", Status.PENDING);
        statuses.put("?", Status.PENDING);
        statuses.put("0", Status.PENDING);
        
    }

    @Override
    public State readFrom(InputStream source) throws ReaderException {
        try {
            Properties properties = readProperties(source);
            FeatureSet features = extractFeatureSet(properties);
            Status[] statuses = extractStatuses(properties);
            return new State(features, statuses);

        } catch (IOException ex) {
            throw new ReaderException("Unable to read input stream", ex);
        }
    }

    private Properties readProperties(InputStream source) throws IOException {
        Properties properties = new Properties();
        properties.load(source);
        return properties;
    }

    private FeatureSet extractFeatureSet(Properties properties) {
        return new FeatureSet(properties.stringPropertyNames());
    }

    private Status[] extractStatuses(Properties properties) throws ReaderException {
        Status[] statuses = new Status[properties.size()];
        int featureIndex = 0;
        for (String eachFeature : properties.stringPropertyNames()) {
            String statusText = properties.getProperty(eachFeature);
            statuses[featureIndex] = parseStatus(eachFeature, statusText);
            featureIndex++;
        }
        return statuses;
    }

    private Status parseStatus(String feature, String statusText) throws ReaderException {
        final String escapedStatus = statusText.trim().toLowerCase();
        final Status status = statuses.get(escapedStatus);
        if (status == null) {
            final String error = String.format(INVALID_STATUS, feature, statusText);
            throw new ReaderException(error);
        }
        return status;
    }

    public static final String INVALID_STATUS = "Invalid status '%2$s' for feature '%1$s'";

}

