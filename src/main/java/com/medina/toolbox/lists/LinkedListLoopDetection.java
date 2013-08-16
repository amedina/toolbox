package com.medina.toolbox.lists;

public class LinkedListLoopDetection {


	/* 
	 * APPROACH: Floyd's Cycle Detection algorithm
	 * 
	 *  KEY IDEA: 
	 *  
	 *  (1) Use TWO POINTERS: SLOW Ptr1, FAST Ptr2
	 *  (2) Move both pointers at each iteration
	 *  (3) If Ptr2 reaches NULL first, NO LOOP
	 *  (4) If Ptr2 or Ptr2.next equals Ptr1, LOOP DETECTED
	 *  
	 */
	public static boolean detectLoop(ListNode head) {
		
		if (head == null) {
			return false;			
		}
		
		ListNode ptr1 = head;
		ListNode ptr2 = head;
		
		while (ptr2.next != null && ptr2.next.next != null) {
			
			ptr1 = ptr1.next;
			ptr2 = ptr2.next.next;
			
			if (ptr2 == ptr1 || ptr2.next == ptr1) {
				 return true;
			}
			
		}
		
		return false;
		
	}
	
	
	public static void main(String[] args) {
		
		int[] a = {2,5,8,10};
		
		ListNode l1 = CircularListADT.buildCircularList(a);
		CircularListADT.printCircularList(l1);
		
		int[] b = {1,2,3,4,5,6,7,8,9,10};
		ListNode l2 = ListADT.buildList(b);
		ListADT.printList(l2);
		
		/* Get tail of l2 */
		ListNode ptr = l2;
		while (ptr.next != null) {
			ptr = ptr.next;
		}		
		ptr.next = l1;
		
		boolean hasLoop = LinkedListLoopDetection.detectLoop(l2);
		System.out.println("Has Loop?: " + hasLoop);
		
		hasLoop = LinkedListLoopDetection.detectLoop(l1);
		System.out.println("Has Loop?: " + hasLoop);		


	}

}
