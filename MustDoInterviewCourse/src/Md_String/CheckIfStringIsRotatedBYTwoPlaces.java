package Md_String;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class CheckIfStringIsRotatedBYTwoPlaces {

	static class FastReader {

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
			String s1 = fastReader.nextLine();
			String s2 = fastReader.nextLine();

			findSolution(s1, s2);
		}
	}

	private static void findSolution(String s1, String s2) {
		String frontRotate = s1.substring(2, s1.length()) + s1.substring(0, 2);
		String backRotate = s1.substring(s1.length() - 2, s1.length()) + s1.substring(0, s1.length() - 2);

		if (s2.equals(frontRotate) || s2.equals(backRotate)) {
			System.out.println(1);
		} else {
			System.out.println(0);
		}

	}
}
