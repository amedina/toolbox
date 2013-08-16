package com.medina.toolbox.strings;

public class FindFirstNonRepeatingCharacter {

	private static int NUMOFCHARS = 26;
	private int[] seen;
	
	public FindFirstNonRepeatingCharacter() {
		seen = new int[NUMOFCHARS];
	}
	
	
	/*
	 * KEY IDEA: 
	 * () Define "seen" array, with one counter entry per character (or another dictionary structure)
	 * () TWO passes;
	 * () First pass: scan string and populate SEEN data structure
	 * () Second pass: scan string and check for each character if its counter entry in SEEN is == 1
	 * () Return that character or NOT FOUND 
	 */
	public int findFirstNonRepeatingCharacter(String s) {
		
		for (int i = 0; i < s.length(); i++) {
			seen[Integer.valueOf(s.charAt(i) - 'a')] +=1;
		}
		
		for (int i = 0; i < s.length(); i++) {
			if (seen[Integer.valueOf(s.charAt(i) - 'a')] == 1) {
				return i;
			}
		}
		
		return -1;
		
	}
	
	public static void main(String[] args) {

		FindFirstNonRepeatingCharacter f = new FindFirstNonRepeatingCharacter();
		String input = "fdgfhgegdgazgdhearvfgrgvdf";
		
		int i = f.findFirstNonRepeatingCharacter(input);
		if (i > 0) {
			System.out.printf("First non-repeating character: %s\n",  input.charAt(i));
		}else {
			System.out.println("Input does not have unique characters!");
		}
	}

}
