package Md_Hash;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.StringTokenizer;

public class AnagramArrays {

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

	private static void checkAnagramString(int[] arr1, int[] arr2) {

		int sum = 0;
		for (int i = 0; i < arr1.length; i++) {
			sum = sum + arr1[i] - arr2[i];
		}
		if (sum == 0)
			System.out.println(1);
		else
			System.out.println(0);

	}

	public static void main(String[] args) {

		FastReader fastReader = new FastReader();
		long cases = fastReader.nextLong();

		while (--cases >= 0) {
			int n = fastReader.nextInt();
			int temp = n;
			int[] arr1 = new int[n];
			int i = 0;
			while (--n >= 0) {
				arr1[i++] = fastReader.nextInt();
			}

			int[] arr2 = new int[temp];
			i = 0;
			while (--temp >= 0) {
				arr2[i++] = fastReader.nextInt();
			}
			checkAnagramString(arr1, arr2);
		}
	}

}
