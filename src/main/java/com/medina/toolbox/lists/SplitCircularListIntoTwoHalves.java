package com.medina.toolbox.lists;

public class SplitCircularListIntoTwoHalves {

	public static ListNode[] splitCircularListInTwo(ListNode head) throws IllegalArgumentException {
		
		if (head == null) {
			throw new IllegalArgumentException();
		}
		
		ListNode[] halves = new ListNode[2];
		halves[0] = null;
		halves[1] = null;
		
		/* Case #1: One element list */
		if (head.next == null) {
			halves[0] = head;
			return halves;			
		}

		/* Case #2: Find middle node (Tortoise and Hare algorithm)*/
		ListNode ptr1 = head;
		ListNode ptr2 = head;
		while (ptr2.next != head && ptr2.next.next != head) {
			ptr1 = ptr1.next;
			ptr2 = ptr2.next.next;
		}
		
		/* Make second half */
		ListNode newHead = ptr1.next;
		ptr2 = newHead;
		while (ptr2.next != head) {
			ptr2 = ptr2.next;
		}
		ptr2.next = newHead;
		halves[1] = newHead;
		
		/* Make first half */
		ptr1.next = head;
		halves[0] = head;		
		
		return halves;
	}
	
	public static void main(String[] args) {
		
		int[] a = {1,2,3,4,5,6,7,8,9,10};
		
		ListNode head = CircularListADT.buildCircularList(a);
		CircularListADT.printCircularList(head);
		
		ListNode[] halves = SplitCircularListIntoTwoHalves.splitCircularListInTwo(head);
		CircularListADT.printCircularList(halves[0]);
		CircularListADT.printCircularList(halves[1]);
		
	}

}
