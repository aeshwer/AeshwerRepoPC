package Md_Graph;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.Scanner;
import java.util.Set;
//apply DFS
public class DetectCycleInUnDirectedGraph {

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
				list.get(v).add(u);
			}
			if (isCyclic(list, nov) == true)
				System.out.println("1");
			else
				System.out.println("0");
		}
	}

	static boolean isCyclic(ArrayList<ArrayList<Integer>> list, int V) {
		boolean[] visited = new boolean[V];
		for (int i = 0; i < V; i++) {
			visited[i] = false;
		}

		for (int u = 0; u < V; u++) {
			if (!visited[u]) {
				if (isCyclic(list, visited, u, -1)) // return and stop if u found a cycle
					return true;
			}
		}

		return false;
	}

	static boolean isCyclic(ArrayList<ArrayList<Integer>> list, boolean[] visited, int v, int parent) {
		visited[v] = true;
		for (int i : list.get(v)) {
			if (!visited[i]) {
				if (isCyclic(list, visited, i, v))
					return true;
			} else if (i != parent) {
				return true;
			}
		}

		return false;
	}

}
