package Md_Arrays;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

//https://practice.geeksforgeeks.org/problems/number-of-pairs/0/?track=md-arrays&batchId=144
public class NumberOfPais {

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
			int m = fastReader.nextInt();
			int arr1[] = new int[n];
			int i = 0;
			while (--n >= 0) {
				arr1[i++] = fastReader.nextInt();
			}
			i = 0;
			int arr2[] = new int[m];
			while (--m >= 0) {
				arr2[i++] = fastReader.nextInt();
			}
			findNumberOfPairs(arr1,arr2);
		}
	}

	private static void findNumberOfPairs(int[] arr1, int[] arr2) {

	}

}
