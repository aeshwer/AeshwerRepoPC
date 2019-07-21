//https://www.geeksforgeeks.org/flood-fill-algorithm-implement-fill-paint/
//covering diagonals and avoiding repeated recursion
package July20;

import java.util.Scanner;

public class FloodFillAlgoWithCoveringDiagonals {

	private static boolean isNotSafe(Integer x, Integer y, Integer n, Integer m) {

		if (x < 0 || x >= n || y < 0 || y >= m) {
			return true;
		}
		return false;

	}

	private static void floodFillUtil(int[][] arr, Integer x, Integer y, int prevC, int newC, Integer n, Integer m,
			boolean[][] visited) {

		if (isNotSafe(x, y, n, m) || doRecursion(visited, x, y)) {
			return;
		}

		/*if (arr[x][y] != prevC) {
			return;
		}
*/
		arr[x][y] = newC;
		visited[x][y] = true;

		if(x<n-1 && arr[x+1][y]==prevC)floodFillUtil(arr, x + 1, y, prevC, newC, n, m, visited);
		if(y<m-1 && arr[x][y+1]==prevC)floodFillUtil(arr, x, y + 1, prevC, newC, n, m, visited);
		if(x>0 && arr[x-1][y]==prevC)floodFillUtil(arr, x - 1, y, prevC, newC, n, m, visited);
		if(y>0 && arr[x][y-1]==prevC)floodFillUtil(arr, x, y - 1, prevC, newC, n, m, visited);
		
		if(x<n-1 && y<m-1 && arr[x+1][y+1]==prevC)floodFillUtil(arr, x + 1, y + 1, prevC, newC, n, m, visited);
		if(x>0 &&  y>0 &&  arr[x-1][y-1]==prevC)floodFillUtil(arr, x - 1, y - 1, prevC, newC, n, m, visited);
		if(y>0 &&  x<n-1 && arr[x+1][y-1]==prevC)floodFillUtil(arr, x + 1, y - 1, prevC, newC, n, m, visited);
		if(x>0 && y<m-1 && arr[x-1][y+1]==prevC)floodFillUtil(arr, x - 1, y + 1, prevC, newC, n, m, visited);

	}

	private static boolean doRecursion(boolean[][] visited, int x, int y) {
		return visited[x][y];

	}

	// It mainly finds the previous color on (x, y) and calls floodFillUtil()
	static void floodFill(int arr[][], int x, int y, int newC, int n, int m) {
		int prevC = arr[x][y];
		boolean visited[][] = new boolean[n][m];
		floodFillUtil(arr, x, y, prevC, newC, n, m, visited);

		for (int i = 0; i < n; i++) {
			for (int j = 0; j < m; j++) {
				System.out.print(arr[i][j] + " ");
			}
		}
	}

	public static void main(String[] args) {

		Scanner s = new Scanner(System.in);
		int cases = s.nextInt();

		while (--cases >= 0) {
			int n = s.nextInt();
			int m = s.nextInt();
			int arr[][] = new int[n][m];

			for (int i = 0; i < n; i++) {
				for (int j = 0; j < m; j++) {
					arr[i][j] = s.nextInt();
				}
			}

			int x = s.nextInt();
			int y = s.nextInt();
			int k = s.nextInt();

			floodFill(arr, x, y, k, n, m);
			System.out.println();

		}
	}
}
