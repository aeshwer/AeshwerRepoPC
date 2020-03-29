package March28;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

//https://leetcode.com/problems/letter-combinations-of-a-phone-number/
public class LetterCombinationOfPhoneNumber {

	public static List<String> letterCombinations(String digits) {

		List<String> res = new ArrayList<String>();
		if (digits == null || digits.length() == 0) {
			return res;
		}

		String[] mappings = { "0", "1", "abc", "def", "ghi", "jkl", "mno", "pqrs", "tuv", "wxyz" };

		letterCombinationsUtil(res, digits, "", 0, mappings);
		return res;
	}

	private static void letterCombinationsUtil(List<String> res, String digits, String current, int index,
			String[] mappings) {
		if (digits.length() == index) {
			res.add(current);
			return;
		} else {
			String letters = mappings[digits.charAt(index) - '0'];
			for (int i = 0; i < letters.length(); i++) {
				letterCombinationsUtil(res, digits, current + letters.charAt(i), index + 1, mappings);
			}
		}

	}

	public static void main(String[] args) {
		List<String> letterCombinations = letterCombinations("23");
		letterCombinations.forEach(v -> System.out.println(v));
	}
}
