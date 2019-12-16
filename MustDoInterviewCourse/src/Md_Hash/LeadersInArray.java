package Md_Hash;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;
//https://practice.geeksforgeeks.org/problems/leaders-in-an-array/0/?track=md-arrays&batchId=144
import Md_Hash.SortElementsByFrequency.FastReader;

public class LeadersInArray {

	public static class FastReader {

		BufferedReader reader;
		StringTokenizer token;

		public FastReader() {
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

			getLeadersInArray(arr);
		}
	}

	private static void getLeadersInArray(int[] arr) {
		String result = "";
		int maxElement = arr[arr.length - 1];
		result = result + maxElement;

		for (int i = arr.length - 2; i >= 0; i--) {
			if (arr[i] >= maxElement) {
				result = arr[i] + " " + result;
			}
			maxElement = Math.max(maxElement, arr[i]);
		}
		
		System.out.println(result);
	}
}
