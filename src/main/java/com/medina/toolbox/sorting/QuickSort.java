package com.medina.toolbox.sorting;

import java.util.Random;

public class QuickSort {

	private Random r = new Random();
	
	public void printArray(int[] a) {		
		for (int i = 0; i < a.length; i++) {
			System.out.print(a[i] + " ");
		}
		System.out.println("");
	}
	
	public int partitionArray(int[] a, int p, int r) {
		
		int x = a[p];
		int i = p - 1;
		int j = r + 1;
		
		while (true) {
			
			do {
				j = j - 1;
			}while(a[j] <= x);
			do {
				i = i + 1;
			}while(a[i] >= x);
			
			if (i < j) {
				int temp = a[i];
				a[i] = a[j];
				a[j] = temp;
			}else {
				int temp = a[p];
				a[p] = a[j];
				a[j] = temp;
				return j;
			}
		}
		
	}
	

	
	public int partitionArrayTwo(int[] a, int si, int ei) {
		
		int p = a[ei];
		int smaller = si - 1;
		
		for (int j = si; j < ei; j++) {
			
			if (a[j] <= p) {
				smaller += 1;
				int temp = a[smaller];
				a[smaller] = a[j];
				a[j] = temp;
			}
		}
		int temp = a[smaller + 1];
		a[smaller + 1] = a[ei];
		a[ei] = temp;
		
		return smaller + 1;
	}
	
	public void quickSortTwo(int[] a, int l, int h) {
		
		if (l < h) {
			
			int q = partitionArrayTwo(a, l, h);
			
			System.out.printf("pivot: %d = %d -- ", q, a[q]);
			printArray(a);
			quickSortTwo(a, l, q - 1);
			quickSortTwo(a, q + 1, h);
		}
	}

	public int partitionArrayThree(int[] array, int i) {

		int smaller = 0;
		int equal = 0;
		int larger = array.length - 1;

		int pivot = array[i];

		while (equal <= larger) {
			
			if (array[equal] < pivot) {
			
				/*  swap(equal, smaller) */
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
	
	public void quickSort(int[] a, int l, int h) {

		
		if (l < h) {
	
			System.out.printf("p: %d a[%d]: %d", h, h, a[h]);
			int q = partitionArrayStandard(a, l, h, h);
			System.out.printf(" q: %d = %d -- ", q, a[q]);
			
			printArray(a);
			quickSort(a, l, q - 1);
			quickSort(a, q + 1, h);
		}
	}

	public static void main(String[] args) {

		QuickSort qs = new QuickSort();
		int[] a = {81,32,29,45,5,4,3,2,1, 305,3,2,6,4,1,3,7,8,6,87,98,101,3,5,46,57,81,32,29,45,5,4,3,2,1, 30};
		
		qs.quickSort(a, 0, a.length - 1);
		qs.printArray(a);
	}

}
