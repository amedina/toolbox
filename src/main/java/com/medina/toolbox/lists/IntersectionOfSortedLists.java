package com.medina.toolbox.lists;

import java.util.ArrayList;
import java.util.List;

public class IntersectionOfSortedLists {

	
	/* 
	 * SOLUTION #1: Using Java List<T>
	 */
	public List<Integer> computeIntersection(List<Integer> l1, List<Integer> l2) {
		
		List<Integer> res = new ArrayList<Integer>();
		
		int i = 0, j = 0;
		while (i < l1.size() && j < l2.size()) {
			
			int a = l1.get(i);
			int b = l2.get(j);
			
			if (a == b) {
				res.add(a);
				i++;
				j++;
			}else {
				if (a < b) {
					i++;
				}else {
					j++;
				}
			}
			
		}
		
		
		return res;
		
	}
	
	
	/* 
	 * SOLUTION #2: Using my own List's ADT
	 */
	public ListNode computeIntersection(ListNode l1, ListNode l2) {
		
		ListNode res = null;
		
		while (l1 != null && l2 != null) {
			
			if (l1.data == l2.data) {
				
				/* INSERT Node into RES list */
				ListNode newNode = new ListNode();
				newNode.data = l1.data;
				newNode.next = res;
				res = newNode;				
				
				l1 = l1.next;
				l2 = l2.next;
				
			}else {
				
				if (l1.data < l2.data) {
					l1 = l1.next;
				}else {
					l2 = l2.next;
				}
			}
			
		}
		
		return res;
	}

	
	public void computeIntersectionOfSortedListsDriver() {
		
		List<Integer> l1 = new ArrayList<Integer>(); 
		l1.add(1);
		l1.add(2);
		l1.add(3);
		l1.add(4);
		l1.add(6);
		
		List<Integer> l2 = new ArrayList<Integer>(); 
		l2.add(2);
		l2.add(4);
		l2.add(6);
		l2.add(8);
		
		List<Integer> res = computeIntersection(l1, l2);
		
		for (int i = 0; i < res.size(); i++) {
			System.out.printf("%d\n", res.get(i));
		}
		
		int[] a =  {6,4,3,2,1};
		int[] b = {8,6,4,2};
		ListNode L1 = ListADT.buildList(a);
		ListNode L2 = ListADT.buildList(b);
		ListNode res2 = computeIntersection(L1, L2);
		
		while (res2 != null) {
			System.out.printf("RES 2: %d\n", res2.data);
			res2 = res2.next;
		}
		
	}
	
	public static void main(String[] args) {
		
		IntersectionOfSortedLists is = new IntersectionOfSortedLists();
		is.computeIntersectionOfSortedListsDriver();

	}

}
