package com.medina.toolbox.backtracking;

import java.util.ArrayList;

public class GenerateStringSubsets {


	public static void main(String[] args) {

		BackTrackingProceduresStringSubsets proc = new BackTrackingProceduresStringSubsets();
		Backtracking bt = new Backtracking(proc);
		
		String input = "abc";
		ArrayList<Integer> a = new ArrayList<Integer>(input.length() + 1);
		for (int i = 0; i <= input.length(); i++) {
			a.add(0);
		}
		bt.backtrack(a, -1, input);

	}

}
