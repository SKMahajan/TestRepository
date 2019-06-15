package com.leetcode;

import java.util.HashMap;

public class RansomNote {

	public static void main(String[] args) {
		System.out.println(note("aa","aab"));
	}

	private static boolean note(String note, String magazine) {
		if(note.length() >= magazine.length()) {
			return false;
		}
		HashMap<Character, Integer> hm = new HashMap<>();
		for(char c : magazine.toCharArray()) {
			hm.put(c, hm.getOrDefault(c, 0)+1);
		}
		for(char c : note.toCharArray()) {
			if(!hm.containsKey(c) || hm.get(c)<1) {
				return false;
			}else {
				hm.put(c, hm.get(c)-1);
			}
		}
		return true;
	}

}
