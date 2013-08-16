package com.medina.toolbox.strings;

public class StringRotations {

	/*
	 * KEY IDEA:
	 * 
	 * (1) Concatenate the source string with itself
	 * (2) Check if the target string is a substring of the above concatenation
	 * (3) If so, the target string is a rotation of the source string
	 */
	
	public boolean checkStringRotation(String a, String b) {
	
		if (a.length() != b.length()) {
			return false;
		}
		
		String all = a + a;
		
		return StringMatchSimple.isSubstringSimple(all, b);
		
	}
	
	public static void main(String[] args) {
		
		StringRotations r = new StringRotations();
		String a = "ABCD";
		String b = "CDAB";
		
		boolean areRot = r.checkStringRotation(a, b);
		
		System.out.printf("A: %s B: %s R: %b", a, b, areRot);

	}

}
