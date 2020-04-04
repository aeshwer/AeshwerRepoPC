package Company_Solution;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

public class AqrTest1 {

	static long exponentialGrowth(long[] arr, int n) {
		Set<Long> lookup = new HashSet<Long>();

		for (int i = 0; i < arr.length; i++) {
			lookup.add(arr[i]);
		}
		boolean isPresent = true;
		while (isPresent) {
			if (lookup.contains((long) n)) {
				n = n * 2;
			} else {
				isPresent = false;
			}
		}

		return n;

	}

	static long exponentialGrowth2(long[] arr, int n) {
		Arrays.sort(arr);
		
		int l = 0;
		int r = arr.length - 1;

		while (l < r) {
			int mid = l + (r - l) / 2;
			if (arr[mid] == n) {
				n = n * 2;
			} else if (n < arr[mid]) {
				r = mid - 1;
			} else {
				l = mid + 1;
			}
		}

		return n;
	}

	public static void main(String[] args) {
		long[] arr = { 24, 13, 12, 96, 25, 48 };
		System.out.println(exponentialGrowth2(arr, 12));

	}

}
