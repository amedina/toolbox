package com.medina.toolbox.strings;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

import org.junit.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class StringConversions {

	private static Logger log = LoggerFactory.getLogger(StringConversions.class);
	
	/*
	 * Take into account negative numbers; throw exception on wrong input
	 * 
	 * For a positive integer x, iteratively divide x by 10 and record the
	 * remainder till we get 0; this yields the result from the LSB and it must
	 * be reversed.
	 * 
	 * If x is negative, record that and add a '-' at the end.
	 * 
	 * If x is 0, the 'regular' path in the code will not be executed and we
	 * need to consider that specific by its own.
	 */
	
	public static String intToString(int x) {
		
		boolean isNegative = false;
		
		/* Determine sign of given integer */
		if (x < 0) {
			x = -x;
			isNegative = true;
		}
		
		StringBuilder s = new StringBuilder();
				
		/*
		 * Iteratively compute every digit of result by computing the remainder
		 * of the current value of the int and the radix; Divide number by ther
		 * radix at each iteration
		 */
		while (x > 0) {
			s.append(x % 10);
			x /= 10;
		}
		
		if (s.length() == 0) {
			s.append("0");
		}
		
		if (isNegative) {
			s.append("-");
		}
		
		s = s.reverse();
		
		return s.toString();
		
	}
	
	public static int stringToInt(String s) throws IllegalArgumentException {
		
		/*
		 * (1) Determine if number should be negative (and starting index for
		 * processing the rest of the String.
		 */
		
		boolean isNegative = false;
		if (s.length() > 1 && s.charAt(0) == '-') {
			isNegative = true;
		}
		
		/*
		 * (2) Iterate over all characters of the string, and construct the resulting
		 * number; if any of the characters is not a digit, throw Exception
		 */
		int x = 0;
		for (int i = (isNegative?1:0); i < s.length(); i++) {
						
			Character c = s.charAt(i);			
			if (Character.isDigit(c)) {							
				x = x  * 10  +  Integer.valueOf(c) - '0';
			}else {
				throw new IllegalArgumentException();
			}

		}
		
		if (isNegative) {
			x = -x;
		}
		
		return x;
	}

	
	public int[] stringToDigits(String x) {
		
		boolean isNegative = (x.length() > 1 && x.charAt(0) == '-')?true:false;
		int capacity  = isNegative?x.length() - 1:x.length(); 
		int[] digits = new int[capacity];
		
		int i = 0;
		if (isNegative) {
			i = 1;
		}
		
		for (int k = x.length() - 1, j = 0; k >= i; k--, j++) {
			int d = Integer.valueOf(x.charAt(k)) - '0';
			digits[j] = d;
		}
		
		return digits;
	}
	
	public String digitsToString(int[] digits) {
		
		String r  = "";
		for (int i = 0; i < digits.length; i++) {
			r = String.valueOf(digits[i]) + r;
		}
		return r;
	}

	@Test
	public void testStringToInt() {

		log.info("Input EOF and press enter to end test...");

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		String searchString = null;

		while (true) {

			log.info("Enter non-negative integer as a String: ");
			try {
				searchString = br.readLine();
			} catch (IOException e) {
				log.error("IO Exception!");
			}

			if (searchString.toLowerCase().equals("eof")) {
				break;
			}
			
			String stringX = searchString;
						
			System.out.printf("stringToInt: stringX: %s x: %d\n", stringX, stringToInt(stringX));
				
		}		
	}
	
	@Test
	public void testToIntString() {

		log.info("Input EOF and press enter to end test...");

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		String searchString = null;
		Integer x = 0;
		while (true) {

			log.info("Enter non-negative integer: ");
			try {
				searchString = br.readLine();				
			} catch (IOException e) {
				log.error("IO Exception!");
			}

			if (searchString.toLowerCase().equals("eof")) {
				break;
			}
			
			x = Integer.valueOf(searchString);
						
			System.out.printf("stringToInt: X: %d stringX: %s\n", x, intToString(x));
			
			
		}		
	}
		
	public void testIntToString() {
		int x = 1575;
		String xStr = StringConversions.intToString(x);
		int backX = StringConversions.stringToInt(xStr);
		
		System.out.printf("X: %d\nxStr: %s\nbackX: %d", x, xStr, backX);
	}
	
	public void mainTest() {
		
		StringConversions sc = new StringConversions();
		sc.testStringToInt();
	
	}

}
