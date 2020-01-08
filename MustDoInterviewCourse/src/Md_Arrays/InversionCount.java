package Md_Arrays;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class InversionCount {

	static class FastReader {

		BufferedReader reader;
		StringTokenizer token;

		FastReader() {
			reader = new BufferedReader(new InputStreamReader(System.in));
		}

		Integer nextInt() {
			return Integer.parseInt(next());
		}

		private String next() {
			if (token == null || !token.hasMoreElements()) {
				try {
					token = new StringTokenizer(reader.readLine());
				} catch (IOException e) {
					e.printStackTrace();
				}
			}
			return token.nextToken();
		}

		String nextLine() {
			String str = "";
			try {
				str = reader.readLine();
			} catch (IOException e) {
				e.printStackTrace();
			}
			return str;
		}

	}

	public static void main(String[] args) {
		FastReader fastReader = new FastReader();
		int cases = fastReader.nextInt();

		while (--cases >= 0) {
			int n = fastReader.nextInt();
			int arr[] = new int[n];
			int i = 0;
			while (--n >= 0) {
				arr[i++] = fastReader.nextInt();
			}
			// findInversionCount(arr);
			findInversionCountOptimalSolution(arr);
		}
	}

	// O(nlogn) -Using Enhanced Merge sort
	private static void findInversionCountOptimalSolution(int[] arr) {
		System.out.println(mergeSortAndCount(arr, 0, arr.length - 1));

	}

	private static long mergeSortAndCount(int[] arr, int l, int r) {
		// Keeps track of the inversion count at a
		// particular node of the recursion tree
		long count = 0;

		if (l < r) {
			int m = (l + r) / 2;

			// Total inversion count = left subarray count
			// + right subarray count + merge count

			// Left subarray count
			count += mergeSortAndCount(arr, l, m);

			// Right subarray count
			count += mergeSortAndCount(arr, m + 1, r);

			// Merge count
			count += enhancedMerge(arr, l, m, r);
		}

		return count;
	}

	private static int enhancedMerge(int[] arr, int l, int m, int r) {
		// Left subarray
		int[] left = Arrays.copyOfRange(arr, l, m + 1);

		// Right subarray
		int[] right = Arrays.copyOfRange(arr, m + 1, r + 1);

		int i = 0, j = 0, k = l, swaps = 0;

		while (i < left.length && j < right.length) {
			if (left[i] <= right[j])
				arr[k++] = left[i++];
			else {
				arr[k++] = right[j++];
				//swaps += (m + 1) - (l + i);
				swaps+= left.length -i;
			}
		}

		// Fill from the rest of the left subarray
		while (i < left.length)
			arr[k++] = left[i++];

		// Fill from the rest of the right subarray
		while (j < right.length)
			arr[k++] = right[j++];

		return swaps;
	}

	// O(n2) solution
	private static void findInversionCount(int[] arr) {
		int T[] = new int[arr.length];
		for (int i = 0; i < arr.length; i++) {
			for (int j = i + 1; j < arr.length; j++) {
				if (arr[i] > arr[j]) {
					T[i] = T[i] + 1;
				}
			}
		}
		int sum = Arrays.stream(T).sum();
		System.out.println(sum);
	}
}
