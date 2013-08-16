package com.medina.toolbox.lists;

public class ListADT<T> {

	
	public static ListNode listInsert(ListNode head, int data) throws IllegalArgumentException {
		
		ListNode newNode = new ListNode();
		newNode.data = data;
		newNode.next = head;		
		
		return newNode;
		
	}	

	public static ListNode listSearch(ListNode head, int data) {
		
		if (head == null) {
			return null;
		}
		
		ListNode ptr = head;
		while (ptr != null) {

			if (ptr.data == data) {
				return ptr;
			}
			
			ptr = ptr.next;
		}
		
		return null;
		
	}
	
	public static ListNode listPredecessorIterative(ListNode head, Integer data) {
		
		if (head == null) {
			return null;
		}
		
		if (head.data == data) {
			return null;
		}
		
		ListNode ptr = head;
		while (ptr.next != null) {
			if (ptr.next.data == data) {
				return ptr;
			}
			ptr = ptr.next;
		}
		
		return null;
		
	}

	public static ListNode listPredecessorIterative(ListNode head, ListNode node) {
		
		if (head == null) {
			return null;
		}
		
		if (head.next == node) {
			return null;
		}
		
		ListNode ptr = head;
		while (ptr.next != null) {
			if (ptr.next == node) {
				return ptr;
			}
			ptr = ptr.next;
		}
		
		return null;
		
	}
	
	public static ListNode listPredecessorRecursive(ListNode head, int data) {
		
		if (head == null || head.next != null) {
			return null;
		}
		
		if (head.data == data) {
			return null;
		}
		
		if (head.next.data == data) {
			return head;
		}
				
		return listPredecessorRecursive(head.next, data);
		
	}
	
	public static ListNode listPredecessorRecursive(ListNode head, ListNode node) {
		
		if (head == null || head.next != null) {
			return null;
		}
		
		if (head == node) {
			return null;
		}
		
		if (head.next == node) {
			return head;
		}
				
		return listPredecessorRecursive(head.next, node);
		
	}
	
	public static ListNode listDeleteIterative(ListNode head, int data) {
		
		/* Case #1: Empty List */
		if (head == null) {
			return null;
		}
		
		/* Case #2: Element at beginning of list */
		if (head.data == data) {
			return head.next;
		}
		
		/* Case #3: Element somewhere in the list */
		ListNode ptr1 = head;
		ListNode ptr2 = ptr1.next;
		
		while (ptr2 != null) {
			
			if (ptr2.data == data) {
				ptr1.next = ptr2.next;
				return head;			
			}else {
				ptr1 = ptr2;
				ptr2 = ptr1.next;
			}
		}
		
		return head;
	}
	
	public static ListNode listDeleteSkiena(ListNode head, int data) {
		
		ListNode p = listSearch(head, data);
		
		if (p == null) {
			return head;
		}
		
		ListNode pred = listPredecessorIterative(head, data);		
		if (pred == null) {
			return head.next;
		}
		
		pred.next = p.next;
		
		return head;
		
		
	}
	
	public static ListNode sortedListInsert(ListNode head, int data) {
		
		/* Create ListNode for new Element */
		ListNode newNode = new ListNode();
		newNode.data = data;
		newNode.next = null;
		
		/* Case #1: Empty List */
		if (head == null) {
			return newNode;
		}
		
		/* Case #2: At the beginning of the list */
		if (head.data >= data) {
			newNode.next = head;
			return newNode;
		}
		
		/* Case #3: Middle of list */
		ListNode curr = head;
		while (curr.next != null && curr.next.data < data) {
			curr = curr.next;
		}
		
		newNode.next = curr.next;
		curr.next = newNode;
		
		
		return head;
		
	}
	
	public static ListNode listGetLast(ListNode head) {
		
		if (head == null) {
			return null;
		}
		
		ListNode ptr = head;
		while (ptr.next != null) {
			ptr = ptr.next;
		}
		
		return ptr;
	}
	
	public static ListNode buildList(int[] a) {
		
		ListNode head = null;
		for (int i = a.length - 1; i >= 0 ; i--) {
			head = listInsert(head, a[i]);
		}
		
		return head;
	}
	
	public static ListNode buildSortedList(int[] a) {
		
		ListNode head = null;
		for (int i = 0; i < a.length; i++) {
			head = sortedListInsert(head, a[i]);
		}
		
		return head;
	}
	
	public static void printList(ListNode head) {
		
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
	
	
	public static void main(String[] args) {
		
		int[] a = {1,2,3,4,5,6,7,8,9,10};
		ListNode head = ListADT.buildList(a);
		ListADT.printList(head);
		
		ListNode n = NthNodeFromEnd.getNthFromLast(head, 2);
		System.out.println(n.toString());
		
		/* Deletions */
		System.out.println("Deleting some elements (Iterative #1)...,");
		int[] b = {5,4,6,1,3,2,9,5,7,10};
		ListNode sortedList = ListADT.buildSortedList(b);
		ListADT.printList(sortedList);
		
		ListADT.listDeleteIterative(sortedList, 9);
		ListADT.printList(sortedList);
		ListADT.listDeleteIterative(sortedList, 5);
		ListADT.printList(sortedList);
		ListADT.listDeleteIterative(sortedList, 3);
		ListADT.printList(sortedList);
		
		
		System.out.println("Deleting some elements (Skiena)...,");
		sortedList = ListADT.buildSortedList(b);
		ListADT.printList(sortedList);
		
		ListADT.listDeleteSkiena(sortedList, 9);
		ListADT.printList(sortedList);
		ListADT.listDeleteSkiena(sortedList, 5);
		ListADT.printList(sortedList);
		ListADT.listDeleteSkiena(sortedList, 3);
		ListADT.printList(sortedList);
				

	}

}
