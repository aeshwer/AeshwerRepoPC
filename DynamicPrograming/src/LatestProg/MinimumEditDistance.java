package LatestProg;

public class MinimumEditDistance {

	public static void main(String[] args) {
		String str1 = "azced";
		String str2 = "abcdef";
		int result = dynamicEditDistance(str1.toCharArray(), str2.toCharArray());
		System.out.print(result);
	}

	private static int dynamicEditDistance(char[] s1, char[] s2) {
		int t[][] = new int[s1.length + 1][s2.length + 1];

		// populate base case column
		for (int i = 0; i < s1.length+1; i++) {
			t[i][0] = i;

		}
		// populate base case row
		for (int i = 1; i < s2.length+1; i++) {
			t[0][i] = i;
		}

		// as per formula
		for (int i = 1; i < s1.length + 1; i++) {
			for (int j = 1; j < s2.length + 1; j++) {
				if (s1[i-1] == s2[j-1]) {
					t[i][j] = t[i - 1][j - 1];
				} else {
					t[i][j] = Math.min(Math.min(t[i - 1][j - 1], t[i - 1][j]), t[i][j - 1])+1;
				}
			}
		}
		
		
		return t[s1.length][s1.length];
	}
}
