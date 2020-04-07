package LeetCode_Medium;

public class UniquePaths2 {

	public static int uniquePathsWithObstacles(int[][] obstacleGrid) {

		int m = obstacleGrid.length;
		int n = obstacleGrid[0].length;

		if (obstacleGrid[m - 1][n - 1] == 1 || obstacleGrid[0][0] == 1)
			return 0;
		if (n == 1 && m == 1)
			return 1;

		int[][] temp = new int[m][n];
		temp[0][0] = 1;
		// Fill Base case
		// first row and column all 1 considering obstacle
		for (int i = 1; i < n; i++) {
			if (obstacleGrid[0][i] == 1) {
				temp[0][i] = 0;
			} else {
				temp[0][i] = temp[0][i - 1];
			}
		}

		for (int i = 1; i < m; i++) {
			if (obstacleGrid[i][0] == 1) {
				temp[i][0] = 0;
			} else {
				temp[i][0] = temp[i - 1][0];
			}
		}

		// Logic
		for (int i = 1; i < m; i++) {
			for (int j = 1; j < n; j++) {
				if (obstacleGrid[i][j] == 1) {
					temp[i][j] = 0;
				} else {
					temp[i][j] = temp[i][j - 1] + temp[i - 1][j];
				}
			}
		}

		return temp[m - 1][n - 1];

	}

	public static void main(String[] args) {
		//int[][] arr = { { 0, 0, 0 }, { 0, 1, 0 }, { 0, 0, 0 } };
		int[][] arr = { { 0 }, { 0} };
		System.out.println(uniquePathsWithObstacles(arr));
	}
}

