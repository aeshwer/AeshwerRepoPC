//https://practice.geeksforgeeks.org/problems/reverse-words-in-a-given-string/0/?track=md-string&batchId=144
package Md_String;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class ReverseWordsInAString {

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

	private static void reverseWordsInAString(String s1) {
		s1 = s1.replace(".", " ");
		String[] split = s1.split(" ");

		for (int i = split.length - 1; i > 0; i--) {
			System.out.print(split[i] + ".");
		}

		System.out.print(split[0]);
	}

	public static void main(String[] args) {
		FastReader fastReader = new FastReader();
		int cases = fastReader.nextInt();

		while (--cases >= 0) {
			String s1 = fastReader.nextLine();
			reverseWordsInAString(s1);
			System.out.println();
		}

	}

}
