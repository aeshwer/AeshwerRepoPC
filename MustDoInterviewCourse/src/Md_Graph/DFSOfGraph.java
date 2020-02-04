package Md_Graph;

import java.util.ArrayList;
import java.util.Scanner;
import java.util.Stack;

/*
 * Input:
2
5 4
0 1 0 2 0 3 2 4
4 3
0 1 1 2 0 3

Output:
0 1 2 4 3    // dfs from node 0
0 1 2 3
 */
public class DFSOfGraph {

	public static void main(String args[]) {
		Scanner sc = new Scanner(System.in);
		int t = sc.nextInt();
		while (t-- > 0) {
			ArrayList<ArrayList<Integer>> list = new ArrayList<>();
			int nov = sc.nextInt();
			int edg = sc.nextInt();
			for (int i = 0; i < nov; i++)
				list.add(i, new ArrayList<Integer>());

			for (int i = 1; i <= edg; i++) {
				int u = sc.nextInt();
				int v = sc.nextInt();
				list.get(u).add(v);
				list.get(v).add(u);
			}
			boolean vis[] = new boolean[nov];
			for (int i = 0; i < nov; i++)
				vis[i] = false;

			dfs(0, list, vis); // 1st solution
			System.out.println();
			boolean vis2[] = new boolean[nov];
			for (int i = 0; i < nov; i++)
				vis2[i] = false;
			dfsRecursion(0, list, vis2); // 2nd solution
			System.out.println();
		}
	}

	static void dfs(int src, ArrayList<ArrayList<Integer>> list, boolean vis[]) {
		Stack<Integer> stack = new Stack<>();
		stack.push(src);

		while (!stack.isEmpty()) {
			int s = stack.pop();
			if (!vis[s]) {
				System.out.print(s + " ");
				vis[s] = true;
			}

			// Get its child
			ArrayList<Integer> edges = list.get(s);
			for (int i = edges.size() - 1; i >= 0; i--) {
				int edge = edges.get(i);
				if (!vis[edge]) {
					stack.push(edge);
				}
			}
		}
	}

	static void dfsRecursion(int src, ArrayList<ArrayList<Integer>> list, boolean vis[]) {
		// add your code here
		if (vis[src])
			return;
		vis[src] = true;
		System.out.print(src + " ");
		int size = list.get(src).size();
		for (int i = 0; i < size; i++)
			dfsRecursion(list.get(src).get(i), list, vis);
		return;
	}
}
