package com.medina.TOREVIEWFORGOOGLE;

public class MedianOfTwoSortedArrays {

	/*
	 * SOLUTION #1: perform a MERGE as in MERGESORT while keeping a count of the
	 * number of elements processed; when the count reaches (m + n)/2, output
	 * the value.
	 * 
	 * COMPLEXITY: O(n)
	 */


	/*
	 * SOLUTION #2: A faster algorithm compares the medians of the two arrays:
	 * 
	 * m1 = median(a) 
	 * m2 = median(b)
	 * 
	 * if (m1 == m2): 
	 * 		total median: m1 | m2 
	 * 
	 * if (m1 < m2): 
	 * 		recurse with a = a[m1:m], b[0:m2 -1] 
	 * 
	 * if (m1 > m2): 
	 * 		recurse with a = a[0:m1 -1], b[m2:n]
	 * 
	 */
	

	/*
	 * SOLUTION #3: BINRARY SEARCH
	 *
	 * The basic idea is that if you are given two arrays ar1[] and ar2[] and
	 * know the length of each, you can check whether an element ar1[i] is the
	 * median in constant time.
	 * 
	 * Suppose the median is a[i]. Since both arrays are sorted, then a[i] is
	 * greater than exactly i elements in a. IF IT IS THE MEDIAN, then it is also
	 * greater than exactly j = n - i - 1 elements in array b.
	 * 
	 * if a[i] IS THE MEDIAN: a[i] >= b[j] AND a[i] <= b[j + 1]
	 * 
	 * if a[i] is NOT MEDIAN: a[i] > b[j + 1] OR a[i] < b[j]
	 */

	

	public int getMedian(int[] a, int startA, int endA, int[] b, int startB, int endB) {

		int sizeA = endA - startA; 
		int sizeB = endB - startB;
		
		if (sizeA == 1 && sizeB == 1) {
			return (a[0] + b[0]) / 2;
		}

		if (sizeA == 2 && sizeB == 2) {
			return (Math.max(a[0], b[0]) + Math.min(a[1], b[1])) / 2;
		}

		int m1 = getMedian(a, startA, endA);
		int m2 = getMedian(b, startB, endB);

		if (m1 == m2) {
			return m1;
		}

		int midA = startA + sizeA / 2;
		int midB = startB + sizeB / 2;
		if (m1 < m2) {			
			if (sizeA % 2 == 0) {
				return getMedian(a, midA - 1, endA,  b, startB, midB + 1);
			}else {
				return getMedian(a, midA, endA, b, startB, midB);
			}
		} else { /* m1  > m2 */
			if (sizeA % 2 == 0) {
				return getMedian(b, midB - 1, endB,  a, startA, midA + 1);
			}else {
				return getMedian(b, midB, endB, a, startA, midA);
			}
		}
		
	}

	public int getMedian(int[] a, int s, int e) {

		int sizeA = e - s;
		int m = sizeA / 2;
		if (sizeA % 2 == 0) {
			return (a[m] + a[m - 1]) / 2;
		} else {
			return a[m];
		}

	}
	
	public static void main(String[] args) {

		int[] a = { 1, 12, 15, 26, 38, 42 };
		int[] b = { 2, 13, 17, 30, 45, 50};
		
		int[] c = { 1, 2, 12, 13, 15, 17, 26, 30,  38, 42, 45, 50};

		MedianOfTwoSortedArrays m = new MedianOfTwoSortedArrays();
		int median = m.getMedian(a, 0, a.length, b, 0, b.length);
		int medianA = m.getMedian(a, 0, a.length);
		int medianB = m.getMedian(b, 0, b.length);
		int medianC = m.getMedian(c, 0, c.length);
		
		System.out.printf("MA: %d MB: %d MC: %d\n", medianA, medianB, medianC);		
		System.out.printf("Overall Median: %d\n", median);

	}

}
