package Md_Arrays;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.Map;
import java.util.StringTokenizer;

public class MajorityElement {

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

	private static void resolveMajorityElement(int[] arr) {
		boolean noOutput=true;
		int n = arr.length/2;
		Map<Integer,Integer> lookup = new HashMap<>();
		for (int i = 0; i < arr.length; i++) {
			if(!lookup.containsKey(arr[i])) {
				lookup.put(arr[i],1);
			}
			else {
				Integer value = lookup.get(arr[i]);
				lookup.put(arr[i],value+1);
				if(value+1>n) 
				{
					System.out.println(arr[i]);
					noOutput=false;
					break;
				}
			}
		}
		
		if(noOutput)
		System.out.println(-1);

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

			resolveMajorityElement(arr);
		}
	}

}
