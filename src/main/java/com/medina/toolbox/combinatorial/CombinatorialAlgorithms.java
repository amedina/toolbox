package com.medina.toolbox.combinatorial;

public class CombinatorialAlgorithms {


	/*
	 * For a given string, determine its rank over all permutations in
	 * lexicographical order.
	 */
	
	public long fact(int n) {
		
		long fact = 1;
		int i = n;
		while (i > 0) {
			fact *= i;
			i--;
		}
		
		return fact;
		
	}
	
	public int howManySmallerToTheRight(String s, int index) {
		
		int count = 0;
		for (int i = index + 1; i < s.length(); i++) {
			if (Integer.valueOf(s.charAt(index)) > Integer.valueOf(s.charAt(i))) {
				count++;
			}
		}
		
		return count;
	}
	
	public int computeRank(String s) {
		
		int rank = 0;
		
		for (int i = 0; i < s.length(); i++) {
			int smaller = howManySmallerToTheRight(s, i);
			long f = fact(s.length() - (i + 1));
			rank += (smaller * f);		
		}
		
		return rank + 1;
		
	}
	
	public void computeRankingDriver() {
		
		String s = "ZYXWVU";
		int rank = computeRank(s);
		System.out.printf("s: %s R: %d", s, rank);
		
	}
	
	public static void main(String[] args) {
		
		CombinatorialAlgorithms ca = new CombinatorialAlgorithms();
		ca.computeRankingDriver();
	}

}
