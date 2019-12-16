package Md_Arrays;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Sort012 {

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

			implement012Algo(arr, arr.length);
			System.out.println();
		}

	}

	// O(n) solution
	private static void implement012Algo(int[] arr, int length) {

		int count0 = 0;
		int count1 = 0;
		int count2 = 0;
		for (int i = 0; i < length; i++) {
			switch (arr[i]) {
			case 0:
				count0++;
				break;
			case 1:
				count1++;
				break;
			default:
				count2++;
			}
		}

		while (--count0 >= 0 ) {
			System.out.print(0+" ");
			
		}
		while (--count1 >= 0 ) {
			System.out.print(1+" ");
		}
		while (--count2 >= 0 ) {
			System.out.print(2+" ");
		}

	}
}
