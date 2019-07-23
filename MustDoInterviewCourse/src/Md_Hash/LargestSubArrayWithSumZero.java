package Md_Hash;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.Map;
import java.util.Set;
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

	static int maxLen(int arr[], int n) {
		Map<Integer, Integer> lookup = new HashMap<Integer, Integer>();
		lookup.put(arr[0], 0);
		int maxLen = 1;
		int sum =arr[0];
		for(int i=1;i<n;i++) {
			
			sum= sum+arr[i];
			if(sum==0) 
			{
				maxLen=Math.max(maxLen, lookup.get(sum)-i);
			}
			
		}
		
		return maxLen;
	}

	public static void main(String[] args) {
		FastReader reader = new FastReader();
		int cases = reader.nextInt();

		while (--cases >= 0) {

			int n = reader.nextInt();
			int arr[] = new int[n];
			int i = 0;
			while (--n >= 0) {
				arr[i++] = reader.nextInt();
			}

			maxLen(arr, arr.length);
		}
	}

}
