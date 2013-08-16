package com.medina.toolbox.lists;

import java.util.ArrayList;
import java.util.List;

public class MatchingListItems {

	public static void setMapForTargetWord(int[] map, String word) {

		int index = 0;
		for (int i = 0; i < word.length(); i++) {
			index = Integer.valueOf(word.charAt(i)) - 'a';
			map[index] = 1;
		}
		
	}
	
	public static List<String> matchingElements(String target, List<String> list) {
		
		int count;
		int[] letterMap = new int[256];
		List<String> result = new ArrayList<String>();
		
		for (String s : list) {
			
			setMapForTargetWord(letterMap, target);			
			
			count = 0;			
			for (int i = 0; i < s.length(); i++) {
				
				int mapIndex = Integer.valueOf(s.charAt(i)) - 'a';
				
				if (letterMap[mapIndex] == 1) {				
					letterMap[mapIndex] = 0;
					count += 1;
					if (count == s.length()) {
						result.add(s);
						break;
					}
				}
				
			}
			
		}
		
		return result;
		
	}
	
	
	public static void main(String[] args) {

		List<String> elements = new ArrayList<String>();
		elements.add("geeksforgeeks");
		elements.add("unsorted");
		elements.add("sunday");
		elements.add("just");
		elements.add("sss");
		
		String target = "abcdseufgnhidjkalmynopqrstuv";
		
		List<String> result = MatchingListItems.matchingElements(target, elements);	
		
		System.out.println("RESULT for Target: " + target);
		for (String word : result) {
			System.out.println("Word: " + word);
		}		
		
 
	}

}
