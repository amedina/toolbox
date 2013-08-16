package com.medina.toolbox.arrays;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class CountInversionsLists {

	/*
	 * NUMBER OF INVERSIONS is a metric that indicates how far an array is from
	 * being sorted.
	 * 
	 * Solution #1: 
	 * 
	 * Brute force; check all pairs; O(n^2)
	 * 
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
	
	/* 
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
	
	public Output mergeAndCount(List<Integer> A, List<Integer> B) {

		Output res = new Output();

		int a = 0, b = 0, crossInvCount = 0;

		while (a < A.size() && b < B.size()) {

			int next = Math.min(A.get(a), B.get(b));
			res.list.add(next);

			/* If B's component is next, then there will be an inversion between that
			 * element and each element remaining in A */
			if (B.get(b) == next) {
				b += 1;
				crossInvCount += A.size() - a;
			} else {
				a += 1;
			}
		}

		while (a < A.size()) {
			res.list.add(A.get(a));
			a += 1;
		}

		while (b < B.size()) {
			res.list.add(B.get(b));
			b += 1;
		}

		res.count = crossInvCount;

		return res;
	}

	public Output sortAndCount(List<Integer> L) {

		Output res = new Output();

		if (L.size() == 1) {
			res.count = 0;
			res.list.add(L.get(0));
			return res;
		}

		if (L.size() == 2) {
			if (L.get(0) > L.get(1)) {
				res.count = 1;
				res.list.add(L.get(1));
				res.list.add(L.get(0));
			} else {
				res.count = 0;
				res.list.add(L.get(0));
				res.list.add(L.get(1));
			}
			return res;
		}

		List<Integer> A = new ArrayList<Integer>();
		List<Integer> B = new ArrayList<Integer>();

		int m = L.size()/ 2;

		for (int i = 0; i <= m; i++) {
			A.add(L.get(i));
		}
		for (int i = m + 1; i < L.size(); i++) {
			B.add(L.get(i));
		}

		Output invA = sortAndCount(A);
		Output invB = sortAndCount(B);

		Output crossInv = mergeAndCount(invA.list, invB.list);

		res.count = invA.count + invB.count + crossInv.count;
		res.list = crossInv.list;

		return res;

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
		
		CountInversionsLists ci = new CountInversionsLists();

		int a[] = {50, 1, 20, 6, 4};
		int ni = ci.bruteForceCountInversions(a);
		System.out.printf("NI: %d\n", ni);
		
		List<Integer> l = new ArrayList<Integer>();
		for (int i = 0; i < a.length; i++) {
			l.add(a[i]);
		}
		
		Output res = ci.sortAndCount(l);
		System.out.printf("Inv: %d\n", res.count);
	}

}
