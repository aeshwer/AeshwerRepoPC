//https://www.geeksforgeeks.org/flood-fill-algorithm-implement-fill-paint/
package July20;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class FloodFillAlgoBufferReaderAsINput {

	private static boolean isNotSafe(Integer x, Integer y, Integer n, Integer m) {

		if (x < 0 || x >= n || y < 0 || y >= m) {
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
				System.out.print(arr[i][j] + " ");
			}
		}
	}

	public static void main(String[] args) throws IOException {

		BufferedReader read = new BufferedReader(new InputStreamReader(System.in));
		int cases = Integer.parseInt(read.readLine());

		while (--cases >= 0) {
			String inputLine1 = read.readLine();
			int n = Integer.parseInt(inputLine1.substring(0, 1));
			int m = Integer.parseInt(inputLine1.substring(2, 3));
			int arr[][] = new int[n][m];

			String[] inputLine2 = read.readLine().split(" ");

				int c=0;
				for (int i = 0; i < n; i++) {
					for (int j = 0; j < m; j++) {
						arr[i][j] = Integer.parseInt(inputLine2[c]);
						c++;
					}
			}

			String inputLine3 = read.readLine();
			int x = Integer.parseInt(inputLine3.substring(0, 1));
			int y = Integer.parseInt(inputLine3.substring(2, 3));
			int k = Integer.parseInt(inputLine3.substring(4, 5));

			floodFill(arr, x, y, k, n, m);
			System.out.println();

		}
	}
}
