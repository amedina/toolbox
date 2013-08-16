package com.medina.toolbox.lists;

public class GetMiddleNode {

	public ListNode buildListOne() {
		
		ListNode head = null;
		head = listInsert(head, 1);
		head = listInsert(head, 4);
		head = listInsert(head, 5);
		head = listInsert(head, 12);
		head = listInsert(head, 10);
		head = listInsert(head, 12);
		head = listInsert(head, 15);

		return head;
	}

	public ListNode listInsert(ListNode head, int data) throws IllegalArgumentException {
		
		ListNode newNode = new ListNode();
		newNode.data = data;
		newNode.next = head;		
		
		return newNode;
		
	}
	
	/*
	 * Solution #1: Get the length of the list on one traversal, and then get
	 * the middle element in a second traversal; O(n) but still two traversals.
	 * Not so good.
	 * 
	 * Solution #2: Use two pointers. Traverse the list once; increase the first
	 * pointer by two, and increase the second pointer by one.
	 * Fast pointer advances iff the curr.next and curr.next.next are not null
	 * 
	 * Solution #3: Keep a counter for the element number of the element being
	 * visited, and a pointer to keep track of the middle element; advance the
	 * middle element pointer only when the count is odd (if starts at 0), or
	 * when the count is even (starts at 1);
	 */

	public ListNode getMiddleElement(ListNode head) {
		
		ListNode slowPointer = head;
		ListNode fastPointer = head;
		
		if (head == null) {return null;}
		
		while (fastPointer.next != null && fastPointer.next.next != null) {
			fastPointer = fastPointer.next.next;
			slowPointer = slowPointer.next;
		}
		
		return slowPointer;
	}
	
	public static void main(String[] args) {
	
		GetMiddleNode gm = new GetMiddleNode();
		ListNode head = gm.buildListOne();
		ListNode middle = gm.getMiddleElement(head);
		System.out.printf("M: %d", (middle != null)?middle.data:-1);
	}

}
