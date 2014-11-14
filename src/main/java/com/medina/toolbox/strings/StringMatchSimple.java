package com.medina.toolbox.strings;

//import org.slf4j.Logger;
//import org.slf4j.LoggerFactory;

public class StringMatchSimple {

//	private static Logger log = LoggerFactory.getLogger(StringMatchSimple.class);
		
	
	/*
	 * KEY IDEA: 
	 * 
	 * STATE:
	 * 
	 * TWO POINTERS (i, j): one into source string, S; 
	 * the other into the target string, T
	 * 
	 * ALGORITHM
	 * 
	 * (1) Start: i = 0; j = 0
	 * (2) Iterate over both a the same time
	 * (3) If s(i) == (t(j): advance both pointers
	 * (4) Else: Advance pointer i, reset pointer j to start of t
	 * (5) If at any point the end of T is reached, return i - T.length()
	 * (6) If the end of T is never reached, return NOT_FOUND (-1)
	 */
	public static int stringMatch(String s, String t) {
		
		int i = 0;
		int j = 0;
		
		while (i < s.length() && j < t.length()) {
			
			if (t.charAt(j) == s.charAt(i)) {
				i++;
				j++;
			}else {
				i++;
				j = 0;
			}
			if (j == t.length()) {
				return i - t.length();
			}			
		}
		
		return -1;
		
	}
	
	public static boolean isSubstringSimple(String s, String t) {
		
		int i = 0;
		int j = 0;
		
		while (i < s.length() && j < t.length()) {
			
			if (t.charAt(j) == s.charAt(i)) {
				i++;
				j++;
			}else {
				i++;
				j = 0;
			}
			if (j == t.length()) {
				return true;
			}			
		}
		
		return false;
		
	}
	
	public static boolean isSubstring(String a, String b) {
		System.out.println("A: " + a  + " B: " + b);
		return b.matches("(.*)" + a + "(.*)");
	}
	
	public static void main(String[] args) {
		
		String t = "abc";
		String s = "xyz abzxy axab xabc xyz";
		
		System.out.println("s: " + s + " t: " + t + " i: " + StringMatchSimple.stringMatch(s, t));

	}

}
