package com.medina.toolbox.lists;

public class MergeSortedLists {

	public static ListNode merge(ListNode l1, ListNode l2) {
		
		/* If any of the two lists is empty, return the other one */
		if (l1 == null) {
			return l2;
		}
		
		if (l2 == null) {
			return l1;
		}
		
		/* 
		 * Keep two pointers: 
		 * (1) results (HEAD) of merged list,
		 * (2) tail (TAIL) of merged list
		 */
		ListNode result =  null;
		ListNode tail = null;
		
		/* 
		 * Initialize RESULTS and TAIL to point to the smaller of 
		 * both lists first elements 
		 */
		if (l1.data <= l2.data) {
			result = tail = l1;
			l1 = l1.next;
		}else {
			result = tail = l2;
			l2 = l2.next;
		}
		
		
		while (l1 != null && l2 != null) {
			
			if (l1.data <= l2.data) {
				tail.next = l1;
				tail = l1;
				l1 = l1.next;
			}else {
				tail.next = l2;
				tail = l2;
				l2 = l2.next;
			}
		}
		
		/* At this point, at least one of the two lists must have been 
		 * completely traversed; if any elements remain in the other one, 
		 * add them to the resulting list
		 */
		while (l1 != null) {
			tail.next = l1;
			tail = l1;
			l1 = l1.next;			
		}

		while (l2 != null) {
			tail.next = l2;
			tail = l2;
			l2 = l2.next;			
		}

		return result;
		
	}
	
	public static void main(String[] args) {
		
		int[] a = {2, 3, 20};
		int[] b = {5,10,15};
		
		ListNode l1 = ReverseLinkedList.reverseList(ListADT.buildList(a));
		ListNode l2 = ReverseLinkedList.reverseList(ListADT.buildList(b));
		
		ListNode result = MergeSortedLists.merge(l1, l2);
		ListADT.printList(result);

	}

}
