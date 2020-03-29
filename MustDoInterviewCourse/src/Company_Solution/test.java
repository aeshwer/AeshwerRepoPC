package Company_Solution;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class test {

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

	private static void checkSolution(String s1, String s2) {

		int k = 0;
		int j = 0;
		char[] charArray1 = s1.toCharArray();
		char[] charArray2 = s2.toCharArray();

		Arrays.sort(charArray1);
		Arrays.sort(charArray2);

		String str1 = String.valueOf(charArray1).toUpperCase();
		String str2 = String.valueOf(charArray2).toUpperCase();

		for (int i = 0; i < str1.length(); i++) {

			if ((str1.charAt(i) >= str2.charAt(i)) && k == 0) {
				j++;
			} else if ((str1.charAt(i) <= str2.charAt(i)) && j == 0) {
				k++;
			} else {
				System.out.println("false");
				break;
			}
		}
		if (j == str1.length() || k == str2.length())
			System.out.println("true");

	}

	public static void main(String args[]) throws Exception {
		FastReader fastReader = new FastReader();

		String s1 = fastReader.next();
		String s2 = fastReader.next();

		checkSolution(s1, s2);
		System.out.println();
	}

}
