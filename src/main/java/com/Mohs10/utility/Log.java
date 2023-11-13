package com.Mohs10.utility;

import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;

public class Log
{
	// Initialize Log4j logs
	public static Logger Log = LogManager.getLogger(Log.class);

	public static void startTestCase(String TestCaseName){
		 Log.info("====================================="+TestCaseName+" TEST START=========================================");
		 }

	public static void endTestCase(String TestCaseName){
		Log.info("====================================="+TestCaseName+" TEST END=========================================");
		 }

	// Need to create below methods, so that they can be called

	 public static void info(String message) {

			Log.info(message);

			}

	 public static void warn(String message) {

	    Log.warn(message);

		}

	 public static void error(String message) {

	    Log.error(message);

		}

	 public static void fatal(String message) {

	    Log.fatal(message);

		}

	 public static void debug(String message) {

	    Log.debug(message);

		}
}
