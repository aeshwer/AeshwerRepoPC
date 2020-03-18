package LatestProg;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

//Very Confusion ?did not get?
//https://leetcode.com/problems/unique-binary-search-trees-ii/
//solution  -> https://leetcode.com/problems/unique-binary-search-trees/discuss/31666/DP-Solution-in-6-lines-with-explanation.-F(i-n)-G(i-1)-*-G(n-i)
public class UuniqueBinarySearchTree {

	public static class TreeNode {
		int val;
		TreeNode left;
		TreeNode right;

		TreeNode(int x) {
			val = x;
		}
	}

	public static List<TreeNode> generateTrees(int n) {
		if (n == 0)
			return new LinkedList(); // here is new line
		return generateSubtrees(1, n);
	}

	private static List<TreeNode> generateSubtrees(int start, int end) {
		List<TreeNode> list = new ArrayList<TreeNode>();

		if (start > end) {
			list.add(null);
			return list;
		}

		if (start == end) {
			list.add(new TreeNode(start));
			return list;
		}

		List<TreeNode> left, right;
		for (int i = start; i <= end; i++) {

			left = generateSubtrees(start, i - 1);
			right = generateSubtrees(i + 1, end);

			for (TreeNode lnode : left) {
				for (TreeNode rnode : right) {
					TreeNode root = new TreeNode(i);
					root.left = lnode;
					root.right = rnode;
					list.add(root);
				}
			}

		}

		return list;
	}

	public static void main(String[] args) {
		List<TreeNode> generateTrees = generateTrees(3);
		generateTrees.forEach(root -> {
			System.out.print("[ ");
			printPreOrder(root);
			System.out.print("]");
			System.out.println();
		});
	}

	private static void printPreOrder(TreeNode root) {
		if (root == null)
			return;
		System.out.print(root.val + " ");
		printPreOrder(root.left);
		printPreOrder(root.right);

	}

}
