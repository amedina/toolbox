package com.medina.toolbox.arrays;

import java.util.Arrays;
import java.util.Random;

public class SelectKthElementLinearTime {

	private Random rand = new Random();
	
	public int partitionArray(int[] array, int start, int end, int i) {

		int smaller = start;
		int equal = start;
		int larger = end;

		int pivot = array[i];

		while (equal <= larger) {
			
			/* A[equal] = unclassified element */
			if (array[equal] < pivot) {
				
				/* swap(equal, smaller) */
				int temp = array[equal];
				array[equal] = array[smaller];
				array[smaller] = temp;
				
				smaller += 1;
				equal += 1;
				
			} else {
				
				if (array[equal] == pivot) {
				
					equal += 1;
				
				} else { /* array[equal] > pivot */
					
					/* swap(equal, larger) */
					int temp = array[equal];
					array[equal] = array[larger];
					array[larger] = temp;
					larger -= 1;
					
				}
			}

		}
		
		return equal;
	}
	
	public int partitionArrayStandard(int[] a, int left, int right, int pivotIndex) {
		
		/* Grab value of array element at pivot */ 
		int p = a[pivotIndex];
		
		/* Put element in the pivot index at the right of the array */
		int temp = a[right];
		a[right] = a[pivotIndex];
		a[pivotIndex] = temp;
		
		/* 
		 * Swap all elements less than the pivot to the left of the pivot position
		 */
		
		int storeIndex = left - 1;		
		for (int j = left; j <= right; j++) {
			
			if (a[j] <= p) {
				storeIndex++;
				temp = a[storeIndex];
				a[storeIndex] = a[j];
				a[j] = temp;		
			}
		}
		
		return storeIndex;
	}
	
	public int selectKthElement(int[] a, int s, int e, int k) {
		
		while (s <= e) {
			
			/* Set size of sub-array for current iteration */ 
			int size = e - s;
			
			/* STEP #1: Select random pivot element for partitioning*/
			int p = rand.nextInt(Integer.MAX_VALUE) % size;
			
			/* STEP #2: Partition array around selected pivot */
			int q = partitionArrayStandard(a, 0, a.length - 1, p);

			/* 
			 * STEP #3: If pivot position is desired rank (k), return it
			 * If not, if pivot position is larger than desired rank, search for 
			 * it on first half of the array; otherwise, look for it on the
			 * upper part of the array
			 */
			if (q == k - 1) {
				return a[q];
			}else {
				if (q > k - 1) {
					e = q - 1;
				}else {
					s = q + 1;
				}
			}
		}
		
		return -1;
	
	}
	
	public static void main(String[] args) {

		SelectKthElementLinearTime s = new SelectKthElementLinearTime();
		
		int[] a = {2,3,1,8,6,7,9,10,4,11};
		int k = 8;
		PrintArray.print(a);
		int res = s.selectKthElement(a, 0, a.length - 1, k);
	
		System.out.printf("K: %d res: %d\n", k, res);
		Arrays.sort(a);
		PrintArray.print(a);

	}

}

