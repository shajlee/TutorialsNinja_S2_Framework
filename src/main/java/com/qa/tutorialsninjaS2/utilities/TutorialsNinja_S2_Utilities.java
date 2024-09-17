package com.qa.tutorialsninjaS2.utilities;

import java.util.Date;

public class TutorialsNinja_S2_Utilities {
	
	
	
	public static String generateEmailWithTimeStamp() {
		Date date = new Date();
		String emailTimeStamp = date.toString().replace("", "_").replace(":", "_");
		return "shajlee" +emailTimeStamp+ "@yahoo.com";
	}
	public static CharSequence generatePasswordWithTimeStamp() {
		Date date1 = new Date();
		String passwordTimeStamp = date1.toString().replace("", "_").replace(":", "_");
		return "Potter" +passwordTimeStamp+ "1@";
	}
	public static String generateRegistrationEmailWithTimeStamp() {
		Date date2 = new Date();
		String registrationEmailTimeStamp = date2.toString().replace("","_").replace(":", "_");
		return "aniqa" +registrationEmailTimeStamp+ "@hotmail.com";
	}
	public static String generateRegistrationPasswordWithTimeStamp() {
		Date date3 = new Date();
		String registrationPassworTimeStamp = date3.toString().replace("", "_").replace(":", "_");
		return "Hello" +registrationPassworTimeStamp+ "1";
	}
	public static final int IMPLICIT_WAIT_TIME = 10;
	public static final int PAGELOAD_WAIT_TIME = 10;
	public static final int SCRIPTLOAD_WAIT_TIME = 10;
	
		
		
	}


