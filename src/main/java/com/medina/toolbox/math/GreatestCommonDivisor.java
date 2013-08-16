package com.medina.toolbox.math;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class GreatestCommonDivisor {
	
	private static Logger log = LoggerFactory.getLogger(GreatestCommonDivisor.class);
	

	
	public static int fnNegate(int x) {
		
		int neg = 0;
		int d = (x < 0) ? 1 : -1;
		
		while (x != 0) {			
			neg += d;
			x += d;
		}
		
		return neg;
		
	}
	
	public static int fnNegateBitwise(int x) {		
		int neg = x ^ (1 << 31);
		return neg;
	}
	
	public static int simpleMultiply(int x, int y) {
		
		int result = 0;
		for (int i = 0; i < y; i++) {
			result += x;
		}
		
		return result;
	}
	
	public static int simpleSubtraction(int x, int y) {
		
		return x + -y;
	}
	
	public static int simpleDivision(int x, int y) {
		
		int result = x;
		int c = 0;
		while (result > 0) {
			result = simpleSubtraction(result, y);
			c += 1;
		}
		return c;
	}

	private static boolean dDividesX(int d, int x) {
		
		int k = 0;
		while (k < x) {			
			k += d;
		}
		
		if (k == x) {
			return true;
		}
		
		return false;
	}
	
	private static int getGCD(int x, int y) {
		
		int d = 1;
		int gcd = -1;
		while (d <= x) {
			
			if (dDividesX(d, x) && dDividesX(d, y)) {
				gcd = d;	
			}
			
			d += 1;
		}
		
		return gcd;
	}
	
	public static int pearlGCD(int a, int b) {
		
		if (b == 0) {
			return a;
		}
		
		return pearlGCD(b, a % b);
		
	}
	
	
	public static void main(String[] args) {

		int x = 36;
		int y = 16;
		
		log.info("x:{} y: {} gcd: {}", new Object[] { x, y, getGCD(x, y)});
		log.info("x:{} y: {} pearlGCD: {}", new Object[] { x, y, pearlGCD(x, y)});

		log.info("x: {} fnNegate: {}", new Object[] { x, fnNegate(x)});
		log.info("x: {} fnNegateBitwise: {}", new Object[] { x, fnNegateBitwise(x)});
		log.info("x: {} y: {} simpleMultiply: {}", new Object[] { x, y, simpleMultiply(x, y)});
		log.info("x: {} y: {} simpleSubtraction: {}", new Object[] { x, y, simpleSubtraction(x, y)});
		log.info("x: {} y: {} simpleDivision: {}", new Object[] { x, y, simpleDivision(x, y)});
	}

}
