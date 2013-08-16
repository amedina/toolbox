package com.medina.toolbox.lists;

public class DoublyLinkedListADT {

	public static DoublyLinkedListNode buildList(int[] a) {
		
		DoublyLinkedListNode head = null;
		for (int i = a.length - 1; i>=0; i--) {
			head = DoublyLinkedListADT.listInsert(head, a[i]);
		}
		
		return head;
	}
	
	public static void printList(DoublyLinkedListNode head) {
		
		if (head == null) {
			System.out.printf("Empty List!");
			return;
		}
		
		DoublyLinkedListNode next = head;
		while (next != null) {
			System.out.print(next.data + " ");
			next = next.next;
		}
		System.out.println("");
	}
	
	public static DoublyLinkedListNode listInsert(DoublyLinkedListNode head, int data) throws IllegalArgumentException {
		
		DoublyLinkedListNode newNode = new DoublyLinkedListNode();
		newNode.data = data;
		newNode.prev = null;
		newNode.next = null;
				
		if (head == null) {
			return newNode;
		}
	
		newNode.next = head;
		head.prev = newNode;
		head = newNode;
		
		return head;
		
	}	
	
	public static void main(String[] args) {
		
		int[] a = {1,2,3,4,5,6,7,8,9,10};
		DoublyLinkedListNode headA = DoublyLinkedListADT.buildList(a);
		DoublyLinkedListADT.printList(headA);
				
		int[] b = {5,4,6,1,3,2,9,5,7,10};
		DoublyLinkedListNode headB = DoublyLinkedListADT.buildList(b);
		DoublyLinkedListADT.printList(headB);

	}

}
