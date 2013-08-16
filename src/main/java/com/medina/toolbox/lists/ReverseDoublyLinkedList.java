package com.medina.toolbox.lists;

public class ReverseDoublyLinkedList {

	/*
	 * KEY OBSERVATION: Maintain TWO POINTERS
	 */
	
	public static DoublyLinkedListNode reverse(DoublyLinkedListNode head) {
		
		if (head == null) {
			return null;			
		}
		
		DoublyLinkedListNode temp = null;
		
		while (head != null) {		
			
			temp = head;
			head = temp.next;
			
			temp.next = temp.prev;
			temp.prev = head;
			
		}
		
		return temp;
			
	}
	
	public static void main(String[] args) {

		int[] a = {1,2,3,4,5,6,7,8,9,10};
		DoublyLinkedListNode headA = DoublyLinkedListADT.buildList(a);
		DoublyLinkedListADT.printList(headA);
		
		DoublyLinkedListNode r = ReverseDoublyLinkedList.reverse(headA);
		DoublyLinkedListADT.printList(r);
	}

}
