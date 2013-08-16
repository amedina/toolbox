package com.medina.toolbox.stacks;

public class StackWithMaxV2 {

	/* 
	 * KEY IDA:
	 * 
	 * Maintain TWO STACKS:
	 * 
	 * S1: stack for regular keys
	 * S2: stack for pairs <mKey, numTimes>
	 * 
	 * Where mKey is the maximum key in the stack and 
	 * the number of times that key appears has been 
	 * pushed
	 * 
	 * Operations:
	 * 
	 * (1) s1.push(key): 
	 * 
	 *  	m = s2.top().first()
	 * 
	 * 		if (key > m): 
	 * 			s2.push(key, 1)
	 * 		else if (key == m): 
	 * 			s2.top().second() += 1;
	 * 		else: do nothing;
	 * 
	 * (2) key = s1.pop():
	 * 
	 *  if s2.top().first() == key:
	 *  	s2.top().second -= 1;
	 *      if (s2.top(second) == 0):
	 *         s2.pop();
	 */

	public static void main(String[] args) {


	}

}
