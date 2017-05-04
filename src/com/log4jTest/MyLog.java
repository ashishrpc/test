package com.log4jTest;

import org.apache.log4j.Logger; 
public class MyLog {
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.out.println("MyLog.....");
		Logger logger = Logger.getLogger(MyLog.class);
		logger.debug("My implemented log....");
	}

}
