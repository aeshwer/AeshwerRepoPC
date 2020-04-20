package LeetCode_Medium;

//https://leetcode.com/problems/decode-ways/
public class DecodeWays {

	public static int numDecodings(String s) {
		if (s == null || s.length() == 0) {
			return 0;
		}

		int n = s.length();
		int[] T = new int[n + 1];
		T[0] = 1; // denoting that for empty string there is only one way to decode
		T[1] = s.charAt(0) != '0' ? 1 : 0;

		for (int i = 2; i <= n; i++) {
			// check one and two digit combination now
			int first = Integer.valueOf(s.substring(i - 1, i));
			int second = Integer.valueOf(s.substring(i - 2, i));
			if (first >= 1 && first <= 9) {
				T[i] = T[i] + T[i - 1];
			}
			if (second >= 10 && second <= 26) {
				T[i] = T[i] + T[i - 2];
			}
		}
		return T[n];
	}

	public static void main(String[] args) {
		System.out.println(numDecodings("1214"));
	}
}
