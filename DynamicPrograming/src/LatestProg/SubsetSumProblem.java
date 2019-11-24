package LatestProg;

public class SubsetSumProblem {

	public static void main(String[] args) {
		int arr[] = { 2, 3, 7, 8, 10 };
		subsetSum(arr, 11);
	}

	private static void subsetSum(int[] arr, int sum) {
		boolean t[][] = new boolean[arr.length][sum + 1];

		// fill base case ->> 1=true and 0=false
		// first column is true
		for (int i = 0; i < arr.length; i++) {
			t[i][0] = true;
		}
		// first row is filled
		for (int i = 1; i < sum + 1; i++) {
			if (i == arr[0])
				t[0][i] = true;
			else
				t[0][i] = false;
		}

		// As per formula
		for (int i = 1; i < arr.length; i++) {
			for (int j = 1; j < sum + 1; j++) {
				if (j < arr[i])
					t[i][j] = t[i - 1][j];
				else {
					t[i][j] = t[i - 1][j] || t[i - 1][j - arr[i]];
				}
			}

		}

		if (t[arr.length - 1][sum])
			System.out.println("Yes subset exits");
		else
			System.out.println("No subset exits");

		// BackTrack the numbers which from the sum
		System.out.println("Numbers are: ");
		int i = arr.length - 1;
		int j = sum;
		while(i!=0 && j!=0) {
			if(t[i-1][j]==true) {
				i=i-1;
				continue;
			}
			else {
				System.out.print(arr[i]+" ");
				j= j-arr[i];
				i = i-1;
			}
		}

	}
}
