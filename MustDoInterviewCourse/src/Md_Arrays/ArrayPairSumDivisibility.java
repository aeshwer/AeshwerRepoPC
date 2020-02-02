package Md_Arrays;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

//https://practice.geeksforgeeks.org/problems/array-pair-sum-divisibility-problem/0/?track=md-hashing&batchId=144
public class ArrayPairSumDivisibility {

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
			int k = fastReader.nextInt();
			IsPairSumDivisible(arr, k);
		}
	}

	private static void IsPairSumDivisible(int[] arr, int k) {

		if(arr.length%2!=0) {
			System.out.println("False");
			return;
		}
		int sum = 0;
		for (int i = 0; i < arr.length; i++) {
			if (arr[i] % k != 0) {
				sum += arr[i]%k;
			}
		}

		if (sum % k == 0)
			System.out.println("True");
		else {
			System.out.println("False");
		}
	}

}
