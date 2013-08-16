package com.medina.toolbox.math;

import java.util.Random;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/* Many applications require arbitrary-precision arithmetic.
 * 
 * One way to achieve this is represent numbers as strings and 
 * implement arithmetic operations in terms of them. 
 * 
 * A BigInt is defined as a class with three (3) data members:
 * 
 * (1) Sign: weather the number is positive or negative
 * (2) String: string representation of the associated number
 * (3) Digits: array of digits associated with the number 
 */

public class BigInt {

	private static Logger log = LoggerFactory.getLogger(BigInt.class);

	private String s;
	private int sign;
	private int[] digits;
	
	/* A BigInt string can be constructed empty" */
	public BigInt(int capacity) {
		this.sign = 1;
		digits = new int[capacity];
		this.s = new String();
	}
	
	/* Construct a BigInt from a specific String */
	public BigInt(String s) throws IllegalArgumentException {
		/*
		 * Determine sign of the BigInt based on the first character of the
		 * string
		 */
		this.sign = (s.charAt(0) == '-') ? -1 : 1;
	
		setString(s);
		
		stringToDigits(s);
		
	}
	
	public int[] stringToDigits(String x) {
		
		boolean isNegative = (x.length() > 1 && x.charAt(0) == '-')?true:false;
		int capacity  = isNegative?x.length() - 1:x.length(); 
		this.digits = new int[capacity];
				
		for (int i = x.length() -  1, j = 0; i >= (isNegative ? 1 : 0); i--, j++) {
			if (Character.isDigit(x.charAt(i))) {
				digits[j] = x.charAt(i) - '0';
			}else {
				throw new IllegalArgumentException();
			}
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
	
	public String digitsToString() {
		
		String r  = "";
		for (int i = 0; i < digits.length; i++) {
			r = String.valueOf(digits[i]) + r;
		}
		return r;
	}

	public void setString(String s) {
		this.s = s;
	}
	
	public int getSign() {
		return sign;
	}
	
	public int size() {
		return digits.length;
	}
	
	public void setSign(int sign) {
		this.sign = sign;
	}
	
	public boolean testCharZero() {
		if (s.charAt(0) == '0') {
			return true;
		}else {
			return false;
		}
	}
	
	public String toString() {
		return s;
	}
	
	/*
	 * Mimic basic multiplication procedure: - Shift, Multiply by a digit, Add -
	 * Number of digits required: n + m OR n + m - 1 - Add partial products as
	 * they are produced
	 * 
	 * One key aspect of BigInt arithmetic is the processing of intermediate
	 * results; process intermediate results as they are produced rather
	 * than storing them and processing them at the end.
	 */
	public static BigInt bigIntegerMult(BigInt x, BigInt y) {	
				
		/* If one of the numbers is 0, return 0 */
		if (x.size() == 1 && x.testCharZero()) {
			return new BigInt("0");
		}
		
		if (y.size() == 1 && y.testCharZero()) {
			return new BigInt("0");
		}
		
		/* Define result: with proper size and sign */
		BigInt result = new BigInt(x.size() + y.size());		
		result.setSign(x.getSign() * y.getSign());
		
		/* Iterate first over the multiplicand */
		for (int i = 0; i < y.size(); i++) {
					
			if (y.digits[i] == 0) { continue; }
			
			int carryOn = 0;
			
			/* Iterate second through the source */
			for (int j = 0; j < x.size() || carryOn > 0; j++) {
				
				/* Grab current value of target digit for this iteration */
				int currDigit = result.digits[i + j]; 
				
				if (j < x.size()) {
					currDigit = currDigit + (y.digits[i] * x.digits[j]) + carryOn;
				}else {
					currDigit = currDigit + carryOn;
				}
				
				result.digits[i + j] = currDigit % 10;
				carryOn = currDigit / 10;
			}
		}

		result.setString(result.digitsToString());
		
		return result;
		
	}
	
	public static void main(String[] args) {
	
		BigInt x = new BigInt("123423432432432432432432423423534");
		BigInt y = new BigInt("123423432432432432432432423423534");
		
			
		BigInt res = BigInt.bigIntegerMult(x, y);
		
		log.info("X: {} Y: {} Res: {}", new Object[] {x.toString(), y.toString(), res});
		
		
	}

}
