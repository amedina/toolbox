package com.medina.toolbox.arrays;

public class ContiguousSubArraySum {

	/*
	 * PROBLEM: Given an array A and a target sum T, determine if there is a
	 * contiguous sub-array of A that adds up to the target
	 * 
	 * Keep TWO POINTERS; initialize BOTH to point to
	 * the BEGINNING of the array; keep track of the current sum; while the
	 * current sum is less than the target, add elements to the sum on the
	 * "right", using the second pointer (j); If the sum becomes equal to the
	 * target sum, return the pointer values; if the current sum exceed the
	 * target, then subtract elements from the "left" using the first pointer.
	 * If the second pointer reaches the end of the array and the condition on
	 * the target sum has not been met, terminate.
	 */
	public void findSubArrayWithGivenSum(int[] a, int target) {
		
		int currSum = 0;
		
		int i = 0, j = 0;
		while (j < a.length){
			
			/* Update current sum value */
			currSum += a[j];
			
			/* Move pointer towards the right */
			j+= 1;
		
			/* While currSum is below target, keep adding */ 
			if (currSum < target) {
				continue;
			}
			
			/* While currSum is above target, keep subtracting */
			/* Get rid of elements from the left */
			while (currSum > target) {
				currSum -= a[i];
				i++;
			}
			
			/* If target met, return result */
			if (currSum == target) {
				System.out.printf("CurrSum: %d Sub array found: i: %d j: %d", currSum, i, j - 1);
				return;
			}
		}
		
		/* Target sum not present */
		System.out.printf("No Sub array found!");
	}
	
	public static void main(String[] args) {
		
		ContiguousSubArraySum sa = new ContiguousSubArraySum();
		int arr[] = {1, 2, 65, 8, 9, 14, 15, 20};
		sa.findSubArrayWithGivenSum(arr, 49);

	}

}
