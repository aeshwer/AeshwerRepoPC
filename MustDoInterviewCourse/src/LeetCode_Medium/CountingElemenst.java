package LeetCode_Medium;

import java.util.HashSet;
import java.util.Set;

//Given an integer array arr, count element x such that x + 1 is also in arr.
//If there're duplicates in arr, count them seperately

public class CountingElemenst {

	public static int countElements(int[] arr) {
		Set<Integer> lookup = new HashSet<>();

		for (Integer val : arr) {
			lookup.add(val);
		}

		int count = 0;
		for (Integer val : arr) {
			if (lookup.contains(val + 1)) {
				count++;
			}
		}
		return count;
	}

	public static void main(String[] args) {
		int[] arr = { 1, 1, 2 };// 2
		int[] arr2 = { 1, 1, 2, 2 };// 2
		System.out.println(countElements(arr2));
	}
}
