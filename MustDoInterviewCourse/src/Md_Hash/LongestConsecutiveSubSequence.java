package Md_Hash;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashSet;
import java.util.StringTokenizer;

public class LongestConsecutiveSubSequence {

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
			int sol1 = longestConsecutiveSubSequence1(arr, arr.length);
			int sol2 = longestConsecutiveSubSequence2(arr, arr.length);
			System.out.println(sol1);
			System.out.println(sol2);
		}
	}

	private static int longestConsecutiveSubSequence2(int[] arr, int n) {
		int maxElement = 0;
		// Find max element and make a lookup of that size
		for (int i = 0; i < n; ++i) {
			maxElement = Math.max(maxElement, arr[i]);
		}
		int lookup[] = new int[maxElement + 1];

		// populate the lookup with value=1 for element present in array
		for (int i = 0; i < n; ++i) {
			lookup[arr[i]] = 1;
		}

		int curr = 0;
		int longest = 0;
		for (int i = 0; i < lookup.length; ++i) {
			if (lookup[i] == 1) {
				curr++;
			} else {
				curr = 0;
			}
			longest = Math.max(longest, curr);
		}

		return longest;
	}

	private static int longestConsecutiveSubSequence1(int[] arr, int n) {

		HashSet<Integer> S = new HashSet<Integer>();
		int ans = 0;

		// Add all the array elements to Hash set
		for (int i = 0; i < n; ++i)
			S.add(arr[i]);

		// check each possible sequence from the start
		// then update optimal length
		for (int i = 0; i < n; ++i) {
			// if current element is the starting element of a sequence
			if (!S.contains(arr[i] - 1)) {

				// Then check for next elements in the sequence
				int j = arr[i];
				while (S.contains(j))
					j++;

				// update optimal length if this length is more
				if (ans < j - arr[i])
					ans = j - arr[i];
			}
		}

		return ans;
	}

}
