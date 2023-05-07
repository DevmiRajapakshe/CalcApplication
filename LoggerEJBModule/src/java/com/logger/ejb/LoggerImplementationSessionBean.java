package com.logger.ejb;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.logging.Logger;
import java.util.logging.FileHandler;
import java.util.logging.SimpleFormatter;
import java.util.logging.Level;
import javax.ejb.Stateless;
/**
 *
 * @author Devmi
 */
@Stateless
public class LoggerImplementationSessionBean implements LoggerSessionBeanRemote {
    
    private static final Logger logger = Logger.getLogger(LoggerImplementationSessionBean.class.getName());
    private String fileName = "";

    public LoggerImplementationSessionBean() {
        this.fileName = "history.txt";
        SimpleFormatter simpleFormatter = new SimpleFormatter();
        try {
            //logging to file
            FileHandler handler = new FileHandler("logdata.log", true);
            handler.setFormatter(simpleFormatter);
            //add handler and logging level to the logger
            logger.addHandler(handler);
            logger.setLevel(Level.ALL);
        } catch (IOException e) {
            System.err.println(e.getMessage());
        }
    }
    
    public LoggerImplementationSessionBean(String fileName) {
        this.fileName = fileName;
        SimpleFormatter simpleFormatter = new SimpleFormatter();
        try {
            //logging to file
            FileHandler handler = new FileHandler("logdata.log", true);
            handler.setFormatter(simpleFormatter);
            //add handler and logging level to the logger
            logger.addHandler(handler);
            logger.setLevel(Level.ALL);
        } catch (IOException e) {
            System.err.println(e.getMessage());
        }
    }
    

    //used to record needed messages to a required file.
    @Override
    public void logMessageToFile(String message) {
        try {
            PrintWriter printWriter;
            try (FileWriter writer = new FileWriter(fileName, true)) {
                printWriter = new PrintWriter(writer);
                printWriter.println(message);
            }
            printWriter.close();
        } catch (IOException e) {
            System.err.println("Error occurred when writing to the file: " + e.getMessage());
            logger.log(Level.SEVERE, e.getMessage());
        }
    }

    //used to log error messages that may arise
    @Override
    public void logErrorMessage(String message) {
        logger.log(Level.SEVERE, message);
    }
    
    
}