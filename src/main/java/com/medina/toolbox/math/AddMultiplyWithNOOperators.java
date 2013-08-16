package com.medina.toolbox.math;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class AddMultiplyWithNOOperators {

	private static Logger log = LoggerFactory.getLogger(AddMultiplyWithNOOperators.class);
	
			
	public static int simpleAdd(int a, int b) {
	
		int sum = 0;
		int carryIn = 0;
		int k = 1;
		
		while (k > 0) {
			
			/* Isolate kth bit in a */
			int ak = a & k;
			
			/* Isolate kth bit in b */
			int bk = b & k;
			
			/* Determine if there is a carryOut bit */
			int carryOut = (ak & bk) | (ak & carryIn ) | (bk & carryIn);
			
			/* Compute kth bit of sum */
			sum = sum | (ak ^ bk ^ carryIn);
			
			/* Determine if there is a carryIn bit for next digit's sum */
			carryIn = carryOut << 1;
			
			/* Advance to next bit */
			k = k << 1;			
			
		}
		
		return sum;
		
	}
	
	public static int simpleSubtract(int x, int y) {
		
		boolean isNegative = false;
		int a = x, b = y;
		
		if (x < y) {
			a = y;
			b = x;			
			isNegative = true;
		}
		
		b = ~b + 1;
		
		int sum = simpleAdd(a, b); 
				
		return (isNegative)?-sum:sum;
		
	}
	
	public static int extendedSimpleAdd(int a, int b) {
				
		if (a > 0 && b > 0) {
			return simpleAdd(a, b);
		}
		
		if (a > 0 && b < 0) {			
			return simpleSubtract(a, -b);			
		}
		
		if (a < 0 && b > 0) {
			return simpleSubtract(b, -a);
		}
				
		return -simpleAdd(-a, -b);
		
	}
	
	public static int simpleMultiply(int x, int y) {

		int scaledY = y;		
		int sum = 0;
		int k = 1;
		
		while (k > 0) {		
			
			/* Isolate kth bit in x */
			int kthBit = x & k; 
			
			if (kthBit > 0) {
				sum = simpleAdd(sum, scaledY);
			}
			
			scaledY = scaledY << 1;
			
			/* Advance "next" bit to be processed */
			k = k << 1;
		}
		
		return sum;
		
	}
	
	public static void main(String[] args) {
		
		int x = 4;
		int y = 4;
		log.info("MULT: x: {} y: {} M: {}", new Object[] {x, y, simpleMultiply(x, y)});
		
		x = 8;
		y = 74;
		log.info("MULT: x: {} y: {} M: {}", new Object[] {x, y, simpleMultiply(x, y)});
		
		x = 8;
		y = 12;
		log.info("SUBTRACT: x: {} y: {} A: {}", new Object[] {x, y, simpleSubtract(x, y)});
		
		x = 8;
		y = -74;
		log.info("ADD: x: {} y: {} A: {}", new Object[] {x, y, extendedSimpleAdd(x, y)});
		
		x = 5;
		y = -37;
		log.info("ADD: x: {} y: {} A: {}", new Object[] {x, y, extendedSimpleAdd(x, y)});
		
		x = -5;
		y = 37;
		log.info("ADD: x: {} y: {} A: {}", new Object[] {x, y, extendedSimpleAdd(x, y)});

		x = -5;
		y = -37;
		log.info("ADD: x: {} y: {} A: {}", new Object[] {x, y, extendedSimpleAdd(x, y)});

		y = 5;
		x = -37;
		log.info("ADD: x: {} y: {} A: {}", new Object[] {x, y, extendedSimpleAdd(x, y)});
		
		y = -5;
		x = 37;
		log.info("ADD: x: {} y: {} A: {}", new Object[] {x, y, extendedSimpleAdd(x, y)});

		y = -5;
		x = -37;
		log.info("ADD: x: {} y: {} A: {}", new Object[] {x, y, extendedSimpleAdd(x, y)});

		
	}

}
