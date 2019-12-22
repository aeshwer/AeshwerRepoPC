package Md_Trees;

import java.util.Scanner;
//https://www.geeksforgeeks.org/find-maximum-path-sum-two-leaves-binary-tree/

/*Example:
Input:
1
12
-15 5 L -15 6 R 5 -8 L 5 1 R -8 2 L -8 -3 R 6 3 L 6 9 R 9 0 R 0 4 L 0 -1 R -1 10 L

Output:
27*/
public class MaxLeafToLeafPath {

	public static class Node {
		int data;
		Node left, right;

		Node(int key) {
			data = key;
			left = right = null;
		}
	}

	public static class Result {
		int val;
	}

	public static class PathSum {
		public static void main(String[] args) {
			Scanner sc = new Scanner(System.in);
			int t = sc.nextInt();

			while (t-- > 0) {
				int n = sc.nextInt();
				if (n == 0) {
					System.out.println(0);
					continue;
				}
				Node root = null;
				for (int i = 0; i < n; i++) {
					int a = sc.nextInt();
					int a1 = sc.nextInt();
					char lr = sc.next().charAt(0);
					if (i == 0) {
						root = new Node(a);

						switch (lr) {
						case 'L':
							root.left = new Node(a1);

							break;
						case 'R':
							root.right = new Node(a1);

							break;
						}
					} else {
						insert(root, a, a1, lr);
					}
				}
				MaxLeafToLeafPath gfg = new MaxLeafToLeafPath();
				int maxPathSum = maxPathSum(root);
				System.out.println(maxPathSum);
			}
		}

		/*
		 * This is a function problem.You only need to complete the function given below
		 */
		// USE POST ORDER
		private static int maxPathSum(Node root) {
			Result res = new Result();
			res.val = Integer.MIN_VALUE;
			getMaxPathSum(root, res);
			return res.val;
		}

		private static int getMaxPathSum(Node node, Result res) {
			// Base cases
			if (node == null) {
				return 0;
			}
			if (node.left == null && node.right == null) {
				return node.data;
			}

			// Find maximum sum in left and right subtree. Also find maximum root to leaf
			// sums in left and right subtrees and store them in ls and rs
			int ls = getMaxPathSum(node.left, res);
			int rs = getMaxPathSum(node.right, res);

			// If both left and right children exist
			if (node.left != null && node.right != null) {

				// Update result if needed
				res.val = Math.max(res.val, ls + rs + node.data);

				// Return maxium possible value for root being
				// on one side
				return Math.max(ls, rs) + node.data;
			}

			// If any of the two children is empty, return
			// root sum for root being on one side
			return (node.left == null) ? rs + node.data : ls + node.data;
		}

		public static void insert(Node root, int a, int a1, char lr) {
			if (root == null) {
				return;
			}
			if (root.data == a) {
				switch (lr) {
				case 'L':
					root.left = new Node(a1);
					break;
				case 'R':
					root.right = new Node(a1);
					break;
				}
				return;
			}
			insert(root.left, a, a1, lr);
			insert(root.right, a, a1, lr);
		}
	}

}