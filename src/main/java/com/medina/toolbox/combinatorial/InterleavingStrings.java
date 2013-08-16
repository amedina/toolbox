package com.medina.toolbox.combinatorial;

public class InterleavingStrings {

	/*
	 * Given two strings, str1 and str2, print all possible interleavings of
	 * them; A string interleaving preserves the ordering of the original
	 * strings. Ex: str1 = "AB", str2 = "CD" Interleavings:"ABCD", "ACBD",
	 * "ACDB", "CABD", "CDAB", "CABD"
	 * 
	 * The key idea of this problem is to use recursion and an auxiliary array
	 * to keep track of each individual interleaving and the recursion
	 * progresses.
	 * 
	 * Another key point in this problem is to realize that any interleaving (or
	 * its substrings) start with either a character from str1 or a character
	 * from str2. This yields the recurrence:
	 * 
	 * 		count(m, n) = count(m - 1, n) + count(m, n - 1)
	 * 
	 * We use this recurrence to guide the construction of the recursive function
	 */
	
	public void printAllInterleavingsRecurr(String str1, String str2, String interleaving, int m, int n) {
		
		/* If we used all characters from str1 and there are some left in str2 */
		if (m == str1.length() && n < str2.length()) {
			System.out.println(interleaving + str2.substring(n));
			return;
		}
		
		/* If we used all characters from str2 and there are some left in str1 */
		if (n == str2.length() && m < str1.length()) {
			System.out.println(interleaving + str1.substring(m));
			return;
		}
		
		/* If we used all characters from both strings */
		if (m == str1.length() && n == str2.length()) {
			System.out.println(interleaving);
		}
	
		/* Case: interleaving "continues" with a character from str1 */
		printAllInterleavingsRecurr(str1, str2, interleaving + str1.charAt(m), m + 1, n);
		
		/* Case: interleaving "continues" with a character from str2 */
		printAllInterleavingsRecurr(str1, str2, interleaving + str2.charAt(n), m, n + 1);
		
	}
	
	public void printAllInterleavings() {
		
		String str1 = "ABC";
		String str2 = "DEF";
		
		String interleaving = new String();
		
		int m = str1.length();
		int n = str2.length();
		
		printAllInterleavingsRecurr(str1, str2, interleaving, 0, 0);
		
		
	}
	public static void main(String[] args) {
		
		InterleavingStrings is = new InterleavingStrings();		
		is.printAllInterleavings();
	}

}
