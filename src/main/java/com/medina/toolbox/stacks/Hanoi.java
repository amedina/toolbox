package com.medina.toolbox.stacks;
/*
Please write complete compilable code.
Your class should be named Solution
Read input from standard input (STDIN) and print output to standard output(STDOUT).
For more details, please check https://www.interviewstreet.com/recruit/challenges/faq/view#stdio
*/

import java.util.List;
import java.util.ArrayList;
import java.util.Stack;

public class Hanoi {
    
    private int N;
    private int K;  
    private List<Stack<Integer>> pegs;
    
    public Hanoi() {
        this.pegs = new ArrayList<Stack<Integer>>();        
    }
 
    public void hanoiMoves(int n, int from, int to, int use) {
        
        if (n > 0) {
            
        	/* Move pegs FROM --> USE --> via TO */ 
        	hanoiMoves(n - 1, from, use, to);
          
        	/* Move remaining FORM --> TO */
        	int a = pegs.get(from).pop();
        	pegs.get(to).push(a);	    
        	System.out.println("MOVE: " + a  + " FROM: " + from + " TO: " +  to);
          
        	/* Move rest of the pegs from USE --> TO via FROM */
        	hanoiMoves(n - 1, use, to, from);
          
        }
        
    }
    

    public void init() throws Exception {

    	this.N = Integer.valueOf(10);
	    this.K = Integer.valueOf(3);

	    for (int i = 0; i < K; i++) {
	    	pegs.add(new Stack<Integer>());
	    }
	    
	    for (int i = N; i >= 1; i--) {
	    	pegs.get(0).push(i);
	    }
        
    }
    
    
    
    public void printPegs() {
    	
    	for (int i = 0; i < pegs.size(); i++) {
    		System.out.println(pegs.get(i));
    	}
    }
    
    public static void main(String[] args) throws Exception {
        Hanoi sol = new Hanoi();
        sol.init();
        sol.printPegs();
        int from = 0;
        int to = 2;
        int use = 1;
        sol.hanoiMoves(10, from, to, use);
        sol.printPegs();
    }
}
    