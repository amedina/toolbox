package com.medina.toolbox.lists;

public class ReverseListWithRecursion {


	public static void printReverseList(ListNode head, int i) {
		
		if (head == null) {
			return;
		}
		
		printReverseList(head.next, i + 1);
		System.out.printf("%d ", head.data);
		if (i == 1) {
			System.out.println("");
		}
		
	}
	
	public static void reverseListWithRecursion(ListNode head, ListNode last, ListNode[] result) throws IllegalArgumentException {
		
		if (head == null) {
			throw new IllegalArgumentException();
		}
		
		if (head.next == null) {
			result[0] = head;
			result[0].next = last;
			return;
		}
		
		reverseListWithRecursion(head.next, head, result);
		head.next = last;
		
		return;
	}
	
	public static void main(String[] args) {

		int[] a = {1,2,3,4,5,6,7,8,9,10};
		
		ListNode head = ListADT.buildList(a);
		ListADT.printList(head);
		
		ReverseListWithRecursion.printReverseList(head,1);
		
		ListNode[] result = new ListNode[1];
		reverseListWithRecursion(head, null, result);
		ListADT.printList(result[0]);
	}

}
