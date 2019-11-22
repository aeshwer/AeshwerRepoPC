package LatestProg;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Map;
import java.util.TreeMap;

public class PermuatatinoOfString {

	public static void permute(final char[] input) {

		final Map<Character, Integer> countMap = new TreeMap<>();
		for (final char ch : input) {
			countMap.compute(ch, (key, val) -> {
				if (val == null) {
					return 1;
				} else {
					return val + 1;
				}
			});
		}
		// System.out.println(map.toString());
		final char[] str = new char[countMap.size()];
		final int[] count = new int[countMap.size()];

		int index = 0;
		for (final Map.Entry<Character, Integer> entry : countMap.entrySet()) {
			str[index] = entry.getKey();
			count[index] = entry.getValue();
			index++;
		}

		System.out.println(Arrays.toString(str));
		System.out.println(Arrays.toString(count));
		final ArrayList<String> resultList = new ArrayList<>();
		final char[] result = new char[input.length];
		permuteUtil(str, count, result, 0, resultList);
		printRes(resultList);
	}

	private static void printRes(final ArrayList<String> resultList) {
		for (final String s : resultList) {
			System.out.println(s);
		}
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

	public static void main(final String[] args) {
		final String s = "AABC";
		permute(s.toCharArray());
	}
}
