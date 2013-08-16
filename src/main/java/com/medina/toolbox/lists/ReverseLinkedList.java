package com.medina.toolbox.lists;

public class ReverseLinkedList {
	
	/*
	 * KEY OBSERVATION: Maintain THREE POINTERS
	 */
	
	public static ListNode reverseList(ListNode head) {
		
		if (head == null || head.next == null) {
			return head;
		}
		
		
		/*
		 * Keep THREE POINTERS 
		 */
		ListNode curr = head;
		ListNode prev = null;		
		ListNode temp = null;
		
		while (curr != null) {
			
			
			temp = curr.next;
			curr.next = prev;
			
			prev = curr;
			curr = temp;
			
		}
		
		return prev;
		
	}
	
	public static ListNode reverseListTwo(ListNode head) {
		
		
		if (head == null || head.next == null) {
			return head;
		}
		
		ListNode curr = head;
		ListNode temp = null;
		ListNode prev = null;
		
		while (curr != null) {
			
			temp = curr.next;
			curr.next = prev;
			
			prev = curr;
			curr = temp;
			
		}
		
		return prev;
	}
	
	public static void main(String[] args) {
		
		int[] a = {1,2,3,4,5,6,7,8,9,10};
		
		ListNode head = ListADT.buildList(a);
		ListADT.printList(head);
		
		head = ReverseLinkedList.reverseListTwo(head);
		ListADT.printList(head);

	}
}
