package com.medina.toolbox.strings;

public class ReverseStringSimple {
	
	public static String reverseString(String s, int start, int end) {

		StringBuilder reverse = new StringBuilder();
		
		int length = s.length();
		
		if (start < 0 || end > length) {
			throw new IllegalArgumentException();
		}
		
		for(int i = 0; i < start ; i++) {
			char c = s.charAt(i);
			reverse.append(c);
		}
		
		for(int i = end; i >= start; --i) {
			char c = s.charAt(i);
			reverse.append(c);
		}
		
		for(int j = end + 1; j < length ; j++) {
			char c = s.charAt(j);
			reverse.append(c);
		}
		
		return reverse.toString();
		
	}
	
	public static String reverseString(String a) {
		
		int length = a.length();
		StringBuilder reverse = new StringBuilder();
		
		for(int i = length; i > 0; --i) {
			char result = a.charAt(i-1);
			reverse.append(result);
		}
		
		return reverse.toString();
		
	}
	
	public static void main(String[] args) {
		
		String str = "This is a long string REVERSE THIS PART ONLY please, if you can";
		
		String r = ReverseStringSimple.reverseString(str, 22, 43);
		
		System.out.printf("S: %s\n", str);
		System.out.printf("R: %s\n", r);

	}

}
