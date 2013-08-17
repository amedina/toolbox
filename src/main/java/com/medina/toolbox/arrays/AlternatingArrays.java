package com.medina.toolbox.arrays;

import java.util.Arrays;

public class AlternatingArrays {

        /*
         * Problem: given an array, produce another where A[i] <= A[1] >= A[2] <= A[3] >=...
         * 
         * Solution #4 (O(n)): Find the median, and alternate elements above the median
         * with elements below the median: 
         * 
         */
        
        public void printArray(int[] a) {
                for (int i = 0; i < a.length; i++) {
                        System.out.printf("%d ", a[i]); 
                }
                System.out.println("");
        }
        
        /* 
         * Solution #1 (O(nlogn)): Sort the array and swap adjacent elements when the
         * conditions don't hold
         */ 

        public int[] solutionOne(int[] a) throws IllegalArgumentException {
                
                if (a == null || a.length == 0) {throw new IllegalArgumentException();}
                
                Arrays.sort(a);
                
                for (int i = 1; i < a.length - 1; i += 2) {
                        int temp = a[i];
                        a[i] = a[i+1];
                        a[i + 1] = temp;
                }
                
                return a;
                
        }
        
        /* 
         * Solution #2 (O(nlogn)): We could sort the array and interleave the top and bottom
         * halves. 
         */ 
        public int[] solutionTwo(int[] a) {
                
                if (a == null || a.length == 0) {throw new IllegalArgumentException();}
                
                Arrays.sort(a);
                
                int i = 1;
                int j = a.length - 1;
                while (i < j) {
                        int temp = a[i];
                        a[i] = a[j];
                        a[j] = temp;
                        i += 2;
                        j -= 2;
                }               
                
                return a;
        }
        
        /*
         * Solution #3 (O(n)): Traverse the array and swap elements i and i + 1 when: 
         * (1) i is even, and A[i] > A[i+1], or 
         * (2) i is odd and A[i] < A[i+ 1]
         * 
         */
        public int[] solutionThree(int[] a) {
                
                if (a == null || a.length == 0) {throw new IllegalArgumentException();}
                
                for (int i = 0; i < a.length - 1; i++) {
                        if (((i & 1) == 0 && (a[i] > a[i + 1])) || ((i & 1) == 1) && (a[i] < a[ i + 1])) {
                                int temp = a[i];
                                a[i] = a[i + 1];
                                a[i + 1] = temp;
                        }
                }
                
                return a;
        }
        
        
        public static void main(String[] args) {
                
                int[] a1 = {4,6,5,7,2,45,34,76,87,98};
                int[] a2 = {4,6,5,8,2,45,34,76,87,98,1};
                int[] a3 = {4,6,5,8,2,45,34,76,87,98};
                int[] res;
                AlternatingArrays alt = new AlternatingArrays();
                
                alt.printArray(a1);
                res = alt.solutionOne(a2);
                alt.printArray(res);
                res = alt.solutionTwo(a2);
                alt.printArray(res);
                res = alt.solutionThree(a2);
                alt.printArray(res);          
        }
}
