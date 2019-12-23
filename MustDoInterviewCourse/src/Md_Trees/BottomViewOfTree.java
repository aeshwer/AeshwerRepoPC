package Md_Trees;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;
import java.util.TreeMap;

/*Input:
2
2
1 2 R 1 3 L
4
10 20 L 10 30 R 20 40 L 20 60 R

Output:
3 1 2
40 20 60 30*/
public class BottomViewOfTree {

	public static class Node {
		int data; // data of the node
		int hd; // horizontal distance of the node
		Node left, right; // left and right references

		// Constructor of tree node
		public Node(int key) {
			data = key;
			hd = Integer.MAX_VALUE;
			left = right = null;
		}
	}

	public static class BottomView {
		// driver function to test the above functions
		public static void main(String args[]) {

			// Input the number of test cases you want to run
			Scanner sc = new Scanner(System.in);
			int t = sc.nextInt();
			// Node root=null;
			while (t > 0) {
				HashMap<Integer, Node> m = new HashMap<Integer, Node>();
				int n = sc.nextInt();
				Node root = null;
				while (n > 0) {
					int n1 = sc.nextInt();
					int n2 = sc.nextInt();
					char lr = sc.next().charAt(0);
					// cout << n1 << " " << n2 << " " << (char)lr << endl;
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
					n--;
				}

				Tree.bottomView(root);

				System.out.println();
				t--;
			}
		}
	}

	public static class Tree {
		// Should print bottom view of tree with given root
		public static void bottomView(Node root) {
			Map<Integer, Integer> lookup = new TreeMap<>();
			printBottomView(root, lookup, 0);
			lookup.forEach((k, v) -> System.out.print(v + " "));

		}

		private static void printBottomView(Node root, Map<Integer, Integer> lookup, int horizontalDistance) {
			if (root == null)
				return;
			lookup.put(horizontalDistance, root.data);
			printBottomView(root.left, lookup, horizontalDistance - 1);
			printBottomView(root.right, lookup, horizontalDistance + 1);

		}
	}

}
