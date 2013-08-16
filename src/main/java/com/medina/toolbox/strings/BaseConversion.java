package com.medina.toolbox.strings;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class BaseConversion {
	
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
	
	
	public static String intToString(int x, int radix) {
		
		StringBuilder s = new StringBuilder();
		boolean isNegative = false;
		
		/* Step 0: If input == 0, return "0" */
		if (x == 0) {
			return "0";
		}
		
		/* Step 1:  Determine sign of given integer */
		if (x < 0) {
			x = -x;
			isNegative = true;
		}
				
		/*
		 * Step 2: Each iteration:
		 * (1) compute next digit of result as the remainder of the current value and the radix; 
		 * (2) Divide number by the radix
		 * 
		 */
		while (x > 0) {
			s.append(x % radix);
			x /= radix;
		}
		
		if (isNegative) {
			s.append("-");
		}
		
		s = s.reverse();
		
		return s.toString();
		
	}

	/*
	 * stringToInt: converts a number in base radix entered as a string into its
	 * value in base 10
	 */
	public static int stringToInt(String s, int radix) throws IllegalArgumentException {
		
		/*
		 * (1) Determine if number should be negative (and starting index for
		 * processing the rest of the String.
		 */
		
		boolean isNegative = false;
		if (s.length() > 1 && s.charAt(0) == '-') {
			isNegative = true;		
		}
		
		int x = 0;
		
		for (int i = (isNegative? 1:0); i < s.length(); i++) {
						
			Character c = s.charAt(i);
			int t;
			if (Character.isDigit(c)) {
				t = Integer.valueOf(c) - '0';					
			}else {
				t = Integer.valueOf(c) - 'A' + 10;
			}

			if (t >= radix) {
				throw new IllegalArgumentException();
			}
			
			x = x * radix  +  t;
		
		}
		
		if (isNegative) {
			x = -x;
		}
		
		return x;
	}
	
	
	public static String baseConversion(int b1, String x, int b2) {
		
		int xB10 = stringToInt(x, b1);
		String xB2 = intToString(xB10, b2); 
				
		return xB2;
	}

	
	public static void main(String args[]) {

		int b1 = 2;
		int b2 = 10;
		String x = "10000000000";
		String conv = BaseConversion.baseConversion(b1, x, b2);		
		System.out.printf("baseConversion -- x: %s b1: %d b2: %d conv: %s\n", new Object[] {x, b1, b2, conv});
		
		String xAsString = "589";
		int xAsInt = BaseConversion.stringToInt(xAsString, 10);
		System.out.printf("xAsString: %s xAsInt: %d\n", xAsString, xAsInt);
		
		
	
	}
	

}
