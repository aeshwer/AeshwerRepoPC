package Md_Arrays;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

import Md_String.Anagram.FastReader;

public class KadanasAlgo {

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
			implementKadanes(arr, arr.length);
		}
	}

	// O(n) Solution
	private static void implementKadanes(int[] a, int length) {

		if (length >= 0) {
			int maxValue = a[0];
			for (int i = 1; i < length; i++) {
				a[i] = Math.max(a[i], a[i] + a[i - 1]);
				maxValue = Math.max(maxValue, a[i]);
			}
			System.out.println(maxValue);
		}
		else {
			System.out.println(0);
		}
	}
}
