
package no.sintef.bvr.planner.repository;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;

/**
 * Abstract the dependence on the File System
 */
public class FileSystem {
    
    public InputStream asInput(String location) throws IOException {
        return new FileInputStream(location);
    }
    
    public OutputStream asOutput(String location) throws IOException {
        return new FileOutputStream(location);
    }
    
}
