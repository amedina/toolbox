package com.medina.toolbox.lists;

public class SortedCircularListInsert {

	public ListNode buildListTwo() {
		
		ListNode head = null;
		head = circularListSortedInsert(head, 12);
		head = circularListSortedInsert(head, 4);
		head = circularListSortedInsert(head, 1);
		head = circularListSortedInsert(head, 12);
		head = circularListSortedInsert(head, 1);

		return head;
	}
	
	/*
	 * Case 1: List is empty -> Create self loop
	 * Case 2: New node goes at the beginning of list
	 */
	public ListNode circularListSortedInsert(ListNode head, int data) throws IllegalArgumentException {

		ListNode newNode = new ListNode();
		newNode.data = data;

		ListNode curr = head;
		
		/* Case 1: empty list */
		if (curr == null) {
			newNode.next = newNode;
			return newNode;
		}

		/* Case 2: Insert at front; FIND END of list and insert */
		if (curr.data >= newNode.data){ 
			
			while (curr.next != head) {
				curr = curr.next;
			}
			curr.next = newNode;
			newNode.next = head;
			return newNode;
		}
		
		/* Case 3: find position, and insert */		
		while (curr.next != head && curr.next.data < newNode.data) {
			curr = curr.next;
		}
		
		newNode.next = curr.next;
		curr.next = newNode;
		return head;
		
	}
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
