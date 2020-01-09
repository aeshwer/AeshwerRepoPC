package Md_Hash;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.StringTokenizer;

public class CountDistintElementInEachWindow {

	public static class FastReader {

		BufferedReader reader;
		StringTokenizer token;

		public FastReader() {
			reader = new BufferedReader(new InputStreamReader(System.in));
		}

		String next() {

			if (token == null || !token.hasMoreTokens()) {
				try {
					token = new StringTokenizer(reader.readLine());
				} catch (IOException e) {
					e.printStackTrace();
				}
			}
			return token.nextToken();

		}

		Integer nextInt() {
			return Integer.parseInt(next());
		}

		Long nextLong() {
			return Long.parseLong(next());
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
		long cases = fastReader.nextLong();

		while (--cases >= 0) {
			int n = fastReader.nextInt();
			int k = fastReader.nextInt();
			int[] arr = new int[n];
			int i = 0;
			while (--n >= 0) {
				arr[i++] = fastReader.nextInt();
			}

			countDistinctElement(arr, k);
		}
	}

	// O(n) solution -Using sliding Window Concept
	private static void countDistinctElement(int[] arr, int k) {

		HashMap<Integer, Integer> lookup = new HashMap<>();
		int distintCount = 0;
		int start = 0;
		for (int i = 0; i < arr.length; i++) {

			if (lookup.containsKey(arr[i])) {
				lookup.put(arr[i], lookup.get(arr[i]) + 1);
			} else {
				distintCount++;
				lookup.put(arr[i], 1);
			}
			if ((i + 1 - start) % k == 0) {
				System.out.print(distintCount + " ");
			}

			if (i - start + 1 == k) {
				if (lookup.get(arr[start]) > 1) {
					lookup.put(arr[start], lookup.get(arr[start]) - 1);
				} else {
					distintCount--;
				}
				start++;
			}
		}
	}

}
