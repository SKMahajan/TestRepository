package com.leetcode;

import java.util.HashMap;
import java.util.Map;

public class TwoSum {

	public static void main(String[] args) {
		int[] arr = {2,3,4,5,6,7};
		int target = 10;
		int[] index = new int[2];
		Map<Integer, Integer> m = new HashMap<>();
		for(int i =0;i<arr.length;i++) {
			int diff = target-arr[i];
			if(m.containsKey(diff)) {
				index[0]=i;
				index[1]=m.get(diff);
				System.out.println(i+" : "+ m.get(diff));
			}else {
				m.put(arr[i], i);
			}
		}
	}

}
