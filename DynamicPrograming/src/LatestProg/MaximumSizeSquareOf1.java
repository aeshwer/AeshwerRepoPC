package LatestProg;

import java.util.Arrays;

public class MaximumSizeSquareOf1 {

	public static void main(String[] args) {
		int arr[][] = { { 0, 0, 1, 1, 1 }, { 1, 0, 1, 1, 1 }, { 1, 1, 1, 1, 1 }, { 1, 1, 1, 0, 1 } };
		int result = maxSize(arr);
		System.out.print(result);
	}

	private static int maxSize(int[][] arr) {
		int row = arr.length + 1;
		int col = arr[0].length + 1;
		int result =0;
		int t[][] = new int[row][col];

		// fill base case 1st row and column
		//done automatically by defaulting all entry to zero 
		/*for (int i = 0; i < col; i++) {
			t[0][i] = 0;
		}
		for (int i = 0; i < row; i++) {
			t[i][0] = 0;
		}*/

		// fill matrix as per formula
		for (int i = 1; i < row; i++) {
			for (int j = 1; j < col; j++) {
				if (arr[i-1][j-1] == 0) {
					t[i][j] = 0;
				} else {
					t[i][j] = 1+Math.min(Math.min(t[i - 1][j], t[i][j - 1]), t[i - 1][j - 1]);
				}
				result =Math.max(t[i][j], result);

			}
		}

		return result;
	}
}
