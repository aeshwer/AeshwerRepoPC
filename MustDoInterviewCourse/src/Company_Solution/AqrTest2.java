package Company_Solution;

import java.util.Arrays;

public class AqrTest2 {

	static int[][] matrixSummation(int[][] after) {

		int[][] before = new int[after.length][after[0].length];

		for (int i = 0; i < after.length; i++) {
			for (int j = 0; j < after[0].length; j++) {
				int sum = 0;
				for (int k = 0; k <= i; k++) {
					for (int l = 0; l <= j; l++) {
						sum = sum + before[k][l];
					}

				}

				before[i][j] = after[i][j] - sum;
			}
		}
		return before;

	}

	public static void main(String[] args) {
		int[][] after = { { 1, 2 }, { 3, 4 } };
		int[][] matrixSummation = matrixSummation(after);
		System.out.println(Arrays.deepToString(matrixSummation));

	}

}
