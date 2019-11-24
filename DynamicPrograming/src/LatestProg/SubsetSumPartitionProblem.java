/* Given an array of non negative numbers and a total, is there subset of numbers in this array which adds up
  to given total. Another variation is given an array is it possible to split it up into 2 equal
  sum partitions. Partition need not be equal sized. Just equal sum.*/

package LatestProg;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.OptionalInt;

public class SubsetSumPartitionProblem {

	public static void main(String[] args) {
		int arr[] = { 1, 3, 5, 5, 2, 1, 1, 6 };
		partition(arr);
	}

	private static void partition(int[] arr) {
		int sum = Arrays.stream(arr).reduce(Integer::sum).getAsInt();
        if (sum % 2 != 0) {
        	System.out.println("No subset sum partition exits");
            return ;
        }
		subsetSum(arr, sum / 2);
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
			System.out.println("Yes subset sum partition exits");
		else
			System.out.println("No subset sum partition exits");

		// BackTrack the numbers which from the sum
		System.out.println("Numbers are: ");
		ArrayList<Integer> resSet1 = new ArrayList<>();
		ArrayList<Integer> resSet2 = new ArrayList<>();
		int i = arr.length - 1;
		int j = sum;
		while (i > 0 || j > 0) {
			if (t[i - 1][j] == true) {
				resSet1.add(arr[i]);
				i = i - 1;
				continue;
			} else {
				resSet2.add(arr[i]);
				j = j - arr[i];
				i = i - 1;
			}
		}
		resSet1.add(arr[0]);
		
		System.out.println("set 1 Numbers are: "+resSet1.toString());
		System.out.println("set 2 Numbers are: "+resSet2.toString());

	}

}
