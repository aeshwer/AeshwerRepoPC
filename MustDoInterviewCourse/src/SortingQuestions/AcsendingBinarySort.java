package SortingQuestions;

import java.util.Arrays;
import java.util.Comparator;

//https://leetcode.com/problems/sort-integers-by-the-number-of-1-bits/
public class AcsendingBinarySort {

	public static int[] sortByBits(int[] arr) {

		// copy vaules in in array
		Integer[] a = Arrays.stream(arr).boxed().toArray(Integer[]::new);

		// sort and compare
		Arrays.sort(a, new Comparator<Integer>() {
			@Override
			public int compare(Integer arg0, Integer arg1) {
				return Integer.bitCount(arg0) == Integer.bitCount(arg1) ? Integer.compare(arg0, arg1)
						: Integer.compare(Integer.bitCount(arg0), Integer.bitCount(arg1));
			}
		});

		return Arrays.stream(a).mapToInt(Integer::intValue).toArray();
	}

	public static void main(String[] args) {
		int[] arr = { 0, 1, 2, 3, 4, 5, 6, 7, 8 };
		int[] res = sortByBits(arr);
		System.out.println(Arrays.toString(res));
	}
}
