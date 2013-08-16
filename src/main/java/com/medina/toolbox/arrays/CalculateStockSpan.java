package com.medina.toolbox.arrays;

import java.util.Stack;

/*
 * Given have an array P with historical data of the prices of a given stock. 
 * Design an algorithm that determines the maximum profit that could have 
 * been made by buying and selling a single share over a given day range
 */

public class CalculateStockSpan {

	private Stack<Integer> s = new Stack<Integer>();
	private int[] p;
	int[] S;
	
	public CalculateStockSpan(int[] p) {
		this.p = p;
		this.S = new int[p.length];
	}
	
	public void printArray(int[] a) {
		for (int i = 0; i < a.length; i++) {
			System.out.print(a[i] + " ");
		}
		System.out.println("");
	}

	/*
	 * IDEA: 
	 * 
	 * STACK s holds INDEX VALUES from array p
	 * 
	 * Invariant: S's top contains the index of the preceding index i' for
	 * which p[i'] > p[i]. Therefore, for a given day i, the difference
	 * between p[i] and p[s.top()] denotes the stock span for that day
	 * 
	 * For a given day i, if s.empty(), then p[i] > p[j], for all j < i, and
	 * therefore the stock span for that day is given by i + 1
	 */
	public int[] getStockSpan() {

		s.push(0);

		S[0] = 1;

		for (int i = 1; i < p.length; i++) {

			while (!s.empty() && (p[s.peek()] < p[i])) {
				s.pop();
			}

			/*
			 * If s.empty(), then price at day i is higher than price at all
			 * previous days
			 */
			if (s.empty()) {
				S[i] = i + 1;
			} else {
				S[i] = i - s.peek();
			}

			s.push(i);
		}

		return S;

	}
	
	public int getMaxProfit() {
		
		int min = Integer.MAX_VALUE;
		int maxProfit = 0;
		
		for (int i = 0; i < p.length; i++) {
			
			if (p[i] < min) {
				min = p[i];
			}
			
			if (p[i] - min > maxProfit) {
				maxProfit = p[i] - min;
			}
			
		}
		
		return maxProfit;
	}
	
	public static void main(String[] args) {

		int[] p = { 100, 80, 60, 70, 60, 75, 85 };
		CalculateStockSpan c = new CalculateStockSpan(p);
		
		int[] S = c.getStockSpan();
		c.printArray(S);
		
		int maxProfit = c.getMaxProfit();
		System.out.printf("maxProfit: %d\n", maxProfit);
	}

}
