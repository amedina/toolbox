package com.medina.toolbox.stacks;

import java.util.Stack;

/*
 * KEY IDEAS
 * 
 * (1) A String in RPN must be parsed from LEFT to RIGHT
 * (2) TOKENIZE the string into NUMBERS and OPERATORS
 * (3) NUMBERS are PUSHED onto the stack
 * (4) When an OPERATOR is read, k arguments are popped from 
 * the stack
 * (4) The RESULT of an operation is PUSHED onto the stack
 * (5) When NO TOKENS are left, only one value must be SITTING on
 * the stack, corresponding to the OVERALL RESULT of the RPN expression
 */


public class ReversePolishNotation {


	private Stack<Integer> s;
	
	
	public ReversePolishNotation() {
		s = new Stack<Integer>();
	}
	
	public int eval(String rpnExp) throws IllegalArgumentException {
		
		/* TOKENIZE string */
		String[] elements = rpnExp.split(",");

		/* Scan all elements in TOKENIZED string */
		for (int i = 0; i < elements.length; i++) {
			
			String symbol = elements[i];
			
			if (symbol.equals("+") || symbol.equals("-") || symbol.equals("*") || symbol.equals("/")) {
				
				/* Check right NUMBER of OPERANDS in stack */
				if (s.size() < 2) {
					throw new IllegalArgumentException();
				}
				
				/* Get operands */
				int x = s.pop();
				int y = s.pop();
				
				int res = 0;
				switch(symbol) {
				case "+":
					res = x + y;
					break;
				case "-":
					res = x - y;
					break;
				case "*":
					res = x * y;
					break;
				case "/":
					res = x / y;
					break;
				}
				
				s.push(res);
				
			}else {
				try {
					s.push(Integer.valueOf(symbol));
				}catch(java.lang.NumberFormatException e) {
					throw new IllegalArgumentException("Symbol: " + symbol + " Is not a number!");
				}
			}
		}
		
		return s.pop();
		
	}
	
	public static void main(String[] args) {

		ReversePolishNotation rpn  = new ReversePolishNotation();
		
		String exp = "5,4,+,5,6,6,*,-,+,3,*";
		
		int res = rpn.eval(exp);
		
		System.out.printf("RES: %d\n",  res);

	}

}
