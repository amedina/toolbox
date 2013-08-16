package com.medina.toolbox.lists;

/*
 * Idea:
 * 
 * Use TWO POINTERS:
 * 
 * PTR1: FAST PTR (advances in increments of TWO)
 * PTR2: SLOW PTR (advances in increments of ONE)
 * 
 * Scan the list checking at each iteration of the loop:
 * 
 * (1) ptr2.next !=  null && 
 * (2) ptr2.next.next != null
 * 
 * When the condition of the loop breaks, the node pointed at 
 * by PTR1 corresponds to the MIDDLE ELEMENT
 */

public class GetMiddleOfList {
	
	public static ListNode getMiddleNode(ListNode head) {
		
		if (head == null) {
			System.out.println("Empty list!");
			return null;
		}
		
		if (head.next == null) {
			return head;
		}
		
		ListNode ptr1 = head;
		ListNode ptr2 = head;
		
		while (ptr2.next != null && ptr2.next.next != null) {
			ptr1 = ptr1.next;
			ptr2 = ptr2.next.next;
			
		}
		
		return ptr1;
		
		
	}
	public static void main(String[] args) {
		
		int[] a = {1,2,3,4,5,6,7,8,9,10};
		ListNode head = ListADT.buildList(a);
		ListADT.printList(head);
		
		ListNode n  = GetMiddleOfList.getMiddleNode(head);
		System.out.println("Middle: " +  ((n != null)?n.data:"null"));
	}

}
