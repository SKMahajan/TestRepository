package com.leetcode;

import java.util.HashSet;
import java.util.Set;

public class ContainsDuplicate {

	public static void main(String[] args) {
		int[] arr = {11,2,33,44,5};
		
		System.out.println(isItContainsDuplicate(arr));
		
		
	}

	private static boolean isItContainsDuplicate(int[] arr) {
		Set<Integer> s = new HashSet<>();
		for(int i : arr) {
			if(s.contains(i)) {
				return true;
			}else {
				s.add(i);
			}
		}
		return false;
	}

}
