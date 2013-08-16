package com.medina.toolbox.strings;

import java.util.Arrays;

public class RemoveCharactersInStr1FromStr2 {

	public static int NUMOFCHARS = 26;
	private int[] seenCharacters = new int[NUMOFCHARS];
	
	public RemoveCharactersInStr1FromStr2() {
		for (int i = 0; i < NUMOFCHARS; i++) {
			seenCharacters[i] = 0;
		}		
	}
	
	public String removeCharactersInStr1FromStr(String str1, String str2) {		
		
		/* Phase 1: Mark characters in Str2 */
		String res  = "";
		for (int i = 0; i < str2.length(); i++) {
			seenCharacters[Integer.valueOf(str2.charAt(i)) - 'a'] += 1;
		}
		
		/* Phase 2: Scan Str2, ignore characters SEEN in Str1, produce resulting string */
		for (int i = 0; i < str1.length(); i++) {			
			if (seenCharacters[Integer.valueOf(str1.charAt(i)) - 'a'] > 0) {
				continue;
			}			
			res += str1.charAt(i);
		}
		
		return res;
	}
	
	public void removeCharacteresDriver() {
		
		String str1 = "geeksforgeeks";
		String str2 = "s";
		
		String res = removeCharactersInStr1FromStr(str1, str2);
		
		System.out.printf("Str1: %s Str2: %s res: %s", str1, str2, res);
		
	}
	
	public static void main(String[] args) {

		RemoveCharactersInStr1FromStr2 r = new RemoveCharactersInStr1FromStr2();
		r.removeCharacteresDriver();
	}

}
