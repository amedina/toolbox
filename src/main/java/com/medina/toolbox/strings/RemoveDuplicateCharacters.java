package com.medina.toolbox.strings;

public class RemoveDuplicateCharacters {


	public static int NUMOFCHARS = 26;
	private int[] seenCharacters = new int[NUMOFCHARS];
	
	public RemoveDuplicateCharacters() {		
		for (int i = 0; i < NUMOFCHARS; i++) {
			seenCharacters[i] = 0;
		}
	}
	
	public String removeDuplicateCharacters(String str1) {
		
		String res  = "";
		
		for (int i = 0; i < str1.length(); i++) {
			seenCharacters[Integer.valueOf(str1.charAt(i)) - 'a'] += 1;
		}
		
		for (int i = 0; i < str1.length(); i++) {			
			if (seenCharacters[Integer.valueOf(str1.charAt(i)) - 'a'] > 1) {
				continue;
			}			
			res += str1.charAt(i);
		}
		
		return res;
	}
	
	public void removeDuplicateCharactersDriver() {
		
		String str1 = "albertomedina";
		
		String res = removeDuplicateCharacters(str1);
		
		System.out.printf("Str1: %s res: %s", str1, res);
		
	}
	public static void main(String[] args) {

		RemoveDuplicateCharacters r = new RemoveDuplicateCharacters();
		r.removeDuplicateCharactersDriver();
	}

}
