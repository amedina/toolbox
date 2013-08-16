package com.medina.toolbox.arrays;

public class MaxSumContiguousCircularSubArray {


	/*
	 * In this problem we have two consider two cases:
	 * 
	 * (1) Max sub array involves no  wrapping around
	 * (2) Max sub-array sub does involve wrapping
	 * 
	 * In the case where there is no wrapping, the Kadane's algorithm 
	 * can produce the result
	 * 
	 * If there is wrapping,
	 */
	
	public int getMaxSubArraySum(int[] a) throws IllegalArgumentException {
		
		MaxSumContiguousSubArray kadane = new MaxSumContiguousSubArray();
		
		int maxKadane = kadane.getMaxSubArraySum(a);
		
		int maxWrap = 0;
		for (int i = 0; i < a.length; i++) {
			maxWrap += a[i];
			a[i] = -a[i];
		}
		
		maxWrap += kadane.getMaxSubArraySum(a);
		
		return (maxWrap > maxKadane)?maxWrap:maxKadane;

	}
	
	public static void main(String[] args) {
		
		int[] a = {11, 10, -20, 5, -3, -5, 8, -13, 10}; 
		
		MaxSumContiguousCircularSubArray msa = new MaxSumContiguousCircularSubArray();
		int s = msa.getMaxSubArraySum(a);
		System.out.println("S: " + s);

	}

}
