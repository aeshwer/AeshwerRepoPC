package LeetCode_Medium;

import java.util.HashMap;
import java.util.Map;

//https://leetcode.com/problems/longest-substring-without-repeating-characters/
public class LongestSubstringWithoutRepeatingCharacters {

	public static int lengthOfLongestSubstring(String s) {

		if (s == null)
			return 0;
		if (s.length() == 1)
			return 1;

		char[] input = s.toCharArray();
		Map<Character, Integer> lookup = new HashMap<>();
		int start = 0;
		int maxLength = 0;

		for (int i = 0; i < input.length; i++) {

			if (!lookup.containsKey(input[i])) {
				lookup.put(input[i], i);
			} else {
				start = Math.max(start, lookup.get(input[i]) + 1);
				lookup.put(input[i], i);
			}
			maxLength = Math.max(maxLength, i - start + 1);

		}

		return maxLength;

	}

	public static void main(String[] args) {
		System.out.println(lengthOfLongestSubstring("abba"));// 3
	}
}
