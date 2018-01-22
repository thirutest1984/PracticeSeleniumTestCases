package com.practice.java;

public class StringsOperations {

	public static void main(String[] args) {


		String str1 = "This World is Very Nice.";
		
		// Display
		System.out.println(str1);
		
		// to lower case
		System.out.println(str1.toLowerCase());
		
		// to upper case
		System.out.println(str1.toUpperCase());
		
		// string length
		System.out.println(str1.length());
		
		// retrieve index 5 character
		System.out.println(str1.charAt(5));
		
		// retrieve index of char 'W'
		System.out.println(str1.indexOf("W"));
		
		// retrieve index of first i char
		System.out.println(str1.indexOf('i'));
		
		// retrieve index of 2nd most i char
		System.out.println(str1.indexOf("i",3));
		
		// retrieve index of 3rd most i char
		System.out.println(str1.indexOf("i", 12));
		
		// display string string from 5 to 12 indexes
		System.out.println(str1.substring(5, 13));
		System.out.println(str1.substring(11));
		System.out.println(str1.substring(12, 24));
		
		String[] sstr = str1.split("Very");
		System.out.println(sstr[0]);
		System.out.println(sstr[1]);
		
		String str2 = " And Very Beatiful.";
		String str3 = " And very beatiful.";

		
		System.out.println(str1.equals(str2));
		System.out.println(str2.equals(str3));
		System.out.println(str2.equalsIgnoreCase(str3));
		
		System.out.println(str2.trim());
		
		int j = 50;
		String strval = String.valueOf(j);
		System.out.println(strval);
		
		System.out.println(Integer.parseInt(strval));
		
		
		
	}

}
