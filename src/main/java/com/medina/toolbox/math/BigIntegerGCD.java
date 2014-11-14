package com.medina.toolbox.math;

import java.math.BigInteger;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/*
 * The GCD(x,y) is  is the largest positive integer that divides both numbers without a remainder;
 * 
 * APPROACH: The solution to this problem is based on RECURSION.
 * 
 * Base case: if (x == 0): return y; if (y == 0): return x
 * 
 * if (x == 0 || y== 0)
 * 	return 0;
 * 
 * if (x%2 == 0 and y%2 == 0)
 * 	 return 2 * GCD(x/2, y/2)
 * 
 * if (x%2 == 0 and y%2 != 0) 
 * 	 return GCD(x/2, y);
 * 
 * if (x%2 != 0 and y%2 == 0) 
 * 	 return GCD(x, y/2);
 * 
 * if (x%2 != 0 and y%2 != 0):
 * 	if (x > y)
 * 		return GCD(x - y, y);
 * 
 *  if (y > x)
 *  	return GCD(x, y - x);
 */

public class BigIntegerGCD {

//	private static LogManager log = LoggerFactory.getLogger(BigIntegerGCD.class);

	private static BigInteger TWO = new BigInteger("2");

	public static boolean isOdd(BigInteger x) {
		return x.testBit(0);
	}

	public static boolean isEven(BigInteger x) {
		return !x.testBit(0);
	}

	public static BigInteger GCD(BigInteger x, BigInteger y) {

		if (x.equals(BigInteger.ZERO)) {
			return y;
		}

		if (y.equals(BigInteger.ZERO)) {
			return x;
		}

		if (isEven(x) && isEven(y)) {

			x = x.shiftRight(1);
			y = y.shiftRight(1);

			return TWO.multiply(GCD(x, y));

		}

		if (isOdd(x) && isEven(y)) {
			return GCD(x, y.shiftRight(1));
		}

		if (isEven(x) && isOdd(y)) {
			//return GCD(y, x.shiftRight(1));
			return GCD(x.shiftRight(1), y);
		}

		if (x.compareTo(y) <= 0) {
			return GCD(x, y.subtract(x));
		} else {
			return GCD(y, x.subtract(y));
		}

	}

	public static void main(String[] args) {

		BigInteger x = new BigInteger("12");
		BigInteger y = new BigInteger("6");

		System.out.println("x: " + x + " y: " + y + " GCD: " + GCD(x, y));

	}

}
