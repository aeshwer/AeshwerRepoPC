package Md_Trees;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;

public class DiameterOfTress {

	public static class Node {
		int data;
		Node left, right;

		Node(int item) {
			data = item;
			left = right = null;
		}
	}

	public static class Binary_Tree_Diameter {
		// driver function to test the above functions
		public static void main(String args[]) throws IOException {
			// Input the number of test cases you want to run
			// Scanner sc = new Scanner(System.in);
			// int t = sc.nextInt();
			BufferedReader read = new BufferedReader(new InputStreamReader(System.in));
			int t = Integer.parseInt(read.readLine());
			while (t > 0) {
				HashMap<Integer, Node> m = new HashMap<Integer, Node>();
				int n = Integer.parseInt(read.readLine());
				Node root = null;
				int k = 0;
				String str[] = read.readLine().trim().replace("  ", " ").split(" ");
				for (k = 0; k < n * 3;) {
					int n1 = Integer.parseInt(str[k++]);
					int n2 = Integer.parseInt(str[k++]);
					char lr = str[k++].charAt(0);
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

				}
				Tree g = new Tree();
				System.out.println(g.diameter(root));
				t--;
			}
		}
	}

	/* Complete the function to get diameter of a binary tree */
	public static class Tree {
		int diameter(Node node) {
			if (node == null) {
				return 0;
			}
			int leftHeight = height(node.left);
			int rightHeight = height(node.right);

			return Math.max(Math.max(leftHeight + rightHeight + 1, diameter(node.left)), diameter(node.right));
		}

		int height(Node node) {
			if (node == null) {
				return 0;
			}
			int left = height(node.left);
			int right = height(node.right);
			return Math.max(left, right) + 1;
		}
	}

}
