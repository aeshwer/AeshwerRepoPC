package LatestProg;

import java.util.Arrays;

//O(n+m)
public class KMPPatternMatchingAlogrithm {

	public static void main(String[] args) {
		String s1 = "dsgwadsgz";
		String s2 = "dsgwadsgz";
		isMatchingPattern(s1.toCharArray(), s2.toCharArray());
	}

	private static void isMatchingPattern(char[] inputString, char[] pattern) {

		// Make Suffix Prefix Array O(n)
		int count[] = new int[pattern.length];
		count[0] = 0;

		int i = 0;
		for (int j = 1; j < pattern.length; j++) {
			if (pattern[j] == pattern[i]) {
				count[j] = i + 1;
				i++;
			} else {
				count[j] = i - 1 > 0 ? count[i - 1] : 0;
			}

		}

		i = 0;
		int j = 0;
		while (i < inputString.length && j < pattern.length) {
			if (inputString[i] == pattern[j]) {
				i++;
				j++;
			} else {
				if (j != 0) {
					j = count[j - 1];
				} else {
					i++;
				}

			}

		}

		if (j == pattern.length) {
			System.out.println("Substring Pattern Matched");
		} else {
			System.out.println("Substring Pattern Not Matched");
		}

	}
}
