package com.medina.toolbox.recursion;

/**
 * Design an algorithm that takes a string s and a string r,
 * assumed to be a well-formed ESRE, and checks if r matches s
 * @author amedina
 */
public class RegexChecker {

	// Key: proper use of recursion
	// If r starts with ^, then the remainder of r must strictly match a prefix of s.
	// If r ends with a $, some suffix pf s must be strictly matched by r without the trailing $
	// Otherwise, r must strictly match some substring of s

	// isMatch: the function that checks whether r strictly matches a prefix of s
	// This function muct check the following cases:
	// (1) Length of r == 0: RegExp matching everything
	// (2) (a) r starts with ^ or (b) ends with $
	// (3) r starts with * (a*wXY) (.*Wa)
	// (4) r starts with an alphanumeric character or dot

	public static Boolean isMatchHere(String r, String s) {

		// Case (1): base case
		if (r.isEmpty()) {
			return true;
		}

		// Case (2):(b)
		if (r.startsWith("$") && (r.length() == 0)) {
			return s.isEmpty();
		}

		// Case (3): starts with an '*'
		if (r.length() >= 2 && r.substring(1,2).compareTo("*") == 0) {
			for (int i = 0; i < s.length() && (r.startsWith(".") || r.startsWith(s.substring(i, i + 1))); i++) {
				if (isMatchHere(r.substring(2), s.substring(i + 1))) {
					return true;
				}
			}
			return isMatchHere(r.substring(2), s);
		}

		// Case(4):
		return !s.isEmpty() &&
				(r.startsWith(".") || r.startsWith(s.substring(0,1))) &&
				isMatchHere(r.substring(1), s.substring(1));
	}

	public static Boolean isMatch(String r, String s) {

		if (r.startsWith("^")) {
			return isMatchHere(r.substring(1), s);
		}

		for (int i = 0; i < s.length(); i++) {
			if (isMatchHere(r, s.substring(i))) {
				return true;
			}
		}

		return false;
	}

	public static void main(String[] args) {

		String s = "wxyzaaawxy";
		//String r = "*aaa*";
		String r = ".b*";
		Boolean matches = RegexChecker.isMatch(r, s);
		System.out.printf("S: %s R: %s M: %s\n", s, r, matches);

	}


}
