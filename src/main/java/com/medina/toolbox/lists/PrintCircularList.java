package com.medina.toolbox.lists;

public class PrintCircularList {

	public void printCircularList(ListNode head) {
		ListNode next = head;
		while (next != null && next.next != head) {
			System.out.println(next.data);
			next = next.next;
		}
	}
	
	public static void main(String[] args) {

	}

}
