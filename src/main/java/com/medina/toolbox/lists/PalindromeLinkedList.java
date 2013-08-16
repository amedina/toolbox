package com.medina.toolbox.lists;

/* 
 * PROBLEM: Given a list, determine if it is palindromic
 */

public class PalindromeLinkedList {

	public static boolean isPalindrome(ListNode head) throws IllegalArgumentException {
		
		if (head == null) {
			throw new IllegalArgumentException();
		}
		
		if (head.next == null) {
			return true;
		}
		/* Get middle point of the list */
		ListNode ptr1 = head;
		ListNode ptr2 = head;
		while (ptr2 != null && ptr2.next != null) {
			ptr1 = ptr1.next;
			ptr2 = ptr2.next.next;			
		}
		
		/* Reverse second half */
		ListNode r = ReverseLinkedList.reverseList(ptr1);
		ptr1 = head;
		while (ptr1 != r) {
			if (ptr1.data != r.data) {
				return false;
			}
			ptr1 = ptr1.next;
			r = r.next;
		}
		
		return true;
		
	}
	
	public static boolean isPalindromeSkiena(ListNode head) {
		
		ListNode l = head;
		ListNode r = ListADT.listGetLast(head);
		
		while (l != r) {			
			if (l.data != r.data) {
				return false;
			}
			l = l.next;
			r = ListADT.listPredecessorIterative(head, r);
		}
		
		return true;
	}
	public static void main(String[] args) {
		
		int[] a = {1,2,3,4,5,6,7,8,9,8,7,6,5,4,3,2,1};
		ListNode head = ListADT.buildList(a);
		ListADT.printList(head);
		
		boolean isP = PalindromeLinkedList.isPalindrome(head);
		System.out.println("P#1: " + isP);
		
		head = ListADT.buildList(a);
		isP = PalindromeLinkedList.isPalindromeSkiena(head);
		System.out.println("P#2: " + isP);

	}

}
