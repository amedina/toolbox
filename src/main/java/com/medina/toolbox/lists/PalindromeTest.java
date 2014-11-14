package com.medina.toolbox.lists;

public class PalindromeTest {

	class ListNode {
		public int data;
		public ListNode next;
	}

	public ListNode listInsert(ListNode head, int data) throws IllegalArgumentException {

		ListNode newNode = new ListNode();
		newNode.data = data;
		newNode.next = head;

		return newNode;

	}

	public ListNode buildList(int[] a) {

		ListNode head = null;
		for (int i = a.length - 1; i >= 0 ; i--) {
			head = listInsert(head, a[i]);
		}

		return head;
	}

	public void printList(ListNode head) {

		if (head == null) {
			System.out.printf("Empty List!");
			return;
		}

		ListNode next = head;
		while (next != null) {
			System.out.print(next.data + " ");
			next = next.next;
		}
		System.out.println("");
	}

	public ListNode reverseList(ListNode head) {

		if (head == null || head.next == null) {
			return head;
		}

		/*
		 * Keep THREE POINTERS
		 */
		ListNode curr = head;
		ListNode prev = null;
		ListNode temp = null;

		while (curr != null) {

			temp = curr.next;
			curr.next = prev;

			prev = curr;
			curr = temp;

		}

		return prev;

	}

	public boolean isPalindrome(ListNode head)
			throws IllegalArgumentException {

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
		ListNode r = reverseList(ptr1);

		/* Now compare first part to reverse second part */
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

	public static void main(String[] args) {

		PalindromeTest pt = new PalindromeTest();

		int[] a = {1,2,3,4,5,6,7,8,9,8,7,6,5,4,3,2,1};
		int[] b = {1,2,3,4,4,6,7,8,9,8,7,6,5,4,3,2,1};
		ListNode head = pt.buildList(a);
		pt.printList(head);

		boolean isP = pt.isPalindrome(head);
		System.out.println("P#1: " + isP);

		head = pt.buildList(b);
		pt.printList(head);

		isP = pt.isPalindrome(head);
		System.out.println("P#1: " + isP);

	}

}
