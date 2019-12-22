package Md_Arrays;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

//https://practice.geeksforgeeks.org/problems/equilibrium-point/0/?track=md-arrays&batchId=144
public class EqulibriumPoint {

	public static class FastReader {

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
			findEqulibriumPoint(arr);
		}
	}

	private static void findEqulibriumPoint(int[] arr) {
		long sum = 0, pre = 0;
		for (int i = 0; i < arr.length; i++) {
			sum = sum + arr[i];
		}

		for (int i = 0; i < arr.length; i++) {
			if (pre + arr[i] == sum - pre) {
				System.out.println(i + 1);
				return;
			}
			pre += arr[i];
		}
		System.out.println(-1);
	}

}
