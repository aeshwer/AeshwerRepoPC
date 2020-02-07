package Md_Graph;

import java.util.ArrayList;
import java.util.Scanner;

public class FindNumberOfIslands {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int t = sc.nextInt();

		while (t-- > 0) {
			int N = sc.nextInt();
			int M = sc.nextInt();

			ArrayList<ArrayList<Integer>> list = new ArrayList<>(N);

			// creating arraylist of arraylist
			for (int i = 0; i < N; i++) {
				ArrayList<Integer> temp = new ArrayList<>(M);
				list.add(i, temp);
			}

			// adding elements to the arraylist of arraylist
			for (int i = 0; i < N; i++) {
				for (int j = 0; j < M; j++) {
					int val = sc.nextInt();
					list.get(i).add(j, val);
				}
			}

			System.out.println(findIslands(list, N, M));

		}
	}

	// Function to find the number of island in the given list
	// N, M: size of list row and column respectively
	static int findIslands(ArrayList<ArrayList<Integer>> list, int N, int M) {
		return M;
	}

}
