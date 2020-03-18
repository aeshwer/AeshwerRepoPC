package Md_Graph;

//https://leetcode.com/problems/number-of-islands/
public class FindNumberOfIslands {

	public static void main(String[] args) {
		char[][] grid = { { '1', '1', '0', '0', '0' }, { '1', '1', '0', '0', '0' }, { '0', '0', '1', '0', '0' },
				{ '0', '0', '0', '1', '1' } };
		System.out.println(numIslands(grid));

	}

	public static int numIslands(char[][] grid) {
		if (grid == null || grid.length == 0) {
			return 0;
		}
		int numOfLands = 0;
		int rows = grid.length;
		int cols = grid[0].length;
		for (int i = 0; i < grid.length; i++) {
			for (int j = 0; j < grid[i].length; j++) {
				if (grid[i][j] == '1') {

					numOfLands = numOfLands + dsfUtilToSinkTheIsland(grid, i, j, rows, cols);
				}
			}
		}

		return numOfLands;

	}

	private static int dsfUtilToSinkTheIsland(char[][] grid, int i, int j, int rows, int cols) {
		if (i > rows-1 || i < 0 || j < 0 || j > cols-1) {
			return 0;
		}
		if (grid[i][j] == '0') {
			return 0;
		}
		grid[i][j] = '0';
		dsfUtilToSinkTheIsland(grid, i + 1, j, rows, cols);
		dsfUtilToSinkTheIsland(grid, i, j + 1, rows, cols);
		dsfUtilToSinkTheIsland(grid, i - 1, j, rows, cols);
		dsfUtilToSinkTheIsland(grid, i, j - 1, rows, cols);
		return 1;

	}
}
