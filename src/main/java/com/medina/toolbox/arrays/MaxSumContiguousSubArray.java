package com.medina.toolbox.arrays;

public class MaxSumContiguousSubArray {


	/*
	 * A solution for this problem that works for arrays that have at least one
	 * positive number consists of scanning the array once, and keep track of
	 * two variables: maxEndinghere: which keeps track of the max sub array sum
	 * ending a t a given index; and maxSoFar: which keeps track of the max
	 * subarray sum overall.
	 * 
	 * This algorithm is called KADANE's algorithm
	 * 
	 */
	
	public int getMaxSubArraySum(int[] a) throws IllegalArgumentException {
		
		if (a == null || a.length == 0) { throw new IllegalArgumentException();}
		
		int maxEndinghere = 0;
		int maxSoFar = 0;
		
		for (int i = 0; i < a.length; i++) {			
		
			maxEndinghere = maxEndinghere + a[i];
			
			if (maxEndinghere < 0) {
				maxEndinghere = 0;
			}
						
			maxSoFar = Math.max(maxSoFar, maxEndinghere);
		}
		
		return maxSoFar;
	}
	
	public static void main(String[] args) {
		
		int[] a = {-2, -3, 4, -1, -2, 1, 5, -3};
		MaxSumContiguousSubArray msa = new MaxSumContiguousSubArray();
		int s = msa.getMaxSubArraySum(a);
		System.out.println("S: " + s);

	}

}
