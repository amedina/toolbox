package com.medina.toolbox.sorting;

import java.util.Random;

import javax.naming.PartialResultException;
import javax.swing.text.html.HTMLDocument.HTMLReader.ParagraphAction;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class Sorting {

	private static Logger log = LoggerFactory.getLogger(Sorting.class);

	private static final Random randomNumbers = new Random();

	/*
	 * Counting sort: is an algorithm for sorting a collection of objects
	 * according to keys that are small integers. it is an integer sorting
	 * algorithm. It operates by counting the number of objects that have each
	 * distinct key value, and using arithmetic on those counts to determine the
	 * positions of each key value in the output sequence. Its running time is
	 * linear in the number of items and the difference between the maximum and
	 * minimum key values, so it is only suitable for direct use in situations
	 * where the variation in keys is not significantly greater than the number
	 * of items. However, it is often used as a subroutine in another sorting
	 * algorithm, radix sort, that can handle larger keys more efficiently.
	 * 
	 * Because counting sort uses key values as indexes into an array, it is not
	 * a comparison sort, and the Ω(n log n) lower bound for comparison sorting
	 * does not apply to it.
	 * 
	 * Bucket sort may be used for many of the same tasks as counting sort, with
	 * a similar time analysis; however, compared to counting sort, bucket sort
	 * requires linked lists, dynamic arrays or a large amount of preallocated
	 * memory to hold the sets of items within each bucket, whereas counting
	 * sort instead stores a single number (the count of items) per bucket.
	 */

	/*
	 * partitionArray(a,i): rearrange elements such that elements that
	 * are less than A[i] appear first, followed by elements equal to A[i],
	 * followed by elements greater than A[i]. Algorithm should have O(1) space
	 * complexity, and O(|A|) time complexity.
	 * 
	 * Approach: maintain notion of four groups of elements: (1) bottom; (2)
	 * middle; (3) unclassified; (4) top. At the beginning all elements, except
	 * A[i], belong to the unclassified group. Process each element in the
	 * unclassified set and classify them into one of the other three groups:
	 * 
	 * Invariants:
	 *  
	 *  A[0:smaller - 1]: SMALLER
	 *  A[smaller: equal - 1]: EQUAL
	 *  A[equal:larger - 1]: UNCLASSIFIED
	 *  A[larger:|A| - 1]: LARGER
	 * 
	 * Iteration: Reduces the size of the unclassified set by 1 element.
	 * 
	 * Trickiness: movement of pointers.
	 */
	public static void partitionArray(int[] array, int i) {

		int smaller = 0;
		int equal = 0;
		int larger = array.length - 1;

		int pivot = array[i];

		while (equal <= larger) {
			
			/* A[equal] = unclassified element */
			if (array[equal] < pivot) {
				
				/* Swap a[queal] and a[smaller] */
				int temp = array[equal];
				array[equal] = array[smaller];
				array[smaller] = temp;
				
				/* Update equal and smaller indices */
				smaller += 1;
				equal += 1;
				
			} else {
				
				if (array[equal] == pivot) {
					equal += 1;
				} else { /* array[equal] > pivot */
					
					/* Swap equal and larger */
					int temp = array[equal];
					array[equal] = array[larger];
					array[larger] = temp;

					/* Update larger index */
					larger -= 1;
				}
			}

		}

	}

	/*
	 * Input: array of boolean values. Output: partitioned array such that all
	 * elements with same key appear in same sub-array
	 */

	public static void partitionBooleanArray(boolean[] array) {

		int start = 0;
		int end = array.length - 1;

		while (start < end) {

			if (array[start] == true) {
				start += 1;
			}
			if (array[end] == false) {
				end -= 1;
			}

			if (array[start] == false && array[end] == true) {
				boolean temp = array[end];
				array[end] = array[start];
				array[start] = temp;
				start += 1;
				end -= 1;
			}

		}
	}

	/*
	 * Input: int array with only 3 different values 
	 * Output: partitioned array
	 * with the same key placed in the same sub array
	 */
	
	public static void partitionThreeValuedArray(int[] array) {
		
		int[] counts = new int[3];
		
		for (int i = 0; i < array.length; i++) {
			counts[array[i]]++;
		}
		
		int k = 0;
		for (int i = 0; i < counts.length; i++) {
			for (int j = 0; j < counts[i]; j++) {
				array[k++] = i;
			}
		}		
	}
	
	public static int partitionArraySimple(int[] a, int left, int right, int pivotIndex) {
		
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

	public static void main(String[] args) {

		int[] intArray = new int[10];

		for (int i = 0; i < 10; i++) {
			intArray[i] = randomNumbers.nextInt(10);
		}

		int pivot = 5;
		log.info("Pivot: i: {} array[{}]: {}", new Object[] { pivot, pivot, intArray[pivot] });
		log.info("Int Array Before: {}", intArray);
		partitionArray(intArray, pivot);
		log.info("Int Array After: {}", intArray);

		boolean[] booleanArray = new boolean[10];
		for (int i = 0; i < 10; i++) {
			booleanArray[i] = randomNumbers.nextBoolean();
		}

		log.info("Boolean Array Before: {}", booleanArray);
		partitionBooleanArray(booleanArray);
		log.info("Boolean After: {}", booleanArray);

		int[] threeValuedArray = new int[10];
		for (int i = 0; i < 10; i++) {
			threeValuedArray[i] = randomNumbers.nextInt(3);
		}

		log.info("Three-Valued Array Before: {}", threeValuedArray);
		partitionThreeValuedArray(threeValuedArray);
		log.info("Three Valued After: {}", threeValuedArray);
		
		int[] a = new int[50];
		for (int i = 0; i < 50; i++) {
			a[i] = randomNumbers.nextInt(10);
		}
		log.info("A (BEFORE): {}", a);
		log.info("PIVOT: {}", a[a.length -1]);
		Sorting.partitionArraySimple(a, 0, a.length - 1, a.length - 1);
		log.info("A (AFTER): {}", a);
		
	}

}
