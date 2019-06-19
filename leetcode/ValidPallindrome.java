package com.practice.leetcode;

public class ValidPallindrome {

	public static void main(String[] args) {
		boolean flag = isPallindrome();
		System.out.println("is string valid pallindrome? : "+ flag);
	}

	private static boolean isPallindrome() {
		String str = "1200345654321";
		for(int i=0,j=str.length()-1;i<j;i++,j--) {
			if(str.charAt(i) != str.charAt(j)) {
				return  isPallindrome(str.substring(i+1, j+1)) || isPallindrome(str.substring(i, j));
			}
		}
		return true;
	}

	private static boolean isPallindrome(String substring) {
		for(int i=0,j=substring.length()-1;i<j;i++,j--) {
			if(substring.charAt(i) != substring.charAt(j)) {
				return false;
			}
		}
		return true;
	}

}
