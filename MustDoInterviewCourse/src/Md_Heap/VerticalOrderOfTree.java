package Md_Heap;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.TreeMap;

public class VerticalOrderOfTree {
	public static class Node {
		int data, hd;
		Node left, right;

		Node(int key) {
			data = key;
			left = right = null;
			hd = Integer.MAX_VALUE;
		}
	}

	public static class driver_class {
		public static void main(String[] args) throws IOException {
			// Scanner sc = new Scanner(System.in);
			// int t = sc.nextInt();
			BufferedReader read = new BufferedReader(new InputStreamReader(System.in));
			int t = Integer.parseInt(read.readLine());

			while (t-- > 0) {
				HashMap<Integer, Node> m = new HashMap<Integer, Node>();
				int n = Integer.parseInt(read.readLine());
				Node root = null;
				String str[] = read.readLine().replace("  ", " ").trim().split(" ");
				int k = 0;
				while (n-- > 0) {
					int n1 = Integer.parseInt(str[k++]);
					int n2 = Integer.parseInt(str[k++]);
					char lr = str[k++].charAt(0);

					Node parent = m.get(n1);
					if (parent == null) {
						parent = new Node(n1);
						m.put(n1, parent);
						if (root == null)
							root = parent;
					}
					Node child = new Node(n2);
					if (lr == 'L')
						parent.left = child;
					else
						parent.right = child;
					m.put(n2, child);
				}

				BinaryTree.verticalOrder(root);
				System.out.println();
			}
		}
	}

	public static class ValuesAndDepth {
		int data;
		int depth;
		public ValuesAndDepth(int data,int depth) {
			this.data=data;
			this.depth=depth;
		}
	}
	public static class BinaryTree {
		static void verticalOrder(Node root) {
			Map<Integer, List<ValuesAndDepth>> lookup = new TreeMap<>();
			printVerticalOrder(root, lookup, 0);
			lookup.forEach((k, v) -> {
				for (Integer l : v) {
					System.out.print(l + " ");
				}
			});
		}

		private static void printVerticalOrder(Node root, Map<Integer, List<ValuesAndDepth>> lookup, int horizontalDistance) {
			if (root == null) {
				return;
			}

			if (lookup.containsKey(horizontalDistance)) {
				List<ValuesAndDepth> list = lookup.get(horizontalDistance);
				list.add(root.data);
			} else {
				List<ValuesAndDepth> list = new ArrayList<>();
				list.add(root.data);
				lookup.put(horizontalDistance, list);
			}
			printVerticalOrder(root.left, lookup, horizontalDistance - 1);
			printVerticalOrder(root.right, lookup, horizontalDistance + 1);

		}
	}
}
