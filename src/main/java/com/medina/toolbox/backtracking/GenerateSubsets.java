package com.medina.toolbox.backtracking;

import java.util.ArrayList;

public class GenerateSubsets {


	public static void main(String[] args) {

		BackTrackingProceduresSubsets proc = new BackTrackingProceduresSubsets();
		Backtracking bt = new Backtracking(proc);
		
		int n = 10;
		ArrayList<Integer> a = new ArrayList<Integer>(n + 1);
		for (int i = 0; i <= n; i++) {
			a.add(0);
		}
		bt.backtrack(a, -1, n);

	}

}
