package com.medina.TOREVIEWFORGOOGLE;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.Map;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class ExcelConversion {

	private static Logger log = LoggerFactory.getLogger(ExcelConversion.class);
	
	
	
	public static int ssDecodeColumnId(String colId) {
	
		Map<String, Integer> map = new HashMap<String, Integer>();
		map.put("A",  1);
		map.put("B",  2);
		map.put("C",  3);
		map.put("D",  4);
		map.put("E",  5);
		map.put("F",  6);
		map.put("G",  7);
		map.put("H",  8);
		map.put("I",  9);
		map.put("J",  10);
		map.put("K",  11);
		map.put("L",  12);
		map.put("M",  13);
		map.put("N",  14);
		map.put("O",  15);
		map.put("P",  16);
		map.put("Q",  17);
		map.put("R",  18);
		map.put("S",  19);
		map.put("T",  20);
		map.put("U",  21);
		map.put("V",  22);
		map.put("W",  23);
		map.put("X",  24);
		map.put("Y",  25);
		map.put("Z",  26);
		
		int x = 0;
		for (int i = 0; i < colId.length(); i++) {
			x = x*26 + map.get(colId.substring(i, i + 1));
		}
		
		return x;
	}
	
	
	public static void main(String[] args) {
		
		
		log.info("Input EOF and press enter to end test...");

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		String colIdString = null;

		while (true) {

			log.info("Enter Excel Column Id: ");
			try {
				colIdString = br.readLine();
			} catch (IOException e) {
				log.error("IO Exception!");
			}

			if (colIdString.toLowerCase().equals("eof")) {
				break;
			}
		
			log.info("ColumnId: {} decoding: {}", colIdString, ssDecodeColumnId(colIdString.toUpperCase()));
			
		}

	}

}
