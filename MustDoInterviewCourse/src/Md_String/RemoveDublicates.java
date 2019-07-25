//https://practice.geeksforgeeks.org/problems/remove-duplicates/0/?track=md-string&batchId=144
package Md_String;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.Map;
import java.util.StringTokenizer;

public class RemoveDublicates {

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
			while (token == null || !token.hasMoreElements()) {
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

	private static void removeDuplicates(String s1) {
		//Can also do the same using HashSet.
		Map<Character,Integer> lookup = new HashMap<>();
		
		for(int i=0;i<s1.length();i++) {
			if(!lookup.containsKey(s1.charAt(i))) {
				lookup.put(s1.charAt(i), 1);
				System.out.print(s1.charAt(i));
			}
			else {
				continue;
			}
		}

	}

	public static void main(String[] args) {

		FastReader fastReader = new FastReader();
		int cases = fastReader.nextInt();

		while (--cases >= 0) {
			String s1 = fastReader.nextLine();
			removeDuplicates(s1);
			System.out.println();
		}

	}
}
