package LatestProg;

public class MinimumNumberOfCoins {

	public static void main(String[] args) {
		int total = 8;
		int coins[] = { 2, 4, 6, 7 };
		// numberOfSolutions(total, coins);// works only if the first coin is 1
		// System.out.println(numberOfSolutionsOnSpace(total, coins));//works for all
		minimumCoinBottomUp(total, coins); // infinity with 1D array Approach

	}

	public static int minimumCoinBottomUp(int total, int coins[]) {
		int T[] = new int[total + 1];
		int R[] = new int[total + 1];
		T[0] = 0;
		for (int i = 1; i <= total; i++) {
			T[i] = Integer.MAX_VALUE-1; // we do this cause in code we are doing +1 to this value and we may get overflow in some case
			R[i] = -1;
		}
		for (int j = 0; j < coins.length; j++) {
			for (int i = 1; i <= total; i++) {
				if (i >= coins[j]) {
					if (T[i - coins[j]] + 1 < T[i]) {
						T[i] = 1 + T[i - coins[j]];
						R[i] = j;
					}
				}
			}
		}
		printCoinCombination(R, coins);
		return T[total];
	}

	private static void printCoinCombination(int R[], int coins[]) {
		if (R[R.length - 1] == -1) {
			System.out.print("No solution is possible");
			return;
		}
		int start = R.length - 1;
		System.out.print("Coins used to form total ");
		while (start != 0) {
			int j = R[start];
			System.out.print(coins[j] + " ");
			start = start - coins[j];
		}
		System.out.print("\n");
	}

	private static void numberOfSolutions(int total, int[] coins) {
		int t[][] = new int[coins.length][total + 1];

		// fill base case ->> if total is zero then we need zero of any coins
		// first column is all zeros
		for (int i = 0; i < coins.length; i++) {
			t[i][0] = 0;
		}
		// first row is filled
		for (int i = 1; i < total + 1; i++) {
			int remainder = i % coins[0];
			if (remainder == 0)
				t[0][i] = i / coins[0];
			else
				t[0][i] = 0;
		}

		// As per formula
		for (int i = 1; i < coins.length; i++) {
			for (int j = 1; j < total + 1; j++) {
				if (j < coins[i])
					t[i][j] = t[i - 1][j];
				else {
					t[i][j] = Math.min(1 + t[i][j - coins[i]], t[i - 1][j]);
				}
			}

		}

		System.out.println("Minimum Number of coins needed are : " + t[coins.length - 1][total]);

		// BackTrack the numbers which from the sum
		System.out.println("Coins used are: ");
		int i = coins.length - 1;
		int j = total;
		while (i != 0 && j != 0) {
			if (t[i - 1][j] == t[i][j]) {
				i = i - 1;
				continue;
			} else {
				System.out.print(coins[i] + " ");
				j = j - coins[i];
			}
		}
	}
}
