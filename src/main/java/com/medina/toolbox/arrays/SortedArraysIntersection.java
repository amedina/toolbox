package com.medina.toolbox.arrays;

import java.util.ArrayList;
import java.util.List;

public class SortedArraysIntersection {

	public static void printList(List<Integer> a) {
		for (int i = 0; i < a.size(); i++) {
			System.out.println(a.get(i));
		}
	}

	public static int binarySearch(int[] a, int k) {

		int l = 0;
		int r = a.length;

		while (l <= r) {
			int m = l + ((r - l) >> 1);
			int val = a[m];

			if (val == k) {
				return m;
			}
			if (val > k) {
				r = m - 1;
			}else {
				l = m + 1;
			}
		}
		return -1;
	}


	public static void printArray(int[] a) {
		for (int i = 0; i < a.length; i++) {
			System.out.println(a[i]);
		}
	}

	/**
	 * Complexity O(mn) regardles of sorting status
	 *
	 * @param a
	 * @param b
	 * @return
	 */
	public static List<Integer> intersectSortedArraysOne(int[] a, int[] b) {

		ArrayList<Integer> result = new ArrayList<Integer>();

		for (int i = 0; i < a.length; i++) {
			if (i == 0 || a[i] != a[i -1]) {
				for (int j = 0; j < b.length; j++) {
					if (a[i] == b[j]) {
						result.add(a[i]);
						break;
					}
				}
			}
		}

		return result;
	}


	/**
	 * Complexity O(nlogm)
	 * We can further improve it if we choose the larger array for the inner loop;
	 * since n << m => mlogn >> nlogm
	 * This is the best solution if one of the arrays is much shorter than the other.
	 */
	public static List<Integer> intersectSortedArraysTwo(int[] a, int[] b) {

		ArrayList<Integer> result = new ArrayList<Integer>();

		for (int i = 0; i < a.length; i++) {
			if (i == 0 || a[i] != a[i -1]) {
				if (SortedArraysIntersection.binarySearch(b, a[i]) >= 0) {
					result.add(a[i]);
				}
			}
		}

		return result;
	}

	/**
	 * Take advantage of arrays being sorted: iterate in tandem through the elements of
	 * each array in increasing order.
	 * Complexity: O(m + n)
	 */
	public static List<Integer> intersectSortedArraysThree(int[] a, int[] b) {
		ArrayList<Integer> result = new ArrayList<Integer>();
		int i = 0;
		int j = 0;
		while (i < a.length && j < b.length) {
			if ((i == 0 || a[i] != a[i - 1]) && (a[i] == b[j])) {
				result.add(a[i]);
				i++;
				j++;
				continue;
			}
			if (a[i] < b[j]) {
				i++;
			}else {
				j++;
			}
		}
		return result;
	}

	public static void main(String[] args) {
		int[] a = {1,2,3,4,5,6,7,8,9,10};
		int[] b = {5,6,7,8,9,10,11,12};

		System.out.println("Solution one: loop join");
		List<Integer> res = SortedArraysIntersection.intersectSortedArraysOne(a, b);
		SortedArraysIntersection.printList(res);

		System.out.println("Solution two: binary search on b");
		res = SortedArraysIntersection.intersectSortedArraysTwo(a, b);
		SortedArraysIntersection.printList(res);

		System.out.println("Solution three: iterate in tandem");
		res = SortedArraysIntersection.intersectSortedArraysThree(a, b);
		SortedArraysIntersection.printList(res);


	}
}
