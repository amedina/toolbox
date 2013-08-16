package com.medina.toolbox.arrays;

public class Majority {

	/* 
	 * PROBLEM: Find the element, in any, in an array that appears more than n/2 time
	 *
	 * Solution #1: BRUTE FORCE
	 *  - Two loops; 
	 *  - Count number of times each element appears in array 
	 *  - Complexity: O(n^2)
	 *
	 * Moore's voting algorithm:
	 * Do a scan of the array keeping track of two things:
	 * 
	 * (1) counter variable: if two adjacent elements are equal, increase
	 * count by 1; else decrease count by one; and 
	 * (2) mCandidate (majority candidate), is set to index i, every time the variable count reaches 1.
	 * 
	 * This algorithm identifies the majority element if there is one; therefore, we need
	 * a two-phase algorithm: (1) determine candidate; (2) verify candidate appears n/2 times
	 */
	
	public int getMajorityElement(int[] a) {
		
		if (a == null || a.length == 0) { throw new IllegalArgumentException();}
		
		/* Initialize potential majority candidate as element at index 0;
		 * Update it every time count decreases to 0 */
		int count = 1;
		int mCandidateIndex = 0;	
		
		/* Phase #1: determine a potential majority candidate */
		for (int i = 1; i < a.length; i++) {
			
			if (a[i] == a[mCandidateIndex]) {
				count += 1;
			}else {
				count -= 1;
			}
			
			if (count == 0) {
				count = 1;
				mCandidateIndex = i;
			}
		
		}
		
		/* Phase #2: Verify if the majority candidate actually is one */
		int mCandidateElement = a[mCandidateIndex];
		int majority = (int) Math.floor(a.length / 2);
		for (int i = 0; i < a.length; i++) {
			if (a[i] == mCandidateElement) {
				count += 1;
			}
		}
		System.out.println("MCandiate: " + mCandidateElement + " Num: " + count + " Maj: " + majority);
		if (count >= majority) {
			return mCandidateElement;	
		}else {
			return -1;
		}
		
		
	}
	
	public static void main(String[] args) {
		
		int[] a = {5,3,5,3,5,5,6,5,4,5,7,5,5,3,5,5,4,5,4,2,4,4,5};
		Majority m = new Majority();
		int me = m.getMajorityElement(a);
		System.out.println("M: " + me);
		
	}

}
