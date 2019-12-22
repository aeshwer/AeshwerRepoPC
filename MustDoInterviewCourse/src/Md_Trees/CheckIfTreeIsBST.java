package Md_Trees;

import java.util.HashMap;
import java.util.Scanner;

//https://practice.geeksforgeeks.org/problems/check-for-bst/1/?track=md-tree&batchId=144
/*2
2
1 2 R 1 3 L
4
10 20 L 10 30 R 20 40 L 20 60 R
o/p 
0
0*/
public class CheckIfTreeIsBST {

	public static class Check_BST {
		// driver function to test the above functions
		public static void main(String args[]) {
			// Input the number of test cases you want to run
			Scanner sc = new Scanner(System.in);
			int t = sc.nextInt();
			Check_BST ob = new Check_BST();
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

				GfG g = new GfG();
				System.out.println(g.isBST(root));
				// ob.printInorder(root);
				t--;

			}
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

	public static class Range {
		int min;
		int max;

		Range(int min, int max) {
			this.min = min;
			this.max = max;
		}
	}

	// Use pre-order
	public static class GfG {
		int isBST(Node root) {
			if (root == null)
				return 1;
			else if (root != null && root.left == null && root.right == null) {
				return 1;
			} else if (checkBST(root, new Range(Integer.MIN_VALUE, Integer.MAX_VALUE))) {
				return 1;
			}
			return 0;
		}

		private boolean checkBST(Node root, Range range) {
			if (root == null)
				return true;
			if (root.data < range.max && root.data > range.min) {
				return checkBST(root.left, new Range(range.min, root.data))
						&& checkBST(root.right, new Range(root.data, range.max));
			} else {
				return false;
			}

		}
	}

}
