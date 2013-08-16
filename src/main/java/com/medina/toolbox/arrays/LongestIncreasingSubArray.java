package com.medina.toolbox.arrays;

/*
 * PROBLEM: Design an algorithm that takes an array A of n elements,
 * and returns the start end end indices of a longest increasing 
 * subarray
 * 
 * APPROACH: O(N) 
 * 
 * (1) Define Result class: int i; int j; int length;
 * (2) Keep track of the following state:
 * 	- indices i, j: for current max length sequence
 *  - maxLength: length of longest sequence so far
 *  - currLength: length of sequence currently being explored
 *  
 * (3) Execute TWO NESTED while loops
 * - OUTER one iterates over the BEGINNING index of the sequence (i) < a.length
 * - INNER one iterates over the END index of the sequence (j) < a.length - 1
 */
public class LongestIncreasingSubArray {

	public static Result getLongestIncreasingSA(Integer[] A) {
		
		int maxLength = 1;
		int startIndex = 0;
		int endIndex = 0;
		
		int i = 0;
		while (i < A.length) {
			
			int j = i;
			int currLength = 1;
			
			/* Count run length starting at ith element */
			while (j < A.length - 1) {
				
				/* Keep going as long as the condition holds */
				if (A[j] <= A[j + 1]) {
					currLength += 1;
					j += 1;
				}else {
					break;
				}												
			}
		
			/* Update maxLenght so far, and indices */
			if (currLength > maxLength) {
				maxLength = currLength;
				startIndex = i;
				endIndex = j;
			}
			
			i = j + 1;
				
		}
		
		Result r = new Result(startIndex, endIndex);
		
		return r;
		
	}
	
	private static class Result {

		public int startIndex;
		public int endIndex;
		
		public Result(int startIndex, int endIndex) {
			super();
			this.startIndex = startIndex;
			this.endIndex = endIndex;
		}
				
		@Override
		public String toString() {
			StringBuilder builder = new StringBuilder();
			builder.append("Result [startIndex=");
			builder.append(startIndex);
			builder.append(", endIndex=");
			builder.append(endIndex);
			builder.append("]");
			return builder.toString();
		}
		
		
	}
	public static void main(String[] args) {
		
		
		Integer[] A = {3,1,2,3,4,5,0,1,5,4,3,1,2,3,4,2,5,5,6,7,7,8,9,1,2,3,4,5,0};
		
		Result r = getLongestIncreasingSA(A);
		
		System.out.println("MaxL: " + r);

		
	}

}
