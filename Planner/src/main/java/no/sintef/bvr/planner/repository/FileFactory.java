
package no.sintef.bvr.planner.repository;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;

/**
 * Open input or output streams to files on local disk
 */
public class FileFactory implements Factory {

    @Override
    public InputStream asInput(String location) throws IOException {
        return new FileInputStream(location);
    }

    @Override
    public OutputStream asOutput(String location) throws IOException {
        return new FileOutputStream(location);
    }
    
}
