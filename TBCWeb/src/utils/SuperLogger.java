package utils;

 
import org.apache.log4j.Logger;

import java.io.Serializable;

import org.apache.log4j.LogManager;


public class SuperLogger implements Serializable {
	public static final Logger logger = 
			LogManager.getLogger(SuperLogger.class.getName());
	

}