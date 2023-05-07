package com.logger.ejb;

import javax.ejb.Remote;

/**
 *
 * @author Devmi
 */
@Remote
public interface LoggerSessionBeanRemote {

    //defines 2 methods to record a message to a file and to log error messages for the errors that might arise.
    public void logMessageToFile(String message);
    public void logErrorMessage(String message);
}