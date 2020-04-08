package LeetCode_Medium;

import java.util.Arrays;

//https://leetcode.com/problems/rotate-image/discuss/18872/A-common-method-to-rotate-the-image
/*
 * clockwise rotate
 * first reverse up to down, then swap the symmetry 
 * 1 2 3     7 8 9     7 4 1
 * 4 5 6  => 4 5 6  => 8 5 2
 * 7 8 9     1 2 3     9 6 3
*/

//2ND FALVOUR
/*
 * anticlockwise rotate
 * first reverse left to right, then swap the symmetry
 * 1 2 3     3 2 1     3 6 9
 * 4 5 6  => 6 5 4  => 2 5 8
 * 7 8 9     9 8 7     1 4 7
*/
public class RotateImage {

	public static void rotate(int[][] matrix) {
		int n = matrix.length;
		int reverseRowIndex = n - 1;
		// reverse up to down
		for (int i = 0; i < n / 2; i++) {
			for (int j = 0; j < n; j++) {
				int temp = matrix[i][j];
				matrix[i][j] = matrix[reverseRowIndex][j];
				matrix[reverseRowIndex][j] = temp;
			}
			reverseRowIndex--;
		}

		// Now swap in symmetry
		int diagonalcolumnIndexStart = 0;
		for (int i = 0; i < n; i++) {
			for (int j = diagonalcolumnIndexStart; j < n; j++) {
				int temp = matrix[i][j];
				matrix[i][j] = matrix[j][i];
				matrix[j][i] = temp;
			}
			diagonalcolumnIndexStart++;
		}
		System.out.println(Arrays.deepToString(matrix));
	}

	public static void main(String[] args) {
		int[][] matrix = { { 1, 2, 3, 4 }, { 5, 6, 7, 8 }, { 9, 10, 11, 12 }, { 13, 14, 15, 16 } };
		rotate(matrix);
	}

}
