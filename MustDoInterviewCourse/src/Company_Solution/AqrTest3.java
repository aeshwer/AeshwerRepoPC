package Company_Solution;

public class AqrTest3 {

	static int zombieClusters(int[][] zombies) {
		if (zombies == null || zombies.length == 0) {
			return 0;
		}
		int numOfCluster = 0;
		int rows = zombies.length;
		int cols = zombies[0].length;
		for (int i = 0; i < zombies.length; i++) {
			for (int j = 0; j < zombies[i].length; j++) {
				if (i == j && zombies[i][j] == 1) {
					numOfCluster = numOfCluster + zombieClustersUtil(zombies, i, rows, cols);
				}
			}
		}

		return numOfCluster;

	}

	static int zombieClustersUtil(int[][] grid, int diagonal, int rows, int cols) {
		if (diagonal > rows - 1 || diagonal < 0 || diagonal < 0 || diagonal > cols - 1) {
			return 0;
		}

		if (grid[diagonal][diagonal] == 0) {
			return 0;
		}

		grid[diagonal][diagonal] = 0;

		for (int k = 0; k < cols; k++) {
			if (grid[diagonal][k] == 1) {
				grid[diagonal][k] = 0;
				grid[k][diagonal] = 0;
				zombieClustersUtil(grid, k, rows, cols);
			}
		}
		return 1;

	}

	public static void main(String[] args) {

	}
}
