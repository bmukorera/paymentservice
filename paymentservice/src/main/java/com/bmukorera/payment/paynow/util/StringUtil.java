package com.bmukorera.payment.paynow.util;


import java.util.*;

public class StringUtil {


	public static String getShortName(String projectName){
		String shortName ="";
		String [] tokens = projectName.split(" ");
		switch(tokens.length){
		case 1:
			shortName=projectName.trim();
			break;
		case 2:
			shortName=tokens[0]+"_"+tokens[1];
			break;
		case 3:
			shortName=tokens[0]+"_"+tokens[2];
			break;
		default:
			shortName=tokens[0]+"_"+tokens[2];
			break;
		}
		return shortName;
		
	}
	public  static List<String> splitStringByTag(String line, String tag){
		String [] tokens = line.split(tag);
		List<String> items = new ArrayList<String>(Arrays.asList(tokens));
		return items;
	}
	public static Map<String,String> generateMapFromList(List<String> items,String tag){
		Map<String,String> map = new HashMap<String,String>();
		for(String value: items){
			String [] tokens =value.split(tag);
			map.put(tokens[0],tokens[1]);

		}
		return map;
	}

}
