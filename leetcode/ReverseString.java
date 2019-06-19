package com.practice.leetcode;

public class ReverseString {

	public static void main(String[] args) {
		String str = "Dr. Abdul Kalam";
		char[] characters = str.toCharArray();
		for(int i = 0, j=str.length()-1; i<j; i++,j--) {
			char temp = characters[i];
			characters[i] = characters[j];
			characters[j] = temp;
		}
		System.out.println(new String(characters));
	}

}
