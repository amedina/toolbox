package com.medina.toolbox.bits;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.medina.toolbox.arrays.PrintArray;

/*
 * Notes on Java primitive types:
 * 	1. Decimal literals are all positive (must use - to express a negative one)
 *		Not the same case for octal and hexadecimal literals.
 *	2. Mixed-type computation: e.g. int and long; java promotes the int to long 
 *		(widening primitive conversion).
 */

public class BitManipulation {

	private static Logger log = LoggerFactory.getLogger(BitAlgorithms.class);

	public static long unsetRightmostSetBit(long x) {

		return x & (x - 1);
	}

	/*
	 * Isolate rightmost bit set.
	 * 
	 * Makes use of two's complement binary representation of negative numbers:
	 * 
	 * 				-x = ~x + 1 
	 * 
	 * There are two possible cases:
	 * 
	 * (1) There is a rightmost bit, bi, set to 1: all the bits to the right of
	 * that bit are 0. Then, ~x turns bi to 0, and all the bits to the right to
	 * 1. Since bits are all set to 1, adding one produces a carry-out all the
	 * way up to bit bi, which is the first bit set to 0. The result of -x is
	 * that all the bits to the left of bi get inverted, bi stays the same, and
	 * all the bits to the right of bi are set to 0. The AND then sets all the
	 * bits except bi to 0.
	 */
	public static long getRightmostSetBit(long x) {
		return x & (-x);	
	}
	
	public static long getRightmostSetBitTwo(long x) {
		return x & ~(x - 1);	
	}
	
	/*
	 * Returns a value in which all bits are set to 0, and the bit in the
	 * position of the rightmost unset bit is set to 1. Proof: Suppose there is
	 * a rightmost 0-bit. Then ~x turns this rightmost 0 bit into 1 bit. And so
	 * does x+1 (because bits more right to the rightmost 0 bit are 1's). Now
	 * AND-ing ~x with x+1 evaporates all the bits up to this rightmost 0 bit.
	 * This is the highest order bit set in the result. Now what about lower
	 * order bits to the right of rightmost 0 bit? They also got evaporated
	 * because because x+1 turned them into 0's (they were 1's) and ~x turned
	 * them into 0's. They got AND-ed with 0 and evaporated.
	 */
	public static long isolateRightMostUnsetBit(long x) {
		
		return ~x & (x + 1);
		
	}
	
	public static long setRightmostUnsetBit(long x) {
		
		return x | (x + 1);
		
	}

	/* Swap bits in positions i and j */
	public static long swapBits(long x, int i, int j) {

		if (((x >> i) & 1) != ((x >> j) & 1)) {

			x ^= ((1L << i) | (1L << j));
		}

		return x;
	}

	/* Propagate rightmost bit set to the right */
	public static long propagateRightmostBitSet(long x) {
		if (x == 0) {
			return x;
		} else {
			return x | (x - 1);
		}
	}

	/* Determine if given integer is odd */
	public static boolean isOdd(long x) {

		if ((x & 1) == 1) {
			return true;
		} else {
			return false;
		}
	}

	/* Isolate the most significant bit */
	public static int isolateMostSignificantBitIndex(long x) {
		
		long y =  x & ~(x - 1);
		
		double l = Math.log(y)/Math.log(2);
		log.info("y: {} lgy: {}", y, l);
		
		return (int) (Math.log(y)/Math.log(2));
	}
	
	public static boolean isNthBitSet(long x, int n) {

		return ((x & (1L << n)) != 0);
	}

	public static long setNthBit(long x, int n) {

		return x | (1L << n);
	}

	public static long unSetNthBit(long x, int n) {

		return x & ~(1L << n);
	}

	public static long toggleNthBit(long x, int n) {

		return x ^ (1L << n);
	}

	
	public static void printBinaryString(long x) {
		
		for (int i = 63; i >= 0; i--) {
			/* Isolate ith bit */
			long t = x >> i;
			if ((t & 1L) == 1) {
				System.out.printf("1");
			}else {
				System.out.printf("0");
			}
		}
		System.out.printf("\n");
	}
	
	/* Tell me if the nth bit is either 0 or 1 */
	public static long isolateNthBit(long x, int n) {
		
		return (x >> n) & 1L;
	}
	
	
	/*
	 * bitSwap: The key in this problem is first to determine if the bits at
	 * position i and j are different; if they are, then do an XOR between the
	 * given integer and an integer with a 1 at positions i and j; in this way,
	 * the bit that was 0 becomes 1, and the bit that was 1 becomes 0, because
	 * of the XOR operation
	 */
	public static long bitSwap(long x, int i, int j) {
		
		long a = isolateNthBit(x, i);
		long b = isolateNthBit(x, j);
		
		if (a != b) {
			 x ^= (1L << i) | (1L << j);
		}
		
		return x;		
		
	}
	
