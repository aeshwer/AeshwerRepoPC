package Md_Arrays;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;


public class MissingNumberInArray {
	
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
	}

	private static void resolveSum(int[] arr, int n) {
		int sum=0;
		int formulaSum = (n*(n-1))/2;
		for(int i =0; i<arr.length;i++) {
			sum+=arr[i];		}

		System.out.println(formulaSum-sum);
	}


	public static void main(String[] args) {
		FastReader fastReader = new FastReader();
		int cases = fastReader.nextInt();
		
		while(--cases>=0) {
			int n = fastReader.nextInt();
			int arr[] = new int[n];
			int i=0;
			n--;
			while(--n>=0) {
				arr[i++] = fastReader.nextInt();
			}
			
			resolveSum(arr,arr.length+1);
		}
	}
}
