package no.sintef.bvr.planner.repository;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import no.sintef.bvr.planner.State;

public class FakeStateReader implements StateReader {

    public static final String GOAL_MARKER = "goal";
    public static final String ORIGIN_MARKER = "origin";

    private State origin;
    private State goal;

    public FakeStateReader(State origin, State goal) {
        this.origin = origin;
        this.goal = goal;
    }
    
    public void setOrigin(State origin) {
        this.origin = origin;
    }
    
    public void setGoal(State goal) {
        this.goal = goal;
    }

    @Override
    public State readFrom(InputStream source) throws ReaderException {
        try {
            final String data = contentFrom(source);
            switch (data) {
                case ORIGIN_MARKER:
                    return origin;
                case GOAL_MARKER:
                    return goal;
                default:
                    throw new RuntimeException("Unknown data marker '" + data + "'");
            }
        } catch (IOException error) {
            throw new ReaderException("Unable to fetch content", error);
        }
    }

    private String contentFrom(InputStream source) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(source));
        StringBuilder buffer = new StringBuilder();
        String line = "";
        while (reader.ready()) {
            line = reader.readLine();
            buffer.append(line);
        }
        return buffer.toString();
    }

}
