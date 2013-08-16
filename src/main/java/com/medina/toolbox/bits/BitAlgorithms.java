package com.medina.toolbox.bits;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.Map;

import org.junit.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class BitAlgorithms {

	private static Logger log = LoggerFactory.getLogger(BitAlgorithms.class);

	private Map<Short, Short> precomputedParity = new HashMap<Short, Short>();

	public BitAlgorithms() {
		super();
	}

	/*
	 * Complexity: O(s)
	 * 
	 * Idea: Apply v & (v -1) operation on each iteration to clear the least
	 * significant bit; this will be done as many times as there bits set to one
	 * in v; Initialize value of parity to 0 (false); on each iteration reassign
	 * the parity variable to its complement.
	 * 
	 * Hook: PUSH BITS one at a time (CLEAR LSB: X & (X - 1)) through a CLIFF:
	 * SHOUT "One more down, parity changing!!!!"
	 */
	public boolean computeParityNaive(long v) {

		boolean parity = false;
		int i = 0;
		while (v > 0) {
			i++;
			parity = !parity;
			v = v & (v - 1);
		}
		log.info("computeParityNaive i: {}", i);
		return parity;
	}

	public short computeParityNaive(int v) {

		short parity = 0;
		int i = 0;
		while (v > 0) {
			i++;
			parity = (short)(parity ^ 1);
			v = v & (v - 1);
		}
		log.info("computeParityNaive i: {}", i);
		return parity;
	}

	
	/*
	 * Complexity: O(s)
	 * 
	 * Similar to approach above. Instead of CLEARING LSBs, AND v and 1 on each
	 * iteration; if AND results in 1, swap (XOR) parity; else, IGNORE. The XOR
	 * does both the CHECK AND THE SWAPPING!.; SWAP = parity XOR (v & 1); SHIFT:
	 * v >> 1
	 * 
	 * Hook: All BITS STANDING like in the MILITARY; the GENERAL STANDS at the
	 * start of the line and asks each BIT: ARE YOU A 1? If the BIT says SIR,
	 * YES SIR, the parity is swapped.
	 * 
	 * Toggles value of result every time a one appears in the LSB;
	 *  v & 1 is either 0 or 1 
	 *  
	 *  result ^ 0: does not change result
	 * 
	 *  result ^ 1: toggles result from 0 to 1 (even to odd/odd to even)
	 */
	public short computeParityShift(short v) {

		short result = 0;

		int i = 0;
		while (v > 0) {
			i++;

			result = (short) (result ^ (v & 1));
			v = (short) (v >> 1);
		}

		log.info("computeParityShift i: {}", i);
		return result;

	}

	/*
	 * Parity: RECURSION
	 * 
	 * Idea: divide input parameter in TWO, invoke any of the above methods on
	 * each half.
	 */

	public short computeParityRecursive(int v) {

		short firstHalf = (short) ((v >> 16) & 0xFFFF);
		short secondHalf = (short) (v & 0xFFFF);

		return (short) (computeParityShift(firstHalf) ^ computeParityShift(secondHalf));

	}

	public short lookupParityWithInsert(int v) {

		short firstHalf =  (short)(v >> 16);
		short secondHalf =  (short)(v & 0xFFFF);

		short firstHalfParity;
		if (precomputedParity.containsKey(firstHalf)) {
			log.info("Cache HIT for: {}", (int) firstHalf);
			firstHalfParity = precomputedParity.get(firstHalf);
		} else {
			log.info("First Half Cache MISS: {}", (int) firstHalf);
			firstHalfParity = computeParityShift(firstHalf);
			/* Update cache */
			precomputedParity.put((short) firstHalf, firstHalfParity);
		}

		short secondHalfParity;
		if (precomputedParity.containsKey(secondHalf)) {
			log.info("Cache HIT for: {}", (int) secondHalf);
			secondHalfParity = precomputedParity.get(secondHalf);
		} else {
			log.info("Cache MISS for: {}", (int) secondHalf);
			secondHalfParity = computeParityShift(secondHalf);
			/* Update cache */
			precomputedParity.put((short) firstHalf, secondHalfParity);
		}

		precomputedParity.put(firstHalf, firstHalfParity);
		precomputedParity.put(secondHalf, secondHalfParity);

		return (short) (firstHalfParity ^ secondHalfParity);
	}

	/*
	 * Idea: The algorithm consists of THREE steps:
	 * 
	 * (1) Isolate ith and jth bits in x (2) Check if x[i] != x[j]; if not, just
	 * return;
	 * 
	 * (3) Swap ith and jth bits by XORing x with a long value having only the
	 * ith and jth bits set to 1.
	 */
	public static long swapBits(long x, int i, int j) {

		long y = x;
		if (((x >> i) & 1) != ((x >> j) & 1)) {
			y = x ^ ((1L << i) | (1L << j));
		}

		return y;
	}

	public short computeParityWithLookup(long v) {

		int byteOne = (int) (v >> 48);
		short byteOneParity = lookupParityWithInsert(byteOne);
		
		int byteTwo = (int) ((v >> 32) & 0xFFFF);		
		short byteTwoParity = lookupParityWithInsert(byteTwo);
		
		int byteThree = (int) (v >> 16) & 0xFFFF;
		short byteThreeParity = lookupParityWithInsert(byteThree);
		
		int byteFour = (int) (v & 0xFFFF);
		short byteFourParity = lookupParityWithInsert(byteFour);
		
		log.info("byteOne: {}", Integer.toBinaryString(byteOne));
		log.info("byteTwo: {}", Integer.toBinaryString(byteTwo));
		log.info("byteThree: {}", Integer.toBinaryString(byteThree));
		log.info("byteFour: {}", Integer.toBinaryString(byteFour));
		
		return (short) (byteOneParity ^ byteTwoParity ^ byteThreeParity ^ byteFourParity);

	}

	/* Turn off the rightmost 1-bit (LSB set to 1) */
	public static long turnOffRightmostOneBit(long x) {
		return x & (x - 1);
	}

	/* Turn on the rightmost 0-bit (LSB set to 0) */
	public static long turnOnRightmostZeroBit(long x) {
		return x | (x + 1);
	}

	/*
	 * Turn ON trailing zeros: x | (x - 1)
	 * (Propagate value of RIGHTMOST BIT set to ONE)
	 */
	public static long turnOnTrailingZeros(long x) {
		return x | (x - 1);
	}
	
	/* 
	 * Turn OFF trailing ones: x & (x + 1)
	 * (Propagate RIGHTMOST BIT set to ZERO)
	 */
	public static long turnOffTrailingOnes(long x) {
		return x & (x + 1);
	}

	/*
	 * Given x in Sk, find y in Sk which is as close as possible to x
	 * 
	 * Idea: iterate over the input number to find the first (Least Significant)
	 * consecutive bits that are different and swap them.
	 */

	public static long findClosestYinSk(long x) throws IllegalArgumentException {

		long bi = 0;
		long biPlusOne = 0;

		for (int i = 0; i < 63; i++) {
			
			bi = (x >> i) & 1L;
			biPlusOne = (x >> i + 1) & 1;
			
			if (bi != biPlusOne) {
				return x ^ ((1L << i) | (1L << i + 1));
			}
		}

		throw new IllegalArgumentException();

	}
	
	/* Isolate bit at given position */
	public static long isolateBit(long x, int i) {
		return x & (1L << i);
	}

	/* Isolate rightmost 1-bit */
	public static long isolateRightmostOneBit(long x) {
		return x & (-x);
	}

	/* Absolute value */
	public static long abs(int x) {

		int y = x >> 31;
		return (x ^ y) - y;
	}

	public static int indexOfLeastSignificantOneBit(long x) {

		return (int) (Math.log(x & (~(x - 1))) / Math.log(2));

	}

	public static long isolateLeastSignificantOneBit(long x) {

		return x & (~(x - 1));

	}

	public  void testOne() {
		log.info("Input EOF and press enter to end test...");

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		BitAlgorithms compParity = new BitAlgorithms();
		String searchString = null;

		@SuppressWarnings("unused")
		long x = 1;

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

			short resultWitShift = 0;
			short resultWithLookup = 0;
			boolean parity = false;
			int v;
			try {
				v = Integer.parseInt(searchString);
			} catch (NumberFormatException e) {
				log.error("Wrong input type!");
				continue;
			}

			// parity = compParity.computeParityNaive(v);
			// resultWitShift = compParity.computeParityShift(v);

			resultWithLookup = compParity.computeParityWithLookup(v);

			String naiveResultString = (parity == true) ? "ODD" : "EVEN";

			log.info("Naive: Value {} given has a {} parity", new Object[] { v,
					naiveResultString });
			log.info("Shift: Value {} given has a parity of {}", new Object[] {
					v, resultWitShift });
			log.info("Lookup: Value {} given has a parity of {}", new Object[] {
					v, resultWithLookup });
		}
	}

	public void testTwo() {

		long x = 175;
		long newX = turnOffRightmostOneBit(x);
		log.info("turnOffRightmostOneBit: X: {} turnedOffX: {}", x, newX);

	}


	public void testThree() {

		long x = 167;
		long newX = turnOnRightmostZeroBit(x);
		log.info("turnOnRightmostZeroBit: X: {} turnedOnX: {}", x, newX);

	}
	

	public void testFive() {

		long x = 2175;
		long newX = turnOffTrailingOnes(x);
		log.info("turnOffTrailingOnes: X: {} newX: {}", x, newX);

	}


	public void testSix() {

		long x = 64;
		long newX = turnOnTrailingZeros(x);
		log.info("turnOnTrailingZeros: X: {} newX: {}", x, newX);

	}


	public void testSeven() {
		
		long x = 92;
		long y = findClosestYinSk(x);
		log.info("X: {} findClosestYinSk: {}", x, y);
		
	}
	

	public void testAcht() {
		
		long x = 92;
		long newX = isolateLeastSignificantOneBit(x);
		int index = (int) (Math.log(isolateLeastSignificantOneBit(x))/Math.log(2));
		log.info("X: {} LSB: {}", x, index);
	}
	
	public void testTen() {

		long x = 1920;
		long newX = isolateRightmostOneBit(x);
		log.info("X: {} isolatedRightmostOneBit: {}", x, newX);

	}

//	public static void main(String[] args) {
//
//		log.info("ABS(128 - 134): {}", abs(128, 134));
//
//		log.info("X: {} SwapBits(10, 1): {}", 1024, swapBits(1024L, 10, 1));
//		log.info("X: {} SwapBits(10, 9): {}", 1024, swapBits(1024L, 10, 9));
//
//		log.info("X: {} YinSk: {}", 4952L, findClosestYinSk(4952L));
//		log.info("X: {} YinSk: {}", 18L, findClosestYinSk(18L));
//
//		log.info("X: {} LSB: {}", 18L, isolateLeastSignificantOneBit(4864));
//		log.info("X: {} IndexOfLSB: {}", 18L,
//				indexOfLeastSignificantOneBit(4864));
//
//	}

}
