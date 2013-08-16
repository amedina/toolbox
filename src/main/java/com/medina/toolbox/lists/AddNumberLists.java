package com.medina.toolbox.lists;

/*
 * Given two numbers represented by two lists, write a function that returns sum list. 
 * The sum list is list representation of addition of two input numbers.
 * 
 * Assumptions:
 * 
 * (1) The input lists are of the form: 5->6->3 for number = 365
 */

public class AddNumberLists {

	public static ListNode add(ListNode l1, ListNode l2) throws IllegalArgumentException {
		
		if (l1 == null || l2 == null) {
			throw new IllegalArgumentException("Null lists!");
		}
		
		ListNode result = null;
		int carryOn = 0;		
		while (l1 != null && l2 != null) {
			
			int sum = l1.data + l2.data + carryOn;
			carryOn = sum / 10;			
			result = ListADT.listInsert(result, sum % 10);
			l1 = l1.next;
			l2 = l2.next;
		}
		
		/*
		 *  At this point, at least one of the two lists must be empty,
		 *  and carryOn may or may not be zero 
		 */ 
		while (l1 != null || carryOn == 1) {
			
			int sum = carryOn + ((l1 != null)?l1.data:0);
			carryOn = sum / 10;
			result = ListADT.listInsert(result, sum % 10);
			if (l1 != null) {
				l1 = l1.next;
			}
		}

		while (l2 != null || carryOn == 1) {
			
			int sum = carryOn + ((l2 != null)?l2.data:0);			
			carryOn = sum / 10;			
			result = ListADT.listInsert(result, sum % 10);
			if (l2 != null) {
				l2 = l2.next;
			}
		}
		
		return ReverseLinkedList.reverseList(result);
	}

	public static void main(String[] args) {
		
		int[] a = {3,6,5,8,3,5,4,3,2,3,4,5};
		int[] b = {6,0,9,2,4,3,6,7};
		
		ListNode l1 = ListADT.buildList(a);
		ListNode l2 = ListADT.buildList(b);
		
		ListNode sum = AddNumberLists.add(l1, l2);
		ListADT.printList(ReverseLinkedList.reverseList(l1));
		ListADT.printList(ReverseLinkedList.reverseList(l2));
		ListADT.printList(ReverseLinkedList.reverseList(sum));

	}

}
