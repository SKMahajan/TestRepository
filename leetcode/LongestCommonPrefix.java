package com.leetcode;

public class LongestCommonPrefix {

	public static void main(String[] args) {
		String[] strs = {"car", "dap", "cat"};
		System.out.println("longest prefix is : "+longestPrefix(strs));
	}

	private static String longestPrefix(String[] strs) {
		String lp="";
		if(strs == null || strs.length==0) {
			return lp;
		}
		int index=0;
		for(char c : strs[0].toCharArray()) {
			for(int i=0; i<strs.length;i++) {
				if(index>=strs[i].length() || c != strs[i].charAt(index)) {
					return lp;
				} 
			}
			lp=lp+c;
		}
		return lp;
	}

}
