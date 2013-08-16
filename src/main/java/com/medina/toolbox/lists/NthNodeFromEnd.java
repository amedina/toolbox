package com.medina.toolbox.lists;

import java.io.ObjectInputStream.GetField;

public class NthNodeFromEnd {
	
	/*
	 * SOLUTION #1: Brute force; traverse the list once to find the number of
	 * elements it contains (S); then traverse the list a second time to find
	 * nth element from the end, which would be the S - n element in the second
	 * traversal. This solution is O(n) but still involved two traversals.
	 * 
	 * SOLUTION #2:
	 *  
	 * (1) Keep TWO POINTERS and ONE COUNTER
	 * (2) Moving the first pointer until the number of traversed elements 
	 * equals N; if the end of the list is reached before that happens,  
	 * report NOT FOUND; otherwise, MOVE BOTH POINTERS in LOCKSTEP until
	 * the first pointer reaches the end of the list; at that time the second
	 * pointer will be pointing to the nth-from-last element in the list.
	 * 
	 * The KEY IDEA is ensuring that the separation between the two pointers is
	 * n, and then taking the first pointer to the end of the list, we
	 * obtain in ptr1 the location of the nth element from the end
	 */
	
	public static ListNode getNthFromLast(ListNode head, int n) {
	
		if (head == null) {return null;}
		
		ListNode ptr1 = head;
		ListNode ptr2 = head;
		
		int count = 0;
		
		while (ptr1 != null && count < n) {
			ptr1 = ptr1.next;
			count += 1;
		}
		
		if (count < n) { 
			return null;
		}
		
		while (ptr1 != null) {
			ptr2 = ptr2.next;
			ptr1 = ptr1.next;
		}
		
		return ptr2;

	}
	
	
	public static void main(String[] args) {
	
		int[] a = {1,2,3,4,5,6,7,8,9,10};
		ListNode head = ListADT.buildList(a);
		ListADT.printList(head);
		
		int N = 4;
		ListNode node = NthNodeFromEnd.getNthFromLast(head, N);
		System.out.printf("Get %dth: %d\n", N, ((node != null)?node.data:"null"));
		
		N = 3;
		node = NthNodeFromEnd.getNthFromLast(head, N);
		System.out.printf("Get %dth: %d \n",  N, ((node != null)?node.data:"null"));

		N = 6;
		node = NthNodeFromEnd.getNthFromLast(head, N);
		System.out.printf("Get %dth: %d \n",  N, ((node != null)?node.data:"null"));
		
	}

}
