package Md_Trees;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;
import java.util.TreeMap;

//https://practice.geeksforgeeks.org/problems/left-view-of-binary-tree/1/?track=md-tree&batchId=144
/*Input:
2
2
1 2 R 1 3 L
4
10 20 L 10 30 R 20 40 L 20 60 R

Output:
1 3
10 20 40*/
public class Tree_Left_View {

	// Actual Logic Class
	public static class Tree {
		void leftView(Node root) {
			if (root != null) {
				Map<Integer, Integer> lookup = new TreeMap<>();
				printLeftView(root, 0, lookup);
				lookup.forEach((k, v) -> System.out.print(v + " "));
			}
		}

		void printLeftView(Node root, int depth, Map<Integer, Integer> lookup) {
			if (root == null)
				return;
			if (!lookup.containsKey(depth)) {
				lookup.put(depth, root.data);
			}
			printLeftView(root.left, depth + 1, lookup);
			printLeftView(root.right, depth + 1, lookup);
		}
	}

	public static class Node {
		int data;
		Node left, right;

		Node(int item) {
			data = item;
			left = right = null;
		}

	}

	public static void main(String args[]) {
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
			Tree g = new Tree();
			g.leftView(root);
			System.out.println();
			t--;
		}

	}
}