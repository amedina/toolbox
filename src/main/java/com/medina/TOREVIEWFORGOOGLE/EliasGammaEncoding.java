package com.medina.TOREVIEWFORGOOGLE;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.medina.toolbox.strings.BaseConversion;

/*
 * Elias Gamma Encoding
 */

public class EliasGammaEncoding {

	private static Logger log = LoggerFactory.getLogger(EliasGammaEncoding.class);
	
	BaseConversion sc;
	
	public EliasGammaEncoding() {
		super();
		sc = new BaseConversion();
	}

	public String eGammaEnconde(ArrayList<Integer> array) {
		
		String eGammaString = "";
		
		for (Integer a : array) {
			
			String aDecoded = sc.intToString(a, 2);
			int c = 0;
			if (a > 0) {
				c = (int)(Math.log10(a)/Math.log10(2)) + 1;			
			}
			for (int i = 1; i < c; i++) {
				aDecoded = "0" + aDecoded;
			}
			
			eGammaString += aDecoded; 
		}
		
		return eGammaString;
		
	}
	
	public ArrayList<Integer> eGammaDecode(String s) {
	
		ArrayList<Integer> array = new ArrayList<Integer>();
		
		int i = 0;
		int l = s.length();
		
		while (i < l) {
			
			if (s.charAt(i) != '0' ) {
				log.error("Wrong Input!");
				return array;
			}
			
			int c = 0;
			do {
				i += 1;
				c += 1;
			}while(s.charAt(i) == '0');
			
			log.info("i: {} c: {} ss: {}", new Object[] {i, c, s.substring(i, i + c + 1)});
			
			int x = sc.stringToInt(s.substring(i, i + c + 1), 2);
			
			array.add(x);
			
			i += (c + 1);
			
		}

		return array;
		
	}
	
	public void EliasGammaEncdingDriver() {
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String searchString = null;
		
		while (true) {

			log.info("Enter non-negative integer: ");
			try {
				searchString = br.readLine();
			} catch (IOException e) {
				log.error("IO Exception!");
			}

			if (searchString.toLowerCase().equals("eof")) {
				break;
			}
			
			String stringX = searchString;
			
			int x = Integer.parseInt(stringX);
		
			ArrayList<Integer> array = new ArrayList<Integer>();
			array.add(x);
			array.add(x);
			array.add(7);
			array.add(3);
			
			String eGEncoding = eGammaEnconde(array);
			log.info("Positive Integer n: {} eGammaEncoding: {}", x, eGEncoding);
			ArrayList<Integer> array2 = eGammaDecode(eGEncoding);
			log.info("String: {} eGammaDecoding: {}", x, array2);
		}
	}
	public static void main(String[] args) {

	}

}
