//https://practice.geeksforgeeks.org/problems/longest-distinct-characters-in-string/0/?track=md-string&batchId=144
/*
Input:
2
abababcdefababcdab
geeksforgeeks

Output:
6
7
 */
package Md_String;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashSet;
import java.util.Set;
import java.util.StringTokenizer;

public class LongestDistinctCharacterOfString {
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

	private static int longestDistinctCharacter(String str, int i) {
		if (i == str.length())
			return 0;
		int count = 0;
		Set<Character> set = new HashSet<Character>();
		for (int j = i; j < str.length(); j++) {
			if (!set.contains(str.charAt(j))) {
				set.add(str.charAt(j));
				count++;
			} else
				break;
		}
		return Integer.max(count, longestDistinctCharacter(str, i + 1));
	}

	public static void main(String[] args) {

		FastReader fastReader = new FastReader();
		int cases = fastReader.nextInt();

		while (--cases >= 0) {
			String s1 = fastReader.nextLine();
			System.out.println(longestDistinctCharacter(s1, 0));
			System.out.println(longestDistCharOptimized(s1));
		}

	}

	// Sliding Window concept
	private static int longestDistCharOptimized(String s) {
		if (s.length() == 0)
			return 0;
		int l = 0, r = 1, max = 1;
		HashSet<Character> hset = new HashSet<>();
		hset.add(s.charAt(l));
		while (r < s.length()) {
			while (hset.contains(s.charAt(r))) {
				hset.remove(s.charAt(l));
				l++;
			}
			hset.add(s.charAt(r));
			r++;
			max = Math.max(max, r - l);
		}
		return max;
	}

}
