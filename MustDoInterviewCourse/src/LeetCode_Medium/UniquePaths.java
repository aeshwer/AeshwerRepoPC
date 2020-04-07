package LeetCode_Medium;

public class UniquePaths {

	public static int uniquePaths(int m, int n) {
		if (n == 1 && m == 1)
			return 1;

		int[][] temp = new int[m][n];
		// Fill Base case
		// first row and column all 1
		for (int i = 0; i < n; i++) {
			temp[0][i] = 1;
		}
		for (int i = 0; i < m; i++) {
			temp[i][0] = 1;
		}

		for (int i = 1; i < m; i++) {
			for (int j = 1; j < n; j++) {
				temp[i][j] = temp[i][j - 1] + temp[i - 1][j];
			}
		}

		return temp[m - 1][n - 1];
	}

	public static void main(String[] args) {
		System.out.println(uniquePaths(7, 3));
	}
}
