package com.medina.toolbox.lists;

public class MoveLastToFront {

	public static ListNode moveLastToFront(ListNode head) {
		
		if (head == null || head.next == null) {
			return head;
		}
		
		/* 
		 * Use TWO pointers: one to point to LAST element,
		 * and one to point to BEFORE LAST element
		 */
		ListNode ptr1 = null;
		ListNode ptr2 = head;
		
		/* Find last element: LOOP BOUNDARY is ptr1.next */		
		while (ptr2.next != null) {
			ptr1 = ptr2;
			ptr2 = ptr2.next;			
		}
		
		/* 
		 * At this point, ptr1 points to the element
		 * BEFORE LAST, and ptr2 points to the LAST element;
		 */
		ptr1.next = ptr2.next;
		ptr2.next = head;
		head = ptr2;
		
		return head;
		
	}
	
	public static ListNode moveLastToFrontSkiena(ListNode head) {
		
		ListNode p = ListADT.listGetLast(head);
		
		if (p == null) {
			return null;
		}
		
		ListNode pred = ListADT.listPredecessorIterative(head, p.data);
		
		pred.next = p.next;
		p.next = head;		
		head = p;
		
		return head;
		
	}
	
	public static void main(String[] args) {
		
		int[] a = {1,2,3,4,5,6,7,6,8,9,10};		
		
		ListNode l1 = ListADT.buildList(a);
		ListADT.printList(l1);
		
		System.out.println("Approach #1");
		l1 = MoveLastToFront.moveLastToFront(l1);
		ListADT.printList(l1);

		System.out.println("Approach #2");
		l1 = ListADT.buildList(a);
		l1 = MoveLastToFront.moveLastToFrontSkiena(l1);
		ListADT.printList(l1);
		l1 = MoveLastToFront.moveLastToFrontSkiena(l1);
		ListADT.printList(l1);
		l1 = MoveLastToFront.moveLastToFrontSkiena(l1);
		ListADT.printList(l1);
	}

}
