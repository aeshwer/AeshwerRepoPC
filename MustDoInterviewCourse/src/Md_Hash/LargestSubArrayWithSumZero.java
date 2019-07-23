package Md_Hash;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class LargestSubArrayWithSumZero {

	public static class FastReader {

		BufferedReader read;
		StringTokenizer token;

		public FastReader() {
			read = new BufferedReader(new InputStreamReader(System.in));
		}

		Integer nextInt() {
			return Integer.parseInt(next());
		}

		private String next() {
			while (token == null || !token.hasMoreElements()) {
				try {
					token = new StringTokenizer(read.readLine());
				} catch (IOException e) {
					e.printStackTrace();
				}
			}
			return token.nextToken();
		}
	}

	int maxLen(int arr[], int n) {
		return 0;
	}

	public static void main(String[] args) {
		FastReader reader = new FastReader();
		int cases = reader.nextInt();

		while (--cases >= 0) {
		
			int n = reader.nextInt();
			int arr[] =
			
		}
	}

}
