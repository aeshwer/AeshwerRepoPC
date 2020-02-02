package Md_DynamicProg;

public class PalindrimePartition {

	public static void main(String[] args) {
		String str = "abcbm";
		findNumberOfSplitsToMakePalindrome(str.toCharArray());
	}

	private static void findNumberOfSplitsToMakePalindrome(char[] arr) {

		int T[][] = new int[arr.length][arr.length];

		// Fill Bases Case = diagonals = 0 (default in Java) -> Length = 1

		// Solve for Length>1
		for (int l = 2; l <= arr.length; l++) {
			for (int i = 0; i < arr.length - l + 1; i++) {
				int j = i + l - 1;
				if (arr[i] != arr[j]) {
					T[i][j] = Integer.MAX_VALUE - 1;
					for (int k = 0; k < j; k++) {
						T[i][j] = Math.min(T[i][j], (1 + T[i][k] + T[k + 1][j]));
					}
				}

			}
		}

		System.out.println("Total Partition needed to make Palindrome Are : " + T[0][arr.length-1]);
	}
}
