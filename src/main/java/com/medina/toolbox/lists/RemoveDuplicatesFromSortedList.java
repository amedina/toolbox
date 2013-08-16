package com.medina.toolbox.lists;

public class RemoveDuplicatesFromSortedList {

	public static ListNode removeDuplicates(ListNode head) {
		
		if (head == null || head.next == null) {
			return head;
		}
		
		ListNode ptr = head;
		while (ptr.next != null) {
			
			if (ptr.data == ptr.next.data) {
				ptr.next = ptr.next.next;
			}else {
				ptr = ptr.next;
			}
			
		}
		
		return head;
	}
	public static void main(String[] args) {
		
		int[] b = {5,4,6,1,3,5,2,10,9,5,7,9,10,10};
		ListNode sortedList= ListADT.buildSortedList(b);
		ListADT.printList(sortedList);

		ListNode l = RemoveDuplicatesFromSortedList.removeDuplicates(sortedList);
		ListADT.printList(l);
	}

}
