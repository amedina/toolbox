package com.medina.toolbox.recursion;

public class StringPermutations {

	/*
	 * Each letter will be start a subset of the permutations.
	 * 
	 * Once a letter is chosen, we must produce all the possible permutations
	 * with the remaining letters and concatenate the initial letter with each
	 * of them.
	 * 
	 * Once a letter has been selected as part of a given permutation, that
	 * letter cannot be used to fill any of the remaining positions of that
	 * permutation. To achieve this, we need to keep track of which letters have
	 * been used as the algorithm progresses.
	 * 
	 */
	public static int getIndexValue(Character c) {
		int index = Integer.valueOf(c) - 'a';
		return index;
	}
	public static void print(String s) {
		
		boolean[] used = new boolean[26];		
		String perm = "";
		printAux(s, used, perm);
	}
	
	public static void printAux(String s, boolean[] used, String perm) {
		
		if (perm.length() == s.length()) {
			System.out.println(perm);
			return;
		}
		
		for (int i = 0; i < s.length(); i++) {
			
			/* Skip letters that have been used */
			if (used[getIndexValue(s.charAt(i))] == true) {
				continue;				
			}
			String prevPerm = perm;
			perm += s.charAt(i);
			used[getIndexValue(s.charAt(i))] = true;
			
			printAux(s, used, perm);
			
			/* Revert changes */
			used[getIndexValue(s.charAt(i))] = false;
			perm =prevPerm;
		}
		
	}
	
	public static void main(String[] args) {
		
		String s = "abcd";
		StringPermutations.print(s);

	}

}
