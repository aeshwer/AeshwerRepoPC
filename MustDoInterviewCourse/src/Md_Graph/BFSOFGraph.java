package Md_Graph;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

/*
 * Input:
2
5 4
0 1 0 2 0 3 2 4
3 2
0 1 0 2

Output:
0 1 2 3 4    // BFS from node 0
0 1 2
 */
public class BFSOFGraph {

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
			}
			boolean vis[] = new boolean[nov];
			for (int i = 0; i < nov; i++)
				vis[i] = false;
			bfs(0, list, vis, nov);
			System.out.println();
		}
	}

	static void bfs(int s, ArrayList<ArrayList<Integer>> list, boolean vis[], int nov) {

		Queue<Integer> q = new LinkedList<>();
		q.add(s);
		vis[s] = true;
		while (q.size() != 0) {
			int value = q.poll();
			System.out.print(value + " ");
			int noOFChild = list.get(value).size();
			for (int i = 0; i < noOFChild; i++) {
				int edge = list.get(value).get(i);
				if (!vis[edge]) {
					q.add(edge);
					vis[edge] = true;
				}
			}
		}
	}
}
