package com.leetcode;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

public class SingleNumber {

	public static void main(String[] args) {
		Set<Integer> s = new HashSet<>();
		int[] arr = {2,2,3};
		for(int i : arr) {
			if(s.contains(i)) {
				s.remove(i);
			}else {
				s.add(i);
			}
		}
		for(int i : s) {
			System.out.println(i);
		}
	}

}
