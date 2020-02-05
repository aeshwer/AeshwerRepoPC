package Md_Graph;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.Scanner;
import java.util.Set;

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
		Boolean[] visited = new Boolean[V];
		Arrays.fill(visited, false);

		for (int i = 0; i < V; i++) {
			if (visited[i]) {
				continue;
			}
			boolean flag = hasCycleDFSUtil(i, -1, visited, list);
			if (flag) {
				return true;
			}
		}
		return false;
	}

	private static boolean hasCycleDFSUtil(Integer vertex, Integer parent, Boolean[] visited,
			ArrayList<ArrayList<Integer>> list) {

		visited[vertex] = true;
		ArrayList<Integer> childs = list.get(vertex);
		for (int i = 0; i < childs.size(); i++) {
			if (!visited[i]) {
				boolean hasCycle = hasCycleDFSUtil(i, vertex, visited, list);
				if (hasCycle) {
					return true;
				}
			} else if (i != parent) { // check here for a visited non parent node means cycle
				return true;
			}
		}
		return false;

	}

}
