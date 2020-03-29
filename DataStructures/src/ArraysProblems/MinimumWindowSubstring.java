package ArraysProblems;

import java.util.HashMap;

//https://leetcode.com/problems/minimum-window-substring/
public class MinimumWindowSubstring {

	public static String minWindow(String s, String t) {

		if (s == null || s.length() < t.length() || s.length() == 0) {
			return "";
		}
		HashMap<Character, Integer> patternLookup = new HashMap<Character, Integer>();
		for (char c : t.toCharArray()) {
			if (patternLookup.containsKey(c)) {
				patternLookup.put(c, patternLookup.get(c) + 1);
			} else {
				patternLookup.put(c, 1);
			}
		}
		int left = 0;
		int minLeft = 0;
		int minLen = s.length();
		int count = 0;

		for (int right = 0; right < s.length(); right++) {
			if (patternLookup.containsKey(s.charAt(right))) {
				patternLookup.put(s.charAt(right), patternLookup.get(s.charAt(right)) - 1);
				if (patternLookup.get(s.charAt(right)) >= 0) {
					count++;
				}
				while (count == t.length()) {
					if (right - left  < minLen) {
						minLeft = left;
						minLen = right - left + 1;
					}
					if (patternLookup.containsKey(s.charAt(left))) {
						patternLookup.put(s.charAt(left), patternLookup.get(s.charAt(left)) + 1);
						if (patternLookup.get(s.charAt(left)) > 0) {
							count--;
						}
					}
					left++;
				}
			}
		}

		if (minLen > s.length()) {
			return "";
		}

		return s.substring(minLeft, minLeft + minLen);

	}

	public static void main(String[] args) {
		System.out.println(minWindow("ADOBECODEBANC", "ABC"));
	}
}
