package Md_Graph;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Scanner;

public class DetectCycleInDirectedGraph {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int t = sc.nextInt();

		while (t-- > 0) {
			ArrayList<ArrayList<Integer>> list = new ArrayList<>();
			int nov = sc.nextInt();
			int edg = sc.nextInt();
			for (int i = 0; i < nov + 1; i++)
				list.add(i, new ArrayList<Integer>());
			for (int i = 1; i <= edg; i++) {
				int u = sc.nextInt();
				int v = sc.nextInt();
				list.get(u).add(v);
			}
			if (isCyclic(list, nov) == true)
				System.out.println("1");
			else
				System.out.println("0");
		}
	}

	static boolean isCyclic(ArrayList<ArrayList<Integer>> list, int V) {

		Boolean whiteSet[] = new Boolean[V];
		Boolean greySet[] = new Boolean[V];
		Boolean blackSet[] = new Boolean[V];

		Arrays.fill(whiteSet, true);
		Arrays.fill(greySet, false);
		Arrays.fill(blackSet, false);

		for (int i = 0; i < V; i++) {
			if (!whiteSet[i]) {
				isCyclicUtil(whiteSet, greySet, blackSet, list, i);
			}
		}

		return false;
	}

	private static void isCyclicUtil(Boolean[] whiteSet, Boolean[] greySet, Boolean[] blackSet,
			ArrayList<ArrayList<Integer>> list, int i) {

	}

}
