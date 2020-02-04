package Md_Graph;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Stack;

public class TopologicalSort {

	public static void main(String[] args) throws IOException {
		BufferedReader read = new BufferedReader(new InputStreamReader(System.in));
		int t = Integer.parseInt(read.readLine());

		while (t-- > 0) {
			ArrayList<ArrayList<Integer>> list = new ArrayList<>();
			String st[] = read.readLine().trim().split("\\s+");
			int edg = Integer.parseInt(st[0]);
			int nov = Integer.parseInt(st[1]);

			for (int i = 0; i < nov + 1; i++)
				list.add(i, new ArrayList<Integer>());

			String s[] = read.readLine().trim().split("\\s+");
			int p = 0;
			for (int i = 1; i <= edg; i++) {
				int u = Integer.parseInt(s[p++]);
				int v = Integer.parseInt(s[p++]);
				list.get(u).add(v);

			}

			int res[] = new int[10001];
			res = topoSort(list, nov);
			boolean valid = true;

			for (int i = 0; i < nov; i++) {
				int n = list.get(res[i]).size();
				for (int j = 0; j < list.get(res[i]).size(); j++) {
					for (int k = i + 1; k < nov; k++) {
						if (res[k] == list.get(res[i]).get(j))
							n--;
					}
				}
				if (n != 0) {
					valid = false;
					break;
				}
			}
			if (valid == true)
				System.out.println("0");
			else
				System.out.println("1");
		}
	}

	// U make think of doing BFS but here there is no source Vertix given
	private static int[] topoSort(ArrayList<ArrayList<Integer>> list, int nov) {
		Stack<Integer> stack = new Stack<>();
		Boolean[] visited = new Boolean[nov];
		Arrays.fill(visited, false);

		// Traverse All edges
		for (int i = 0; i < nov; i++) {
			if (!visited[i]) {
				visited[i] = true;
				topoRecursive(stack, visited, list, i);
				stack.add(i);
			}
		}
		int res[] = new int[nov];
		int i=0;
		while(!stack.empty()) {
			res[i++]=stack.pop();
		}
		return res;
	}

	private static void topoRecursive(Stack<Integer> stack, Boolean[] visited, ArrayList<ArrayList<Integer>> list,
			int edge) {
		ArrayList<Integer> childs = list.get(edge);
		if (childs.size() == 0) {
			return;
		}
		for (int j = 0; j < childs.size(); j++) {
			if (!visited[childs.get(j)]) {
				visited[childs.get(j)] = true;
				topoRecursive(stack, visited, list, childs.get(j));
				stack.add(childs.get(j));
			}

		}
	}
}