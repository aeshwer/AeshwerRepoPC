package LeetCode_Medium;

public class LeftmostColumnWithAtLeastOne {

	public static int leftMostColumnWithOne(int[][] binaryMatrix) {
		int row = binaryMatrix.length;
		int col = binaryMatrix[0].length;

		int i = 0;
		int j = col - 1;
		int minIndex = -1;

		while (i < row && j >= 0) {

			if (binaryMatrix[i][j] == 0) {
				i++;
			} else {
				minIndex = j;
				--j;
			}

		}
		return minIndex;

	}

	public static void main(String[] args) {
		int[][] arr = { { 0, 0 }, { 1, 1 } };
		System.out.println(leftMostColumnWithOne(arr));
	}
}
