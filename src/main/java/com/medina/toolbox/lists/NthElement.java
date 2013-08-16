package com.medina.toolbox.lists;

import com.medina.toolbox.lists.ListNode;

public class NthElement {

	/*
	 * Solution #1: Traverse the list, counting elements; at them moment we
	 * reach n, return that element; if we reach the end of the list, return null
	 */

	public ListNode getNthElement(ListNode head, int n) {
		
		int count = 0;
		ListNode curr = head;
		while (curr != null) {			
			if (count == n) {
				return curr;
			}
			count += 1;
			curr = curr.next;
		}
		
		return null;
	}
	

	public static void main(String[] args) {

		NthElement ne = new NthElement();
		
		ListNode head;
		int[] a = {1,4,1,12,1};
		head =  ListADT.buildList(a);
		ListADT.printList(head);
		
		int N = 2;
		ListNode n = ne.getNthElement(head, N);
		System.out.printf("N: %d Node Data: %s\n", N, (n != null)?n.toString():"null");
		
		N = 3;
		n = ne.getNthElement(head, N);
		System.out.printf("N: %d Node Data: %s\n", N, (n != null)?n.toString():"null");
		
		N = 5;
		n = ne.getNthElement(head, N);
		System.out.printf("N: %d Node Data: %s\n", N, (n != null)?n.toString():"null");
	
	}

}
