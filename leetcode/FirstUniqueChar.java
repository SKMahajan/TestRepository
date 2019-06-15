package com.leetcode;

import java.util.HashMap;
import java.util.Map.Entry;

public class FirstUniqueChar {

	public static void main(String[] args) {
		String str="loveleetcode";
		System.out.println(uniqueChar(str));
	}

	private static int uniqueChar(String str) {
		HashMap<Character, Integer> hm = new HashMap<>();
		
		for(int i=0;i<str.length();i++) {
			char c = str.charAt(i);
			if(hm.containsKey(c)) {
				hm.put(c, -1);
			}else {
				hm.put(c, i);
			}
		}
		hm.forEach((k,v)->System.out.println(k+" : "+v));
		int index=Integer.MAX_VALUE;
		for (Entry<Character, Integer> e : hm.entrySet()) {
			if(e.getValue()>=0 && e.getValue()<index) {
				index=e.getValue();
			}
		}
		return index==Integer.MAX_VALUE?-1:index;
	}

}
