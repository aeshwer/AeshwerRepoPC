package Company_Solution;

public class jobshop3 {

	public static int solution(int[][] A) {

		if (A == null || A.length == 0) {
			return 0;
		}
		int numOfLands = 0;
		int rows = A.length;
		int cols = A[0].length;
		for (int i = 0; i < A.length; i++) {
			for (int j = 0; j < A[i].length; j++) {
				if (A[i][j] != Integer.MAX_VALUE) {
					numOfLands = numOfLands + dsfUtilToSinkTheCountry(A, i, j, rows, cols, A[i][j]);
				}
			}
		}

		return numOfLands;
	}

	private static int dsfUtilToSinkTheCountry(int[][] grid, int i, int j, int rows, int cols, int color) {
		if (i > rows - 1 || i < 0 || j < 0 || j > cols - 1) {
			return 0;
		}
		if (grid[i][j] == Integer.MAX_VALUE || grid[i][j] != color) {
			return 0;
		}
		grid[i][j] = Integer.MAX_VALUE;
		dsfUtilToSinkTheCountry(grid, i + 1, j, rows, cols, color);
		dsfUtilToSinkTheCountry(grid, i, j + 1, rows, cols, color);
		dsfUtilToSinkTheCountry(grid, i - 1, j, rows, cols, color);
		dsfUtilToSinkTheCountry(grid, i, j - 1, rows, cols, color);
		return 1;

	}

	public static void main(String[] args) {
		int[][] arr = { { 1, 1, 1 }, { 1, 1, 1 }, { 1, 1, 1 }, { 1, 1, 1 }, { 1, 1, 1 }, { 1, 1, 1 }, { 1, 1, 1 } };
		System.out.println(solution(arr));
	}

}