	/*
	 * Similar to computing parity.
	 * Fastest way is to maintain a data structure with pre-computed reversal values
	 */
	public static long bitReversal(long x) {
		
		int i = 0;
		int j = 63;
		
		while (i < j) {
			long a = isolateNthBit(x, i);
			long b = isolateNthBit(x, j);
			if (a != b) {
				x ^= (1L << i) | (1L << j);
			}
			i++;
			j--;
		}
		
		return x;
	}
	
	
	/*
	 * Given a integer X belonging to the set of integers whose bit values
	 * have k bits set to 1; Find another integer Y in the same set that 
	 * is closest to X
	 *   
	 * KEY IDEA:  iterate over all bits in x, and swap the first
	 * two consecutive bits that differ; this is the approach because the goal
	 * is to change the least significant bits possible so that the resulting
	 * number is as close as possible to the input number, consequently
	 * minimizing the difference.
	 */
	public static long closestWeightedElement(long x) {
		
		for (int i = 0; i < 63; i++) {
		
			if ((((x >> i) & 1L) ^ (((x >> (i + 1)) & 1L))) == 1) {
				
				return (x ^ ((1L << i) | (1L << (i + 1))));
				
			}			
		}
		return x;
	}
	
	
	public static int getbyte(int x, int idx)
	{
	    int y[] = {0,0,0,0};

	    y[3] = (x & 0xFF000000) >> 24; 
	    y[2] = (x & 0x00FF0000) >> 16; 
	    y[1] = (x & 0x0000FF00) >>  8; 
	    y[0] = (x & 0x000000FF); 

	    int i = idx & 3;
	    return y[i];
	}
	
	public static int getSingleNonRepeatedElement() {
		
		int[]  a ={1,1,1,2,3,11,3,2,3,2};

		int result = 0;
		for (int i = 0; i < 10; i++) {
			result = result ^ a[i];
		}
		
		System.out.printf("Array:\n");
		PrintArray.print(a);
		System.out.printf("Element: %d\n", result);
		
		return result;
		
	}
	
	public static void runTests() {
		log.info("Input EOF and press enter to end test...");

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		String searchString = null;


		while (true) {

			log.info("Enter non-negative integer:\n");
			try {
				searchString = br.readLine();
			} catch (IOException e) {
				log.error("IO Exception!");
			}

			if (searchString.toLowerCase().equals("eof")) {
				break;
			}

			long x = 0;
			try {
				x = Long.parseLong(searchString);
			} catch (NumberFormatException e) {
				log.error("Wrong input type!");
				continue;
			}

			int i = 6;
			int j = 5;
			log.info("x: {} i: {} j: {} swapped x: {}", new Object[] { x, i, j,
					swapBits(x, i, j) });

			log.info("x: {} x - 1: {} x without LSB: {}", new Object[] { x,
					x - 1, unsetRightmostSetBit(x) });

			log.info("x: {} x is Odd?: {}", x, isOdd(x));

			log.info("x: {} is {}-th bit set?: {}", new Object[] { x, 7,
					isNthBitSet(x, 7) });

			log.info("x: {} x with bit {} set: {}", new Object[] { x, 7,
					setNthBit(x, 7) });

			log.info("x: {} x with bit {} unset: {}", new Object[] { x, 7,
					unSetNthBit(x, 7) });

			log.info("x: {} x with bit {} toggled: {}", new Object[] { x, 7,
					toggleNthBit(x, 7) });

			log.info("x: {} rightMostSetBit Value: {}", new Object[] { x,
					getRightmostSetBit(x) });

			log.info("x: {} rightMostSetBit Propagated: {}", new Object[] { x,
					propagateRightmostBitSet(x) });

			log.info("x: {} rightMostUnSetBit: {}", new Object[] { x,
					isolateRightMostUnsetBit(x) });

			log.info("x: {} rightMostUnSetBit set: {}", new Object[] { x,
					setRightmostUnsetBit(x) });

			log.info("x: {} isolateNthBit {}: {}", new Object[] { x, 3,
					isolateNthBit(x, 3) });

			log.info("x: {} bitSwap i: {} j: {} --> {}", new Object[] { x, 3,
					5, bitSwap(x, 3, 5) });

			log.info("x: {} closestYinSk: {}", new Object[] { x,
					closestWeightedElement(x) });

			log.info("x: {} isolateMostSignificantBit: {}", new Object[] { x,
					isolateMostSignificantBitIndex(x) });

			log.info("x: 8 getByte 0: {}", new Object[] { getbyte(8, 0) });
			log.info("x: 16 getByte 0: {}", new Object[] { getbyte(16, 0) });
			log.info("x: 16 getByte 1: {}", new Object[] { getbyte(16, 1) });
			log.info("x: 259 getByte 0: {}", new Object[] { getbyte(259, 0) });

		}
	}
	
	public static void main(String[] args) {

		int singleElement = getSingleNonRepeatedElement();
		long x = 80;
		long r = getRightmostSetBit(x);
		System.out.printf("X: %d LSSBOne: %s\n", x, r);
		r = getRightmostSetBit(x);
		System.out.printf("X: %d LSSBTwo: %s\n", x, r);
		r = isolateMostSignificantBitIndex(x);
		System.out.printf("X: %d ISOLATE LSSBTwo: %s\n", x, r);
		
		printBinaryString(x);
		
		r = bitReversal(x);
		System.out.printf("X: %d BR: %s\n", x, r);
		printBinaryString(r);
		
		runTests();
	}

}
