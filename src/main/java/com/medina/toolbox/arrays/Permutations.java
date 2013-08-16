package com.medina.toolbox.arrays;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.medina.toolbox.strings.BaseConversion;

public class Permutations {

	private static Logger log = LoggerFactory.getLogger(BaseConversion.class);
	
	/*
	 * Given an Array of n elements and a permutation P, compute P(A) using
	 * O(1) space complexity.
	 * 
	 * KEY: After every update of the array A, modify the permutation array
	 */
	public static char[] permuteCharArray(char[] A, int[] P) throws IllegalArgumentException {
	
		if ((A.length * P.length == 0) || A.length != P.length) {			
			throw new IllegalArgumentException();
		}
		
		for (int i = 0; i < A.length; i++) {
			
			/* Permute element a[i] of array */
			char tempAi = A[i];
			A[i] = A[P[i]];
			A[P[i]] = tempAi;
			
			/* Update permutation array: find the element in P corresponding to the
			 * element in A that was just updated */
			for (int j = i; j < P.length; j++) {
				if (P[j] == i) {
					P[j] = P[i];
					break;
				}
			}			
		}
		
		return A;
	}
	
	/*
	 * Given an array A of integers representing a permutation P, update A 
	 * to represent P^(-1) using constant space complexity 
	 */
	public static int[] invertPermutation(int[] A) {
		
		
		return null;
	}
	
	
	public static void main(String[] args) {
	

		int[] P = new int[] {2, 3, 0, 1, 7, 4, 6, 5};
		char[] A = new char[] {'a', 'b', 'c', 'd', 'e', 'f', 'g', 'h'};
		
		log.info("A: {}", A);
		log.info("P: {}", P);
		
		char[] R = permuteCharArray(A, P);
		
		
		log.info("Permutation #1: {}", R);
		
		
		P = new int[] {7, 6, 5, 4, 3, 2, 1, 0};
		A = new char[] {'a', 'b', 'c', 'd', 'e', 'f', 'g', 'h'};
		
		log.info("A: {}", A);
		log.info("P: {}", P);
		
		R = permuteCharArray(A, P);
		
		
		log.info("Permutation #2: {}", R);

	}

}
