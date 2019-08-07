package Md_Hash;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedHashMap;
import java.util.StringTokenizer;

public class ZeroSumSubArrayCount {

	public static class FastReader {

		private BufferedReader reader;
		private StringTokenizer token;

		public FastReader() {
			reader = new BufferedReader(new InputStreamReader(System.in));
		}

		Integer nextInt() {
			return Integer.parseInt(next());
		}

		private String next() {
			while (null == token || !token.hasMoreElements()) {
				try {
					token = new StringTokenizer(reader.readLine());
				} catch (IOException e) {
					e.printStackTrace();
				}
			}
			return token.nextToken();
		}

		private String nextLine() {
			String str = "";
			try {
				str = reader.readLine();
			} catch (IOException e) {
				e.printStackTrace();
			}
			return str;

		}

	}

	private static void checkZeroSubArraySum(int[] arr) {
		int count = 0;
		int sum = 0;
		LinkedHashMap<Integer, Integer> lookup = new LinkedHashMap<>();
		lookup.put(0, 1);
		for (int i = 0; i < arr.length; i++) {
			sum = sum + arr[i];
			
			if(lookup.containsKey(sum)==true)
	          {
				int num=lookup.get(sum);
	              count=count+num;
	              lookup.put(sum,num+1);
	          }
	          else
	          {
	        	  lookup.put(sum,1);
	          }

		}

		System.out.println(count);

	}

	public static void main(String[] args) {

		FastReader fastReader = new FastReader();
		int cases = fastReader.nextInt();

		while (--cases >= 0) {
			Integer n = fastReader.nextInt();
			int arr[] = new int[n];
			int i = 0;
			while (--n >= 0) {
				arr[i++] = fastReader.nextInt();
			}
			checkZeroSubArraySum(arr);
		}
	}

}
