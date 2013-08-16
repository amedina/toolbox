package com.medina.toolbox.regex;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;


public class PreProcessCompanyName {
	
	private static Logger log = LoggerFactory.getLogger(PreProcessCompanyName.class);

	public static boolean validateName(String name) {
		
		boolean valid = true;
		
		if (name == null) {
			valid = false;
		}
		
		if (name.length() < 3) {
			valid = false;
		}		
		
		return valid;
		
	}
	public static String preProcessCompanyName(String name) {
		
		String replaceSuffixPattern_Inc_1 = ",[\\s*\\w*\\s*]*[Ii][Nn][Cc]\\.?$";
		String replaceSuffixPattern_Inc_2 = "\\s+[Ii][Nn][Cc]\\.?$";
		
		String replaceSuffixPattern_Ltd_1 = ",[\\s*\\w*\\s*]*[Ll][Tt][Dd]\\.?$";
		String replaceSuffixPattern_Ltd_2 = "\\s+[Ll][Tt][Dd]\\.?$";
		String replaceSuffixPattern_Ltd_3 = "\\s[Ll]imited$";
				
		String replaceSuffixPattern_LLC = "(\\s*[Ll][Ll][Cc]\\.?$)";		
		String replaceSuffixPattern_LLP = "(\\s*[Ll][Ll][Pp]\\.?$)";
		
		String replaceSuffixPattern_Corp_1 = "\\s[Cc]orporation$";
		String replaceSuffixPattern_Corp_2 = "\\s[Cc]orp\\.?$";
		
		String replaceSuffixPattern_Comma_End = ",$";
		String replaceSuffixPattern_Dot_End = "\\.$";
		
		String replaceSuffixPattern_Co_1 = "[^&] co\\.?$";
		
		log.info("BEFORE: {}", name);
		
		/* Clean names ending with Inc */
		if (name.matches(".*" + replaceSuffixPattern_Inc_1)) {			
			name = name.replaceAll(replaceSuffixPattern_Inc_1, "");			
		}
		
		if (name.matches(".*" + replaceSuffixPattern_Inc_2)) {			
			name = name.replaceAll(replaceSuffixPattern_Inc_2, "");			
		}
		
		/* Clean names ending with Ltd */
		if (name.matches(".*" + replaceSuffixPattern_Ltd_1)) {
			name = name.replaceAll(replaceSuffixPattern_Ltd_1, "");
		}
		
		if (name.matches(".*" + replaceSuffixPattern_Ltd_2)) {
			name = name.replaceAll(replaceSuffixPattern_Ltd_2, "");
		}
		
		if (name.matches(".*" + replaceSuffixPattern_Ltd_3)) {
			name = name.replaceAll(replaceSuffixPattern_Ltd_3, "");
		}
		
		if (name.matches(".*" + replaceSuffixPattern_LLC)) {
			name = name.replaceAll(replaceSuffixPattern_LLC, "");
		}
		
		if (name.matches(".*" + replaceSuffixPattern_LLP)) {			
			name = name.replaceAll(replaceSuffixPattern_LLP, "");
		}
		
		if (name.matches(".*" + replaceSuffixPattern_Comma_End)) {			
			name = name.replaceAll(replaceSuffixPattern_Comma_End, "");
		}
		
		if (name.matches(".*" + replaceSuffixPattern_Dot_End)) {			
			name = name.replaceAll(replaceSuffixPattern_Dot_End, "");
		}

		if (name.matches(".*" + replaceSuffixPattern_Corp_1)) {			
			name = name.replaceAll(replaceSuffixPattern_Corp_1, "");
		}
		
		if (name.matches(".*" + replaceSuffixPattern_Corp_2)) {			
			name = name.replaceAll(replaceSuffixPattern_Corp_2, "");
		}

		if (name.matches(".*" + replaceSuffixPattern_Co_1)) {			
			name = name.replaceAll(replaceSuffixPattern_Co_1, "");
		}
		
		log.info("AFTER: {}", name);
		
		return name;
	}
	
	
	public static void main(String[] args) {
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		String companyName = null;
				
		while (true) {
			
			System.out.print("Enter company name: ");
			try {
				companyName = br.readLine();
			} catch (IOException e) {
				log.error("IO Exception!");
				e.printStackTrace();
			}
			
			if (companyName.toLowerCase().equals("eof")) {
				break;
			}
			
			String name = companyName.trim();
			PreProcessCompanyName.preProcessCompanyName(name);
			
			System.out.println("");
	
		}

	}

}
