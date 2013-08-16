package com.medina.toolbox.strings;

public class ReverseStringWithRecursion {

	/*
	 * Reverse string with recursion: the idea is to call the function
	 * recursively keeping track of the end of the string on every call; Use two
	 * parameters, the string being reversed and the current position in the
	 * string; when the current position reaches the length of the string,
	 * return. The return of the last call will chain with the return of all
	 * previous calls, printing at each one the next lower character in the
	 * string.
	 */
	
	public static void reverseStringWithRecursion(String s, int n, StringBuilder r) {
		
		/* Base Case: Checkif current index ix the string length */
		if (s.length() == n) {
			return;
		}
		
		/* Recursive call */
		reverseStringWithRecursion(s, n + 1, r);
		
		/* Apend character at position n to r */
		r.append(s.charAt(n));

	}
	
	public static void main(String[] args) {
		
		String s = "Alberto Medina";
		StringBuilder r = new StringBuilder();
		
		ReverseStringWithRecursion.reverseStringWithRecursion(s, 0, r);
		
		System.out.println("S: " + s + " R: " + r.toString());
		
	}

}
