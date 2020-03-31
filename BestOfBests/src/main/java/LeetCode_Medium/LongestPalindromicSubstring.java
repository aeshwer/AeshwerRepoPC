package LeetCode_Medium;

public class LongestPalindromicSubstring {

	public static String longestPalindrome(String s) {
		if(s == null || s.length()==1 ||s.equals("")) return s;
		int start = 0;
		int end = 0;
		// For each mid point i, use two points (left, right) to check the values on i's
		// left and right sides respectively.
		for (int i = 0; i < s.length(); i++) {
			if (end - start == s.length())
				break;
			char c = s.charAt(i);
			int left = i;
			int right = i;

			while (left >= 0 && s.charAt(left) == c) {
				left--;
			}

			while (right < s.length() && s.charAt(right) == c) {
				right++;
			}

			while (left >= 0 && right < s.length()) {
				if (s.charAt(left) != s.charAt(right)) {
					break;
				}
				left--;
				right++;
			}

			// left + 1 and right - 1 are actually the start and end index of the
			// Palindromic string
			if (end - start < right - left + 1) {
				start = left;
				end = right;
			}
		}

		return s.substring(start + 1, end); // because String.substring function required end index exclusively
	}

	public static void main(String[] args) {
		System.out.println(longestPalindrome(""));
	}
}
