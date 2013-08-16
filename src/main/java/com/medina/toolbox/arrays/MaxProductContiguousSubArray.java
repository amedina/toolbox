package com.medina.toolbox.arrays;

public class MaxProductContiguousSubArray {


	/*
	 * The solution to this problem is similar to KADANE's algorithm for
	 * the MAX SUBARRAY problem, with some variations:
	 * 
	 * Keep track of:
	 * 
	 * (1) Max positive product ending here
	 * (2) Min negative product ending here
	 * (3) Max so far
	 *
	 */
	
	public int getMaxSubArrayProduct(int[] a) throws IllegalArgumentException {
		
		if (a == null || a.length == 0) { throw new IllegalArgumentException(); }
		
		int _MAX_EndingHere = 1;
		int _MIN_EndingHere = 1;
		int maxSoFar = Integer.MIN_VALUE;
		
		for (int i = 0; i < a.length; i++) {			
			
			/*
			 * If current element is positive, update the maxEndingHere
			 * variable; update minEndingHere only if it is negative
			 */
			if (a[i] > 0) {
				
				_MAX_EndingHere = _MAX_EndingHere * a[i];
				
				_MIN_EndingHere = _MIN_EndingHere * a[i];
				
				if (_MIN_EndingHere < 1) {
					_MIN_EndingHere = 1;
				}
				
			}else {
			
				if (a[i] == 0) {
					
					_MAX_EndingHere = 1;
					_MIN_EndingHere = 1;
					
				}else {
					
					int temp = _MAX_EndingHere;
					_MAX_EndingHere = Math.max(_MIN_EndingHere * a[i], 1);
					_MIN_EndingHere = temp * a[i];
					
				}
			}
			
			maxSoFar = Math.max(maxSoFar, _MAX_EndingHere);
		}
		
		return maxSoFar;
	}
	
	public static void main(String[] args) {
		
		int[] a = {-1, -3, -10, 0, 60};
		int[] b = {6, -3, -10, 0, 2};
		int[] c = {-2, -3, 0, -2, -40};
		int[] d = {1, -2, -3, 0, 7, -8, -2};
		
		MaxProductContiguousSubArray msa = new MaxProductContiguousSubArray();
		int s = msa.getMaxSubArrayProduct(a);
		System.out.println("SA: " + s);
		s = msa.getMaxSubArrayProduct(b);
		System.out.println("SB: " + s);
		s = msa.getMaxSubArrayProduct(c);
		System.out.println("SC: " + s);
		s = msa.getMaxSubArrayProduct(d);
		System.out.println("SD: " + s);

	}

}
