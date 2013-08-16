package com.medina.toolbox.strings;

/*
 * Problem: Find the LONGEST SUBSTRING which contains NO REPEATED Characters
 * 
 * KEY IDEAS:
 * 
 *  (1) Perform one pass over the string; 
 *  (2) Maintain an extra array (visited) to keep track of when different characters 
 *      have been visited; this extra array will contain one entry per alphabet character, 
 *      and therefore its size will that of the alphabet (NUMOFCHARS). Initialize
 *      visited array to all -1, and set the visited entry for the initial character of 
 *      the string as 0 (start).
 *      
 *      The VISITED array entries correspond to indices in the string
 * 
 *  (3) At every step, starting with the second character of the string,check if
 *  the current character has been visited before; 
 *  
 *  (4) If CURRENT CHARACTER has not been visited (prevIndex = visited[s.char(i)] == NOTVISITED), 
 *      increase the current length count (currLen) by one;
 *       
 *      If CURRENT CHARACTER has been visited, but the character seen before does IS NOT INCLUDED 
 *      in the run currently being considered (i - currLen > prevIndex), 
 *      also increase the currLen by one.
 * 
 * If the repeated character seen last time is indeed part of the current
 * substring being analyzed, which means that i - < currLen <= prevIndex (it
 * should be equal at most), then (1) check if currLen is the longest
 * substring seen so far (currLen > maxLen); if so, update it; finally,
 * update currLen = i - prevIndex, and set visited[char(i)] = i.
 */

public class LongestSubstringNonRepeatingCharacters {

	private int NUMOFCHARS = 256;
	private int NOTVISITED = -1;
	
	
	public int getIndexOf(char c) {
		int index = Integer.valueOf(c) - 'A';
		return index;
	}
	public int longestNonRepeatingSubstring(String s) {
		
		int currLen = 1;
		int maxLen = 1;
		
		/* Initialize VISITED array */
		int[] visited = new int[NUMOFCHARS];
		for (int i = 0; i < NUMOFCHARS; i++) {
			visited[i] = NOTVISITED;
		}
		
		int idx = getIndexOf(s.charAt(0));
		visited[idx] = 0;
		
		System.out.printf("charAt(%d): %s prevIndex: %d currIdx: %d\n", 0, s.charAt(0), -1, 0);
		
		for (int i = 1; i < s.length(); i++) {
			
			int index = getIndexOf(s.charAt(i));
			
			/* What is the INDEX of the previous character like this one */
			int prevIndex = visited[index];
			
			System.out.printf("charAt(%d): %s prevIndex: %d currIdx: %d\n", i, s.charAt(i), prevIndex, i);
			
			if (prevIndex == NOTVISITED || (i - currLen > prevIndex)) {
				currLen += 1;
			}else {				
				maxLen = (currLen > maxLen)?currLen:maxLen;
				currLen = i - prevIndex;
			}
			
			visited[index] = i;
		}
	
		
		return maxLen;
		
	}
	
	public void longestNonRepeatingSubstringDriver() {
		
		String s = "ABDEFGABEF";
		String s2 = "abdeFgAbef";
		int maxLen = longestNonRepeatingSubstring(s);
		System.out.printf("S: %s ML: %d\n", s, maxLen);
	}
	
	public static void main(String[] args) {
		LongestSubstringNonRepeatingCharacters ls = new LongestSubstringNonRepeatingCharacters();
		ls.longestNonRepeatingSubstringDriver();
	}

}
