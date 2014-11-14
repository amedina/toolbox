package com.medina.toreview;

import java.util.Arrays;

import com.medina.toolbox.arrays.PrintArray;

public class MaxSeparationOrderingBetweenTwoElements {

	private int[] lMin;
	private int[] lMax;

	public int findMaxIndexDifferenceOrdering(int[] a) {

		lMin = new int[a.length];
		lMax = new int[a.length];

		/* Keep track on MIN element until position i */
		lMin[0] = a[0];
		for (int i = 1; i < a.length; i++) {
			if (a[i] < lMin[i - 1]) {
				lMin[i] = a[i];
			} else {
				lMin[i] = lMin[i - 1];
			}
		}

		/* Keep track on MAX element until position j */
		lMax[a.length - 1] = a[a.length - 1];
		for (int j = a.length - 2; j >= 0; j--) {
			if (a[j] > lMax[j + 1]) {
				lMax[j] = a[j];
			} else {
				lMax[j] = lMax[j + 1];
			}
		}

		PrintArray.print(lMin);
		PrintArray.print(lMax);
		/*
		 * Traverse both arrays LMIN and LMAX; The idea is that:
		 * 
		 * (a) LMIN[j] <= LMIN[i] for all i < j 
		 * (b) LMAX[j] >= LMAX[i] for all i < j
		 * 
		 * KEY IDEA: assume that we are considering two elements A[i] and
		 * A[j] / A[i] < A[j]. Two considerations need to be taken into account:
		 * 
		 * (a) If there exist an i' < i/ A[i'] <= A[i], then we should not
		 * consider i and a candidate left index: because A[i'] < A[j] and j -
		 * i' > j - i.
		 * 
		 * (b) If there exist an index j' > j/ A[i] < A[j'], then we should not
		 * consider j as a candidate right index: because A[i] < A[j'] and j' -
		 * i > j - i
		 * 
		 * While traversing the arrays, if LMIN[i] > LMAX[j], then do i++ since
		 * all elements to the left of i in LMIN are greater than LMIN[i]; if
		 * LMIN[i] < LMAX[j] then do j++
		 */
		int i = 0;
		int j = 0;
		int maxDiff = -1;
		while (i < a.length && j < a.length) {
			
			if (lMin[i] < lMax[j]) {
				maxDiff = (maxDiff < (j - i))?(j - i):maxDiff;
				j++;
			}else {
				i++;
			}						
		}
		return maxDiff;
	}

	public static void main(String[] args) {

		MaxSeparationOrderingBetweenTwoElements m = new MaxSeparationOrderingBetweenTwoElements();
		int[] a = { 34, 8, 10, 3, 2, 80, 30, 33, 1 };
		int maxDiff = m.findMaxIndexDifferenceOrdering(a);
	
		PrintArray.print(a);
		System.out.printf("MaxDiff: %d\n", maxDiff);
		
		Arrays.sort(a);
		PrintArray.print(a);

	}

}
