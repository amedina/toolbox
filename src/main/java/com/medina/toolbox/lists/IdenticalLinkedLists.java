package com.medina.toolbox.lists;

public class IdenticalLinkedLists {


	public static boolean areIdenticalRecursive(ListNode l1, ListNode l2) {
		
		if (l1 == null && l2 == null) {
			return true;
		}
		
		if (l1 == null && l2 != null) {
			return false;
		}
				
		if (l2 == null && l1 != null) {
			return false;		
		}		
		
		if (l1.data != l2.data) {
			return false;
		}
		
		return areIdenticalRecursive(l1.next, l2.next);
		
	}
	
	public static boolean areIdenticalIterative(ListNode l1, ListNode l2) {
		
		ListNode ptr1 = l1;
		ListNode ptr2 = l2;
		
		while (true) {
			
			if (ptr1 == null && ptr2 == null) {
				return true;
			}
			
			if (ptr1 == null && ptr2 != null) {
				return false;
			}
					
			if (ptr2 == null && ptr1 != null) {
				return false;		
			}		
			
			if (ptr1.data != ptr2.data) {
				return false;
			}

			ptr1 = ptr1.next;
			ptr2 = ptr2.next;
			
		}
		
	}
	
	public static void main(String[] args) {

		int[] a = {1,2,3,4,5,6,7,6,8,9,10};
		int[] b = {1,2,3,4,5,6,7,6,8,9,10};
		
		ListNode l1 = ListADT.buildList(a);
		ListADT.printList(l1);
		
		ListNode l2 = ListADT.buildList(b);
		ListADT.printList(l2);
		
		boolean identicalRecursive = IdenticalLinkedLists.areIdenticalRecursive(l1, l2);		
		System.out.println("IR: " + identicalRecursive);
		
		boolean identicalIterative = IdenticalLinkedLists.areIdenticalRecursive(l1, l2);		
		System.out.println("II: " + identicalIterative);
		

	}

}
