package com.medina.toolbox.lists;

import java.util.HashMap;
import java.util.Map;

public class RemoveDuplicatesFromUnsortedList {

	
	/*
	 * Solution #1: SORT the list first, then apply duplicate
	 * removal algorithm for sorted lists
	 * 
	 * Complexity: T: (NlogN)  S: O(1)
	 */
	public static ListNode removeDuplicatesSolutionOne(ListNode head) {
		
		if (head == null || head.next == null) {
			return head;
		}
		
		ListNode sortedList = ListMergeSort.mergeSort(head);
		ListNode noDupsList = RemoveDuplicatesFromSortedList.removeDuplicates(sortedList);
		
		return noDupsList;
	}
	
	/* 
	 * Solution #2
	 * 
	 * (1) Make ONE PASS over the list
	 * (2) Count the number of appearances of each element
	 * (3) Make SECOND PASS over list, remove elements whose counter
	 * is greater than one; update counter
	 * 
	 * Complexity: Time: O(n); Space: O(n)
	 */
	public static ListNode removeDuplicatesSolutionTwo(ListNode head) {
		
		if (head == null || head.next == null) {
			return head;
		}
		
		/* PHASE #1: Count number of appearances for each element */
		Map<Integer, Integer> counts = new HashMap<Integer, Integer>();
		ListNode ptr = head;
		while (ptr != null) {
			
			if (counts.containsKey(ptr.data)) {
				Integer c = counts.get(ptr.data);
				counts.put(ptr.data, c + 1);
			}else {
				counts.put(ptr.data, 1);
			}
					
			ptr = ptr.next;
		
		}
				
		
		/* PHASE #2: Remove duplicate elements */
		ListNode ptr2 = null;
		ListNode ptr1 = head.next;
		
		while (ptr1 != null) {			
			
			Integer c = counts.get(ptr1.data);
			
			if (c > 1) {
				
				System.out.println("Duplicate: " + ptr1.data);
				counts.put(ptr1.data, c - 1);
				
				if (ptr2 == null) {
					head = head.next;
					ptr2 = head;
				}else {
					ptr2.next = ptr1.next;					
				}

				ptr1 = ptr2.next;		
						
			}else {
				ptr2 = ptr1;
				ptr1 = ptr1.next;
			}
				
		}		
		
		return head;
	}
	
	public static void main(String[] args) {
		
		int[] a = {5,4,6,1,3,5,2,10,9,5,7,9,10};
		ListNode list= ListADT.buildList(a);
		ListADT.printList(list);

		ListNode noDupsList = RemoveDuplicatesFromUnsortedList.removeDuplicatesSolutionTwo(list);
		ListADT.printList(noDupsList);
		
		int[] b = {1,1,1,1,1,1,1};
		list= ListADT.buildList(b);
		ListADT.printList(list);
		noDupsList = RemoveDuplicatesFromUnsortedList.removeDuplicatesSolutionTwo(list);
		ListADT.printList(noDupsList);
		
	}

}
