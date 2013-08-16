package com.medina.toolbox.arrays;

import java.util.ArrayList;
import java.util.List;

public class CountInversionsArrays {

	/*
	 * NUMBER OF INVERSIONS is a metric that indicates how far an array is from
	 * being sorted.
	 * 
	 * Solution #1: Brute force; check all pairs; O(n^2)
	 * 
	 * Solution #2: Divide and Conquer; O(NlogN)
	 * 
	 * (1) Base case: array of size 2: inv = (a[0] > a[1])?1:0 
	 * (2) Divide: countInv(a, 1, n/2), countInv(a, n/2 + 1, n); 
	 * (3) countCrossInversions(a, n/2, n) need to count these inversions in O(n)
	 * 
	 * Solution #3: If each of the sublists is sorted, then finding one inversion between
	 * them would allow us to infer other inversions. 
	 * 
	 * MergeAndCount(SortedList A, SortedList B):
	 * 
	 * a = 0; b = 0; crossInvCount = 0;
	 * 
	 * OutList = {};
	 * 
	 * while (a < A.length and b < B.length):
	 * 
	 * 	next = min(A[a], B[b]); 
	 *  OutList.append(next);
	 * 
	 * 	if (B[b] == next): b += 1; crossInvCount += |A| - a; else a += 1;
	 * 
	 * endWhile
	 * 
	 * Append non-empty list at end of OutList;
	 * 
	 * return OutList, crossInvCount;
	 * 
	 * ==============================
	 * 
	 * SortAndCount(List L):
	 * 
	 * if (L.length == 1): return 0;
	 * 
	 * A = firstHal=(L); B = secondHalf(L);
	 * 
	 * invA, SortedA = SortAndCount(A); invB, SortedB = SortAndCount(B);
	 * 
	 * crossInv, SortedL = mergeAndCount(SortedA, SortedB);
	 * 
	 * return (invA + invB + crossInv), SortedL;
	 */

	
	public int bruteForceCountInversions(int[] a) {
	
		int numInversions = 0;
		
		for (int i = 0; i < a.length; i++) {
			for (int j = i + 1; j < a.length; j++) {
				if (a[i] > a[j]) {
					numInversions += 1;
				}
			}
		}
		
		return numInversions;
	}
	
	public int mergeAndCount(int[] A, int l, int m, int h) {
		
		int a = l, b = m + 1, crossInvCount = 0;

		int size = m - l + 1;
		while (a <= m && b <= h) {

			int next = Math.min(A[a], A[b]);			

			if (A[b] == next) {
				int temp = A[a];
				A[a] = A[b];
				A[b] = temp;
				b += 1;
				crossInvCount += size - a;
			} else {
				a += 1;
			}
		}

		return crossInvCount;

	}

	public int sortAndCount(int[]  a, int l, int h) {

		if (h - l == 0) {
			return 0;
		}

		if (h - l == 1) {
			if (a[l] > a[h]) {
				int temp = a[l];
				a[l] = a[h];
				a[h] = temp;
				return 1;
			} else {
				return 0;
			}
		}

		int m = l + (h - l) / 2;

		int invA = sortAndCount(a, l, m);
		int invB = sortAndCount(a, m + 1, h);

		int crossInv = mergeAndCount(a, l, m, h);

		return invA + invB + crossInv;


	}

	public class Output {
		public int count;
		public List<Integer> list;

		public Output() {
			super();
			list = new ArrayList<Integer>();
		}

	}

	public static void main(String[] args) {
		
		CountInversionsArrays ci = new CountInversionsArrays();

		int a[] = {50, 1, 20, 6, 4};
		PrintArray.print(a);
		
		int ni = ci.bruteForceCountInversions(a);
		System.out.printf("NI: %d\n", ni);
		
		ni = ci.sortAndCount(a, 0, 4);
		PrintArray.print(a);
		System.out.printf("Inv: %d\n", ni);
	}

}
