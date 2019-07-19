//https://www.geeksforgeeks.org/find-whether-path-two-cells-matrix/

package July18;

import java.util.Scanner;

public class WhetherPathExistsSolution {

	public static void isPathUtil(int matrix[][], int n) {
		// defining visited array to keep
		// track of already visited indexes
		boolean visited[][] = new boolean[n][n];

		// flag to indicate whether the path exists or not
		boolean flag = false;

		for (int i = 0; i < n; i++) {
			for (int j = 0; j < n; j++) {
				// if matrix[i][j] is source
				// and it is not visited
				if (matrix[i][j] == 1 && !visited[i][j])

					// starting from i, j and then finding the path
					if (isPath(matrix, i, j, visited)) {
						flag = true; // if path exists
						break;
					}
			}
		}
		if (flag)
			System.out.println("YES");
		else
			System.out.println("NO");
	}

	public static boolean isPath(int matrix[][], int i, int j, boolean visited[][]) {

		// checking the boundries, walls and
		// whether the cell is unvisited
		if (isSafe(i, j, matrix) && matrix[i][j] != 0 && !visited[i][j]) {
			// make the cell visited
			visited[i][j] = true;

			// if the cell is the required
			// destination then return true
			if (matrix[i][j] == 2)
				return true;

			// traverse up
			boolean up = isPath(matrix, i - 1, j, visited);

			// if path is found in up direction return true
			if (up)
				return true;

			// traverse left
			boolean left = isPath(matrix, i, j - 1, visited);

			// if path is found in left direction return true
			if (left)
				return true;

			// traverse down
			boolean down = isPath(matrix, i + 1, j, visited);

			// if path is found in down direction return true
			if (down)
				return true;

			// traverse right
			boolean right = isPath(matrix, i, j + 1, visited);

			// if path is found in right direction return true
			if (right)
				return true;
		}
		return false; // no path has been found
	}

	public static boolean isSafe(int i, int j, int matrix[][]) {

		if (i >= 0 && i < matrix.length && j >= 0 && j < matrix[0].length)
			return true;
		return false;
	}

	public static void main(String[] args) {
		Scanner s = new Scanner(System.in);
		int cases = s.nextInt();
		while (--cases >= 0) {
			int n = s.nextInt();
			int arr[][] = new int[n][n];

			int arr1[] = new int[n * n];
			int temp = n * n;
			int c = 0;
			while (--temp >= 0) {
				arr1[c++] = s.nextInt();
			}
			c = 0;
			for (int i = 0; i < n; i++) {
				for (int j = 0; j < n; j++) {
					arr[i][j] = arr1[c];
					c++;
				}
			}
			isPathUtil(arr, n);
		}

	}
}
