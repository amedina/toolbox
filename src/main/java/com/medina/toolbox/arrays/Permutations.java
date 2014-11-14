package com.medina.toolbox.arrays;


import com.medina.toolbox.strings.BaseConversion;

public class Permutations {
	
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
	 * Given an array P of integers representing a permutation P, update A 
	 * to represent P^(-1) using constant space complexity 
	 */
	public static int[] invertPermutation(int[] A) {
				
		return null;
	}
	
	
	public static void printArray(int[] a, String name) {
		System.out.print(name + ": ");
	    for (int o : a) {	        
	    	System.out.print(o + " ");
		}
		System.out.println("");		
	}
	
	public static void main(String[] args) {
	 				
		String stringA = "abcdefgh";
		char[] A = stringA.toCharArray();
		int[] P = new int[] {2, 3, 0, 1, 7, 4, 6, 5};
		
		System.out.println("A: " + stringA);
		Permutations.printArray(P, "P");
		
		char[] R = permuteCharArray(A, P);
	
		System.out.println("Permutation #1: " + String.valueOf(R));
				
		P = new int[] {7, 6, 5, 4, 3, 2, 1, 0};
		A = stringA.toCharArray();
		
		System.out.println("A: " + stringA);
		Permutations.printArray(P, "P");

		R = permuteCharArray(A, P);
				
		System.out.println("Permutation #2: " + String.valueOf(R));

	}

}
