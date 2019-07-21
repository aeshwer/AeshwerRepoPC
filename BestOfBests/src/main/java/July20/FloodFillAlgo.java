//https://www.geeksforgeeks.org/flood-fill-algorithm-implement-fill-paint/
package July20;

import java.util.Scanner;

public class FloodFillAlgo {
	
	private static boolean isNotSafe(Integer x,Integer y,Integer n ,Integer m){
		
		if (x<0 || x>=n || y<0 || y>=m) {
			return true;
		}
		return false;
		
	}

	private static void floodFillUtil(int[][] arr, Integer x, Integer y, int prevC, int newC, Integer n, Integer m) {

		
		if (isNotSafe(x, y, n, m)) {
			return;
		}

		if (arr[x][y] != prevC) {
			return;
		}

		arr[x][y] = newC;

		floodFillUtil(arr, x + 1, y, prevC, newC, n, m);
		floodFillUtil(arr, x, y + 1, prevC, newC, n, m);
		floodFillUtil(arr, x - 1, y, prevC, newC, n, m);
		floodFillUtil(arr, x, y - 1, prevC, newC, n, m);

	}

	// It mainly finds the previous color on (x, y) and calls floodFillUtil()
	static void floodFill(int arr[][], int x, int y, int newC, int n, int m) {
		int prevC = arr[x][y];
		floodFillUtil(arr, x, y, prevC, newC, n, m);

		for (int i = 0; i < n; i++) {
			for (int j = 0; j < m; j++) {
				System.out.print(arr[i][j]+ " ");
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
					arr[i][j]=s.nextInt();
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
