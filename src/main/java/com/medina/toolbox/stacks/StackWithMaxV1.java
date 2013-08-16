package com.medina.toolbox.stacks;

public class StackWithMaxV1 {

	/* 
	 * KEY IDA:
	 * 
	 * Store pairs in the stack: <key, max> 
	 * 
	 * key: regular keys being stored
	 * max: max value for this and all elements that were
	 * pushed before this into the stack
	 * 
	 * Operations:
	 * 
	 * push(key): 
	 * 
	 * 	m = s.top().second();
	 * 	
	 * if key > m: 
	 * 		push(key, key)
	 * else: 
	 * 		push (key, m) 
	 */

	public static void main(String[] args) {


	}

}
