package com.medina.toolbox.arrays;

public class RearrangePositiveAndNegative {

	public void printArray(int[] a) {		
		for (int i = 0; i < a.length; i++) {
			System.out.print(a[i] + " ");
		}
		System.out.println("");
	}
	
	public int partitionArrayStandard(int[] a, int left, int right, int pivotIndex) {
	
		/* Grab value of array element at pivot */ 
		int p = a[pivotIndex];
		
		/* Put element in the pivot index at the right of the array */
		int temp = a[right];
		a[right] = a[pivotIndex];
		a[pivotIndex] = temp;
		
		/* 
		 * Swap all elements less than the pivot to the left of the pivot position
		 */
		int storeIndex = left - 1;		
		for (int j = left; j <= right; j++) {
			
			if (a[j] <= p) {
				storeIndex++;
				temp = a[storeIndex];
				a[storeIndex] = a[j];
				a[j] = temp;				
			}
		}
		
		return storeIndex;
	}
	
	public int partitionArrayPosNeg(int[] a, int left, int right) {
		
		/* 
		 * Swap all elements less than the pivot to the left of the pivot position
		 * 
		 * Invariant: storeIndex always pointing to first positive element in array
		 * or moving forward swapping elements
		 * 
		 */
		int storeIndex = left;		
		for (int j = left; j <= right; j++) {
			
			if (a[j] <= 0) {				
				int temp = a[storeIndex];
				a[storeIndex] = a[j];
				a[j] = temp;
				storeIndex++;
			}
		}
		
		return storeIndex;
	}

	
	
	/* Re arrange elements of the array so that positive and negative 
	 * elements are interspersed 
	 */
	public void rearragePosAndNeg(int[] a) {
		
		partitionArrayPosNeg(a, 0, a.length - 1);
		
		int firstPos = a.length;
		for (int i = 0; i < a.length; i++) {
			if (a[i] >= 0) {
				firstPos = i;
				break;
			}
		}
		
		int i = 0;
		int j = firstPos;
		while (i < a.length && j < a.length) {
			int temp = a[i];
			a[i] = a[j];
			a[j] = temp;
			i += 2;
			j++;
		}
				
	}
	
	public static void main(String[] args) {
		
		
		
		RearrangePositiveAndNegative r = new RearrangePositiveAndNegative();
		
		int[]  a = {4,3,6,5,8,7,6,9,10,2,13};
		
		System.out.printf("ORIGINAL:");
		r.printArray(a);
		System.out.printf("========================\n");
		
		System.out.printf("Pivot index: %d a[%d]: %d\n", 0, 0, a[0]);
		
		int q = r.partitionArrayStandard(a, 0, a.length - 1, 0);
		
		System.out.printf("========================\n");
		System.out.printf("STANDARD PARTITION:\n");
		System.out.printf("PIVOT: %d\n", q);
		r.printArray(a);		
		System.out.printf("========================\n");
		
		int[] b = {4,3,6,5,8,7,6,9,10,2,13};
		System.out.printf("ORIGINAL:");
		r.printArray(b);
		System.out.printf("Pivot index: %d a[%d]: %d\n", 4, 4, a[4]);
		q = r.partitionArrayStandard(b, 0, b.length - 1, 4);
		System.out.printf("STANDARD:\n");
		System.out.printf("q: %d\n", q);
		r.printArray(b);
		System.out.printf("========================\n");
		
		int[] c = {4,3,6,5,8,7,6,9,10,2,13};
		System.out.printf("ORIGINAL:");
		r.printArray(c);
		System.out.printf("Pivot index: %d a[%d]: %d\n", 7, 7, a[7], q);
		q = r.partitionArrayStandard(c, 0, c.length - 1, 7);
		System.out.printf("STANDARD:\n");
		System.out.printf("q: %d\n", q);
		r.printArray(c);
		System.out.printf("========================\n");
		
		
		int[]  d = {-4,3,-6,5,8,7,-6,9,10,-2,-13,14,15,-16,-17,-18,19,20,21};
		System.out.printf("ORIGINAL:");
		r.printArray(d);		
		q = r.partitionArrayPosNeg(d, 0, d.length - 1);
		System.out.printf("POSTIVE/NEGATIVE:\n");
		System.out.printf("q: %d\n", q);
		r.printArray(d);				
		System.out.printf("========================\n");
		
		int[]  e = {-4,3,-6,5,8,7,-6,9,10,-2,-13,14,15,-16,-17,-18,19,20,21};
		System.out.printf("ORIGINAL:");
		r.printArray(e);
		r.rearragePosAndNeg(e);		
		System.out.printf("REARRANGE POSTIVE/NEGATIVE:\n");
		r.printArray(e);
		System.out.printf("========================\n");
		
	}

}
