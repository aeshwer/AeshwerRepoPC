package LeetCode_Medium;

/*
Integers in each row are sorted from left to right.
The first integer of each row is greater than the last integer of the previous row
 */
public class Search2DMatrix {

	public static boolean searchMatrix(int[][] matrix, int target) {
		if (matrix == null || matrix.length == 0) {
			return false;
		}
		int rows = matrix.length;
		int cols = matrix[0].length;

		int left = 0;
		int right = rows * cols - 1;

		while (left <= right) {
			int mid = left + (right - left) / 2;
			if (matrix[mid / cols][mid % cols] == target) {
				return true;
			}
			if (matrix[mid / cols][mid % cols] < target) {
				left = mid + 1;
			} else {
				right = mid - 1;
			}
		}
		return false;
	}

	public static void main(String[] args) {
		int[][] matrix = { { 1, 3, 5, 7 }, { 10, 11, 16, 20 }, { 23, 30, 34, 50 } };
		System.out.println(searchMatrix(matrix, 3));
	}
}
