package com.medina.toolbox.lists;

public class ListMergeSort {

	/*
	 * MergeSort of a list
	 */
	public static ListNode mergeSort(ListNode head) {
		
		if (head == null || head.next == null) {
			return head;
		}
		
		/* Split list in two halves:
		 * (1) Get pointer to node at middle of list: m
		 * (2) Split list at that point: m.next = null
		 */
		ListNode m = GetMiddleOfList.getMiddleNode(head);		
		ListNode secondHalf = m.next;
		m.next = null;
		
		/* Recurse algorithm on both halves*/
		ListNode a = mergeSort(head);
		ListNode b = mergeSort(secondHalf);
		
		/* Merge both halves: regular list merge */
		ListNode result = MergeSortedLists.merge(a, b);

		return result;
	}
	
	public static void main(String[] args) {

		int[] a = {2, 5, 3, 7, 20, 5, 1, 10,4, 15, 8,7,10,18,13,16,14,28,79,101,87,67,65,97,92};
		
		ListNode l1 = ListADT.buildList(a);

		ListNode result = ListMergeSort.mergeSort(l1);
		ListADT.printList(result);
		
		

	}

}
