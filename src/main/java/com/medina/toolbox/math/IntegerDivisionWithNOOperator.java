package com.medina.toolbox.math;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class IntegerDivisionWithNOOperator {

	private static Logger log = LoggerFactory.getLogger(IntegerDivisionWithNOOperator.class);
	
	/*
	 * RECURSIVE SOLUTION (x/y)
	 * 
	 * Base case: if x < y, return 0
	 * 
	 * Recursive step: return 1 + (x - y)/y
	 * 
	 * If we find the largest k so that (2**k)*y <= x, the recursive step is:
	 * 
	 * x/y = 2**k + (x - 2**k*y)/y
	 * 
	 */

	public static int simpleIntegerDivision(int x, int y) {
		
		/* Base case */
		if (x < y) {
			return 0;
		}
		
		/* STEP #1: Find the first power of 2 / 2^k > x*/
		int power = 0;
		while ((1 << power) * y <= x) {
			power += 1;
		}
		
		int firstPart = 1 << (power - 1);
		
		return firstPart + simpleIntegerDivision(x - firstPart * y, y);
		
	}
	
	public static void main(String[] args) {

		log.info("x: {} y: {} A: {}", new Object[] {30, 6, simpleIntegerDivision(30, 6)});
		log.info("x: {} y: {} M: {}", new Object[] {50, 4, simpleIntegerDivision(50, 4)});
		log.info("x: {} y: {} M: {}", new Object[] {50, 11, simpleIntegerDivision(55, 11)});

	}

}
