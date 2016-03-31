
package no.sintef.bvr.planner.repository;

/**
 * Exception thrown when something goes wrong while reading
 */
public class ReaderException extends Exception {
    
    public ReaderException(String location, Throwable cause) {
        super(location, cause);
    }    

    public ReaderException(String error) {
        super(error);
    }    
    
}
