package com.medina.toolbox.strings;

public class ReverseStringWordWise {

	/*
	 * Reverse a string word-wise
	 * 
	 * e.g.: "I like this very much" --> "much very this like I"
	 * 
	 * Key idea: (1) reverse each word individually; (2) reverse the whole
	 * string.
	 * 
	 * To reverse each word individually, do:
	 * 
	 * (1) Use three pointers: i, j, k
	 * (2) Repeat until the end of the string is found:
	 * (3) Seek next blank character (separator) or end of string moving j and k there
	 * (4) Swap characters by moving i++ and j-- until i == j
	 */
	
	public void reverse(char[] sa, int i, int j) {
		
		while (i < j) {
			char c = sa[i];
			sa[i] = sa[j];
			sa[j] = c;
			i++;
			j--;
		}
	}
	
	public String reverseStringWordWise(String s) {
		
		int i = 0, j = 0, k = 0;		
		char[] sa = s.toCharArray();
		
		/* Reverse individual words */
		while (i < s.length()) {
			
			/* Look for next non-character or end of string (NEXT WORD) */
			while (j < s.length() && sa[j] != ' ') {
				j++;
			}
			k = j;
			j--;
			
			/* At this point, (i, j) = (begin,end) of the current word */
			reverse(sa, i, j);
			
			i = k + 1;
			j = k + 1;
			
		}
		
		/* Reverse WHOLE string */
		reverse(sa, 0, sa.length - 1);
		
		
		return new String(sa);
	}
	
	public void reverseStringWordWiseDriver() {
		String s = "I like this very much";
		String r = reverseStringWordWise(s);
		System.out.printf("S: %s\nR: %s", s, r);
	}
	
	public static void main(String[] args) {

		ReverseStringWordWise rs = new ReverseStringWordWise();
		rs.reverseStringWordWiseDriver();
	}

}
