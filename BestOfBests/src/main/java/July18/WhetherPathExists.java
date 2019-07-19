//https://www.geeksforgeeks.org/find-whether-path-two-cells-matrix/

package July18;

import java.util.Arrays;
import java.util.Scanner;

public class WhetherPathExists {

	public static class Pivot {
		private int j;
		private int i;

		public Pivot(int i, int j) {
			this.i = i;
			this.j = j;
		}
	}

	private static boolean isSafe(int i, int j, int n) {
		if (i > n || j > n || i < 0 || j < 0) {
			return false;
		}
		return true;
	}

	private static int resolvePath(int[][] arr, Pivot source, Pivot next, int n) {
		/*
		 * for (int i = source.i; i < n; i++) { for (int j = source.j; j < n; j++) {
		 * 
		 * } } return false;
		 */

		if (arr[next.i][next.j] == 2) {
			return 1;
		}

		if (isSafe(source.i + 1, source.j, n)) {
			resolvePath(arr, source, new Pivot(source.i + 1, source.j), n);
		}
		if (isSafe(source.i, source.j + 1, n)) {
			resolvePath(arr, source, new Pivot(source.i, source.j + 1), n);
		}
		if (isSafe(source.i - 1, source.j, n)) {
			resolvePath(arr, source, new Pivot(source.i - 1, source.j), n);
		}
		if (isSafe(source.i, source.j - 1, n)) {
			resolvePath(arr, source, new Pivot(source.i, source.j - 1), n);
		}

		return 0;

	}

	public static void main(String[] args) {
		Scanner s = new Scanner(System.in);
		Pivot source = null;
		Pivot destination = null;
		int cases = s.nextInt();
		while (--cases >= 0) {
			int n = s.nextInt();
			int arr[][] = new int[n][n];

			for (int i = 0; i < n; i++) {
				for (int j = 0; j < n; j++) {
					arr[i][j] = s.nextInt();
					if (arr[i][j] == 1) {
						source = new Pivot(i, j);

					}
				}
			}
			int res = resolvePath(arr, source, source, n);
			System.out.println(res);
		}
	}
}
