package com.medina.toolbox.strings;

public class MaxOcurringCharacter {

	private int NUMOFCHARS = 256;
	
	
	public Character maxOcurringCharacter(String s) {
			
		/* STATE: Array of visit count for each character */
		int[] visited = new int[NUMOFCHARS];
		for (int i = 0; i < NUMOFCHARS; i++) {
			visited[i] = 0;
		}
				
		Character maxChar = null;
		int maxVisited = 0;
		
		for (int i = 0; i < s.length(); i++) {
			
			Character c = s.charAt(i);
			
			int idx = Integer.valueOf(s.charAt(i)) - 'A';
			
			if (idx < 0) {
				continue;
			}
			
			visited[idx] += 1;
			
			if (visited[idx] > maxVisited) {
				maxVisited = visited[idx];
				maxChar = s.charAt(i);
			}
		}
				
		return maxChar;
		
	}
	
	public void maxOccurringCharacterDriver() {
		String s = "test stringssiiaadfaaffaaraa";
		Character c = maxOcurringCharacter(s);
		System.out.printf("maxChar: %c", c);		
	}
	
	public static void main(String[] args) {
		MaxOcurringCharacter m = new MaxOcurringCharacter();
		m.maxOccurringCharacterDriver();

	}

}
