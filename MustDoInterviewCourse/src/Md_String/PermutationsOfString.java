package Md_String;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Map;
import java.util.StringTokenizer;
import java.util.TreeMap;

public class PermutationsOfString {

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

	public static void main(String[] args) {
		FastReader fastReader = new FastReader();
		int cases = fastReader.nextInt();
		while (--cases >= 0) {
			String str = fastReader.nextLine();
			findPermuations(str.toCharArray());
			System.out.println();
		}

	}

	private static void findPermuations(char[] input) {
		// Count Freq
		Map<Character, Integer> countMap = new TreeMap<>();
		for (final char ch : input) {
			countMap.compute(ch, (key, val) -> {
				if (val == null) {
					return 1;
				} else {
					return val + 1;
				}
			});
		}

		final char[] str = new char[countMap.size()];
		final int[] count = new int[countMap.size()];

		int index = 0;
		for (final Map.Entry<Character, Integer> entry : countMap.entrySet()) {
			str[index] = entry.getKey();
			count[index] = entry.getValue();
			index++;
		}

		final ArrayList<String> resultList = new ArrayList<>();
		final char[] result = new char[input.length];
		permuteUtil(str, count, result, 0, resultList);
		printRes(resultList);
	}

	private static void permuteUtil(final char[] str, final int[] count, final char[] result, final int level,
			final ArrayList<String> resultList) {

		if (level == result.length) {
			resultList.add(new String(result));
			return;
		}
		for (int i = 0; i < str.length; i++) {
			if (count[i] == 0) {
				continue;
			} else {
				result[level] = str[i];
				count[i]--;
				permuteUtil(str, count, result, level + 1, resultList);
				count[i]++;
			}
		}
	}


	private static void printRes(ArrayList<String> resultList) {
		for (final String s : resultList) {
			System.out.print(s+" ");
		}
	}
}
