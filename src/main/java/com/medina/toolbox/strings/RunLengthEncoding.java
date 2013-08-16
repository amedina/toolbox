package com.medina.toolbox.strings;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/*
 * Run-Length Encoding: a fast way to do efficient on-the-fly compression and decompression 
 * of strings. Encode successive repeated characters by the repetition count and the character.
 */
public class RunLengthEncoding {

	private static Logger log = LoggerFactory.getLogger(RunLengthEncoding.class);
	
	public static String encodeString(String decodedString) {
		
		int count = 1;
		String encodedString = "";
		for (int i = 1; i < decodedString.length(); i++) {
			
			if (decodedString.charAt(i) == decodedString.charAt(i - 1)) {
				count += 1;
			}else {
				encodedString += String.valueOf(count);
				encodedString += decodedString.charAt(i - 1);
				count = 1;
			}			
		}
		
		encodedString += String.valueOf(count);
		encodedString += decodedString.charAt(decodedString.length() - 1);
		
		return encodedString;
	}
	
	public static String decodeString(String encodedString) {
		
		String decodedString = "";
		int count = 0;
		
		int sLength =  encodedString.length();
		
		for (int i = 0; i < sLength; i++) {
		
			char c = encodedString.charAt(i);
			if (c >= '0' && c <= '9') {
				count = count * 10 + c - '0';
			}else {
				for (int j = 0; j < count; j++) {
					decodedString += c;
				}
				count = 0;
			}
		
		}
		
		return decodedString;
		
	}
	
	

	

	
	public static void main(String[] args) {

		String encodedString = "5a1b16f";
		String decodedString = "aaaaabffffffffffffffff";
		
		log.info("Encoded: {} Decoded: {}", encodedString, decodeString(encodedString));
		log.info("Decoded: {} Encoded: {}", decodedString, encodeString(decodedString));
		

	}

}
