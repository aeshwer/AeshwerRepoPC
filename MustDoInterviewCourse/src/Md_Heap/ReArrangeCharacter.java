//https://practice.geeksforgeeks.org/problems/rearrange-characters/0/?track=md-heap&batchId=144
package Md_Heap;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.Map;
import java.util.StringTokenizer;

public class ReArrangeCharacter {

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

	private static void reArrangeCharacter(String str) {
		int length = str.length();
		Map<Character, Integer> lookup = new HashMap<>();

		for (int i = 0; i < length; i++) {
			if (lookup.containsKey(str.charAt(i))) {
				lookup.put(str.charAt(i), lookup.get(str.charAt(i)) + 1);
			} else {
				lookup.put(str.charAt(i), 1);

			}
		}
		int maxFreq = 0;
		for (Integer value : lookup.values()) {
			maxFreq = Math.max(maxFreq, value);
		}
		
		if(2*maxFreq - length < 1) {
			System.out.println(1);
		}
		else {
			System.out.println(0);
		}

	}

	public static void main(String[] args) {

		FastReader fastReader = new FastReader();
		int cases = fastReader.nextInt();

		while (--cases >= 0) {
			String s1 = fastReader.next();
			reArrangeCharacter(s1);
		}
	}

}
