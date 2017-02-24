package utils;

import java.io.Serializable;

import org.apache.log4j.Level;

public class ApplicationException extends Exception implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public ApplicationException(){
		super();
		SuperLogger.logger.error("Empty exception");
	}
	
	public ApplicationException(String message){
		super(message);
		SuperLogger.logger.log(Level.ERROR, message);
	}
	
	public ApplicationException(String message, Throwable cause){
		super(message,cause);
		SuperLogger.logger.log(Level.ERROR, message, cause);
		
	}
}