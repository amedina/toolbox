package com.medina.toolbox.strings;

import java.util.LinkedList;
import java.util.Queue;

public class FindSmallestWindowWithAllCharacters {

	private static final int NUMCHARS = 256;

	/*
	 * Solution #1: BRUTE FORCE
	 * 
	 * Input: (1) Container string Str1; (2) Target string Str2
	 * Output: Indices (i, j) of Str1 for the smallest window containing all the
	 * characters in Str2, or (-1,-1) if no substring exists.
	 * 
	 * Generate all substrings of the input "contained" string;
	 * For each substring, check if it contains all the characters in Str2; for each 
	 * one that does, check if its length is smaller than the current minimum-length string 
	 * seen so far (containing all characters in Str2);
	 */
	
	public Pair getSmallestWindowWithAllCharacters(String str1, String str2) {
		
		int sCount = 0;
		
		/* STATE */
		int[] count = new int[NUMCHARS];
		int[] countInCurrWindow = new int[NUMCHARS];
		Queue<Character> q = new LinkedList<Character>();
		int minStart = -1;
		int minEnd = -1;
	
		for (int i  = 0; i < str2.length(); i++) {
			int index = Integer.valueOf(str2.charAt(i));
			count[index] += 1;
		}
		
		/* Phase 1: Find FIRST Window containing ALL characters */
		int start = -1;
		int end = -1;
		for (int i  = 0; i < str1.length(); i++) {
			
			Character c = str1.charAt(i);			
			int index = Integer.valueOf(str1.charAt(i));

			q.add(c);
			
			if (count[index] > 0) {
				
				if (sCount == 0) {
					minStart = i;
					start = i;
				}
				if (countInCurrWindow[index] < count[index]) {
					sCount += 1;
				}
				countInCurrWindow[index] += 1;
			}
			
			if (sCount == str2.length()) {
				end = i;
				minEnd = end;
				break;
			}
			
		}
				
		/* 
		 * Phase 2: Update incrementally searching for a smaller window
		 * containing all characters
		 */
		int minLength = end - start;
		
		for (int i = end + 1; i < str1.length(); i++) {
			
			Character c = str1.charAt(i);
			
			int index = Integer.valueOf(str1.charAt(i));					

			q.add(c);
			
			if (count[index] > 0) {
				
				countInCurrWindow[index] += 1;
				
				if (c == q.peek()) {
					
					end = i;
					start += 1;
					q.remove();
					
					countInCurrWindow[index] -= 1;
					
					Character qPeek = q.peek();
					int qPeekIndex = Integer.valueOf(qPeek);
					
					while (!q.isEmpty() && ((count[qPeekIndex] == 0 || countInCurrWindow[qPeekIndex] > count[qPeekIndex]))) {						
						start += 1;
						q.remove();
						if (countInCurrWindow[qPeekIndex] > 1) {
							countInCurrWindow[qPeekIndex] -= 1;
						}
						if (!q.isEmpty()) {
							qPeek = q.peek();
							qPeekIndex = Integer.valueOf(qPeek);
						}
					}					
				}
				
				int newLen = end - start;
				if (newLen < minLength) {
					minStart = start;
					minEnd = end;
					minLength = end - start;
				}
			}			
		}
		
		return new Pair(minStart, minEnd);		
	}
	
	
	private class Pair {
		public int i;
		public int j;
		public Pair(int i, int j) {
			super();
			this.i = i;
			this.j = j;
		}
		@Override
		public String toString() {
			StringBuilder builder = new StringBuilder();
			builder.append("Pair [i=");
			builder.append(i);
			builder.append(", j=");
			builder.append(j);
			builder.append("]");
			return builder.toString();
		}
		
	}
	
	public static void main(String[] args) {

		FindSmallestWindowWithAllCharacters f = new FindSmallestWindowWithAllCharacters();
		
		String str1 = "this t stri is a test straaaing";
		String str2 = "tist";
		
		Pair r = f.getSmallestWindowWithAllCharacters(str1,  str2);
		System.out.println(r);
		System.out.println(str1.substring(r.i, r.j + 1));
		
	}

}
