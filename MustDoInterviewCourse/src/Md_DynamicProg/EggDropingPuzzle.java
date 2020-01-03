package Md_DynamicProg;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class EggDropingPuzzle {

	public static class FastReader {

		BufferedReader reader;
		StringTokenizer token;

		public FastReader() {
			reader = new BufferedReader(new InputStreamReader(System.in));
		}

		Integer nextInt() {
			return Integer.parseInt(next());
		}

		private String next() {
			if (token == null || !token.hasMoreElements()) {
				try {
					token = new StringTokenizer(reader.readLine());
				} catch (IOException e) {
					e.printStackTrace();
				}
			}
			return token.nextToken();
		}
	}

	public static void main(String[] args) {
		FastReader fastReader = new FastReader();
		int cases = fastReader.nextInt();

		while (--cases >= 0) {
			int floors = fastReader.nextInt();
			int eggs = fastReader.nextInt();
			solveEggDropProblem(floors, eggs);
		}
	}

	private static void solveEggDropProblem(int floors, int eggs) {
		/*
		 * A 2D table where entery eggFloor[i][j] will represent minimum number of
		 * trials needed for i eggs and j floors.
		 */
		int T[][] = new int[floors + 1][eggs + 1];
		int res;
		int i, j, x;

		// Base case - for 1 floor we need 1 try, so first column all 1
		//ignore zero row and column 
		for (i = 1; i <= floors; i++) {
			T[i][1] = 1;
		}
		// Base case - We always need j trials for one egg and j floors.
		for (j = 1; j <= eggs; j++)
			T[1][j] = j;

		// Solution - Fill rest of the entries in table using optimal substructure property
		for (i = 2; i <= floors; i++) {
			for (j = 2; j <= eggs; j++) {
				T[i][j] = Integer.MAX_VALUE;
				for (x = 1; x <= j; x++) {
					res = 1 + Math.max(T[i - 1][x - 1], T[i][j - x]);
					if (res < T[i][j])
						T[i][j] = res;
				}
			}
		}

		// eggFloor[n][k] holds the result
		System.out.println(T[floors][eggs]);
	}

}