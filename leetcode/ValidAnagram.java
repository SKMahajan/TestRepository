package com.practice.leetcode;

import java.util.HashMap;

public class ValidAnagram {

	public static void main(String[] args) {
		String str1 = "abcdef";
		String str2 = "acbfed";
		
		System.out.println(isAnagram(str1, str2));
	}

	private static boolean isAnagram(String str1, String str2) {
		if(str1.length() != str2.length()) {
			return false;
		}
		HashMap<Character, Integer> count = new HashMap<>();
		for(int i=0; i<str1.length();i++) {
			count.put(str1.charAt(i), count.getOrDefault(str1.charAt(i),0)+1);
			count.put(str2.charAt(i), count.getOrDefault(str2.charAt(i),0)-1);
		}
		for(int i : count.values()) {
			if(i!=0) {
				return false;
			}
		}
		count.forEach((k,v)->System.out.println(k +" : "+v));
		
		return true;
	}

}
