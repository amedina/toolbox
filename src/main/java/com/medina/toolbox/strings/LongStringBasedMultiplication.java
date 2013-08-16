package com.medina.toolbox.strings;

public class LongStringBasedMultiplication {

	public String arrayToString(int[] a) {
		
		StringBuilder sb = new StringBuilder();
		
		for (int i = 0; i < a.length; i++) {
			sb.append(String.valueOf(a[i]));
			sb.append(" ");
		}
		
		sb.reverse();
		return sb.toString();
	}
	
	public String longMult(String a, String b) {
		
		int intRes = 0;			
		int[] res = new int[a.length() * b.length()];
		
		int k = 0;
		int carryOn  = 0;
		int maxTempK = 0;
		for (int j  = b.length() - 1; j >= 0; j--) {
			
			int tempK = 0;
			
			for (int i  = a.length() - 1; i >= 0; i--) {
				
				/*  Grab values to be operated on */
				int v1 = Integer.valueOf(b.charAt(j)) - '0';
				int v2 = Integer.valueOf(a.charAt(i)) - '0';
				
				/* Perform single-digit multiplication, ad carry on */
				int temp = (v1 * v2) + carryOn;			
				intRes = temp % 10 ;
				carryOn = temp / 10;				
				
				res[k + tempK] += intRes;
				System.out.printf("Updating: v1: %d v2: %d intRes: %d carryOn: %d k: %d tK: %d res[%d]: %d\n", v1, v2, intRes, carryOn, k, tempK, k + tempK, res[k + tempK]);
				
				
				tempK += 1;
				
			}
			
			res[k + tempK] = (res[k + tempK] + carryOn)%10;
			carryOn = (res[k + tempK] + carryOn)/10;
			System.out.printf("Updating: carryOn: %d k: %d tK: %d res[%d]: %d\n",  carryOn, k, tempK, k + tempK, res[k + tempK]);
			k += 1;
			if (tempK > maxTempK) { maxTempK = tempK;}
		}
		
		
		/* Final pass */
		carryOn = 0;
		for (int i = 0; i <= maxTempK; i++) {
			System.out.printf("Before: %d CarryOn: %d", res[i], carryOn);
			int temp = (res[i] + carryOn) % 10; 
			carryOn = (res[i] + carryOn)/10;
			res[i] = temp;		
			System.out.printf(" After: %d carryOn: %d\n", res[i], carryOn);						
		}
		
		String resString = arrayToString(res);
		System.out.printf("RES: %s\n",  resString);

		
		return resString;
	}
	
	public void longMultDriver() {
				
		String A = "98765432";
		String B = "98765432";
		
		String res = longMult(A, B);
		
		System.out.printf("LM: A: %s B: %s R: %s", A, B, res);
	}

	public static void main(String[] args) {
		LongStringBasedMultiplication sa = new LongStringBasedMultiplication();
		sa.longMultDriver();
	}

}
