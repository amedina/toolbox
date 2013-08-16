package com.medina.toolbox.lists;

public class CircularListADT {
	
	public static ListNode buildCircularList(int[] a) {
		
		ListNode head = null;
		for (int i = 0; i < a.length; i++) {
			head = CircularListADT.sortedCircularListInsert(head, a[i]);
		}
		
		return head;
	}
	

	public static void printCircularList(ListNode head) {
		
		if (head == null) {
			System.out.printf("Empty List!");
			return;
		}
		
		ListNode curr = head;
		while (curr.next != head) {
			System.out.print(curr.data + " ");
			curr = curr.next;
		}
		System.out.println(curr.data);
		
	}
	
	public static ListNode sortedCircularListInsert(ListNode head, int data) throws IllegalArgumentException {
		
		/* Create new node */
		ListNode newNode = new ListNode();
		newNode.data = data;
		
		/* (1) List is empty */
		if (head == null) {
			newNode.next = newNode;
			return newNode;
		}
		
		/* (2) Element goes at beginning */
		if (head.data > newNode.data) {
			
			/* Find last element in list */
			ListNode curr = head;
			while (curr.next != head) {
				curr = curr.next;
			}
			newNode.next = head;
			curr.next = newNode;
			return newNode;
		}
		
		/* (3) Element goes somewhere after first */
		ListNode curr = head;
		while (curr.next.data < newNode.data && curr.next != head) {
			curr = curr.next;
		}
		newNode.next = curr.next;
		curr.next = newNode;
		
		return head;
		
		
	}
	

	public static void main(String[] args) {

		int[] a = {2,5,8,10};
		
		ListNode head = CircularListADT.buildCircularList(a);
		CircularListADT.printCircularList(head);
		
		head = CircularListADT.sortedCircularListInsert(head, 7);
		CircularListADT.printCircularList(head);
		
		head =CircularListADT.sortedCircularListInsert(head, 11);
		CircularListADT.printCircularList(head);
		
		head = CircularListADT.sortedCircularListInsert(head, 1);
		CircularListADT.printCircularList(head);
	}

}
