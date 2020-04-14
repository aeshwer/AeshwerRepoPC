package LeetCode_Medium;

import java.util.Arrays;

//https://leetcode.com/problems/set-matrix-zeroes/discuss/26014/Any-shorter-O(1)-space-solution
/*
 * My idea is simple: store states of each row in the first of that row, and store states of each column 
 * in the first of that column. Because the state of row0 and the state of column0 would occupy the same cell,
 *  I let it be the state of row0, and use another variable "col0" for column0. In the first phase, use matrix elements to
 *  set states in a top-down way. In the second phase, use states to set matrix elements in a bottom-up way.
 */

/*
 * I think what Chen tries to do is to store information at the first element of each columns and rows.
 *  If a column contains a 0, it's first element will be 0. Same for rows. However, both first column and first row
 *   use matrix[0][0] which is problematic so she creates another variable for first column, col0.
 *	Finally, start setting zeros from the bottom right corner.
 */
public class SetZeros {

	public static void setZeroes(int[][] matrix) {
		int col0 = 1;
		int rows = matrix.length;
		int cols = matrix[0].length;

		// Top down
		for (int i = 0; i < rows; i++) {
			// specically for first column
			if (matrix[i][0] == 0)
				col0 = 0;
			// for other row and column
			for (int j = 1; j < cols; j++)
				if (matrix[i][j] == 0)
					matrix[i][0] = matrix[0][j] = 0;
		}
		// Bottom up
		// set the matrix on basic of first elemnt of row and columns
		for (int i = rows - 1; i >= 0; i--) {
			for (int j = cols - 1; j >= 1; j--) {
				if (matrix[i][0] == 0 || matrix[0][j] == 0)
					matrix[i][j] = 0;
			}
			if (col0 == 0)
				matrix[i][0] = 0;
		}
		System.out.println(Arrays.deepToString(matrix));
	}

	public static void main(String[] args) {
		int[][] matrix = { { 0, 1, 2, 0 }, { 3, 4, 5, 2 }, { 1, 3, 1, 5 } };
		setZeroes(matrix);
	}
}
