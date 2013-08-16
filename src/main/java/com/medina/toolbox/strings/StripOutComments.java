package com.medina.toolbox.strings;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.InputStreamReader;
import java.util.Deque;
import java.util.LinkedList;

public class StripOutComments {

	private final static int STATE_0 = 0;
	private final static int STATE_1 = 1;
	private final static int STATE_2 = 2;
	private final static int STATE_3 = 3;
	private final static int STATE_4 = 4;
	private final static int STATE_5 = 5;
	
	public String cleanFileComments(String fileName) throws Exception{
				
		FileInputStream fis = new FileInputStream(fileName);
		InputStreamReader isr = new InputStreamReader(fis);
		BufferedReader br = new BufferedReader(isr);
		
		Deque<Character> q = new LinkedList<Character>();
		int currState = STATE_0;
		
		int r;
		while ((r = br.read()) != -1) {
			
			Character c = new Character((char)r);
			
			switch(currState) {
			case STATE_0:
				q.addLast(c);
				if (c.compareTo('#') == 0) {
					currState = STATE_1;	
				}				
				break;
			case STATE_1:
				q.addLast(c);
				if (c.compareTo('#') == 0) {
					currState = STATE_2;	
				}else {
					currState = STATE_0;
				}
				break;
			case STATE_2:				
				if (c.compareTo('#') == 0) {
					currState = STATE_3;
					q.removeLast();
					q.removeLast();
				}else {
					currState = STATE_0;
				}
				break;
			case STATE_3:
				if (c.compareTo('#') == 0) {
					currState = STATE_3;	
				}else {
					currState = STATE_4;
				}
				break;
			case STATE_4:
				if (c.compareTo('#') == 0) {
					currState = STATE_5;	
				}
				break;
			case STATE_5:
				if (c.compareTo('#') == 0) {
					currState = STATE_5;	
				}else {
					currState = STATE_0;
				}
				break;
			}	
		}
		
		StringBuilder result = new StringBuilder();
		while (!q.isEmpty()) {
			result.append(q.remove());
		}
		
		return result.toString();
	
	}
	
	public static void main(String[] args) {
		
		String fileName = "data/StripOutComments01.txt";
		
		StripOutComments soc = new StripOutComments();
		String result = "";
		try {
			result = soc.cleanFileComments(fileName);
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		System.out.printf("%s\n", result);

	}

}
