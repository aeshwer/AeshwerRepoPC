package Md_Hash;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.Map;
import java.util.StringTokenizer;

public class SmallestWindowInAStringContaingAllCharOfTherString {

	static class FastReader {

		BufferedReader reader;
		StringTokenizer token;

		FastReader() {
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
			String str1 = fastReader.nextLine();
			String str2 = fastReader.nextLine();
			checkPattern(str1, str2);
		}
	}

	private static void checkPattern(String str1, String str2) {
		char[] s1 = str1.toCharArray();
		char[] s2 = str2.toCharArray();
		Map<Character, Integer> lookup = new HashMap<>();
		for (char value : s2) {
			if (!lookup.containsKey(value)) {
				lookup.put(value, 1);
			} else {
				lookup.put(value, lookup.get(value) + 1);
			}
		}
		// Get first Match element
		int i = 0;
		int count = s2.length;
		for (i = 0; i < s1.length; i++) {
			if (lookup.containsKey(s2[i])) {
				lookup.put(s1[i], lookup.get(s2[i]) - 1);
				count--;
				i++;
				break;
			}
		}

		int startIndex = i;
		int head = i - 1;
		int tail = 0;
		int minlength = Integer.MAX_VALUE;
		for (; i < s1.length; i++) {
			if (lookup.containsKey(s1[i])) {
				lookup.put(s1[i], lookup.get(s1[i]) - 1);
				if (lookup.get(s1[i]) >= 0) {
					count--;
				}
			}
			if (count == 0) {
				tail = i;
				// capture relevant solution
				if (minlength > (i - head + 1)) {
					minlength = i - head + 1;
				}
				// move the window now
				while (count == 0) {
					if (!lookup.containsKey(s1[head])) {
						head++;
					} else if (lookup.containsKey(s1[head]) && lookup.get(s1[head]) < 0) {
						lookup.put(s1[head], lookup.get(s1[head]) + 1);
						head++;
					} else {
						minlength = i - head + 1;
						lookup.put(s1[head], lookup.get(s1[head]) + 1);
						head++;
						count++;
					}
				}
			}
		}
		if (tail == 0) {
			System.out.println(-1);
		} else {
			for (int j = head - 1; j <= tail; j++) {
				System.out.print(s1[j] + " ");
			}
		}

	}

}
