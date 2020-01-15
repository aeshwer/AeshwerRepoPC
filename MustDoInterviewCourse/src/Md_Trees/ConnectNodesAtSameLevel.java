package Md_Trees;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Deque;
import java.util.HashMap;
import java.util.LinkedList;

//https://practice.geeksforgeeks.org/problems/connect-nodes-at-same-level/1/?track=md-tree&batchId=144

public class ConnectNodesAtSameLevel {

	static class Node {
		int data;
		Node left, right, nextRight;

		Node(int x) {
			this.data = x;
			left = right = nextRight = null;
		}

	}

	static void printSpecial(Node root) {
		if (root == null)
			return;

		Node node = root;
		while (node != null) {
			System.out.print(node.data + " ");
			node = node.nextRight;
		}
		if (root.left != null)
			printSpecial(root.left);
		else
			printSpecial(root.right);

	}

	static void inorder(Node root) {
		if (root == null)
			return;
		inorder(root.left);
		System.out.print(root.data + " ");
		inorder(root.right);
	}

	public static void main(String args[]) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int t = Integer.parseInt(br.readLine());

		while (t-- > 0) {
			HashMap<Integer, Node> m = new HashMap<Integer, Node>();
			int n = Integer.parseInt(br.readLine());

			Node root = null;

			String nums[] = br.readLine().split(" ");
			int mm = n;
			for (int idx = 0; idx < mm; idx++) {

				int n1 = Integer.parseInt(nums[idx * 3]);
				int n2 = Integer.parseInt(nums[idx * 3 + 1]);

				String lr = nums[idx * 3 + 2];
				Node parent = m.get(n1);
				if (parent == null) {
					parent = new Node(n1);
					m.put(n1, parent);
					if (root == null)
						root = parent;
				}

				Node child = new Node(n2);
				if (lr.equals("L"))
					parent.left = child;
				else
					parent.right = child;
				m.put(n2, child);
			}
			new ConnectNodesAtSameLevel().connect(root);
			printSpecial(root);
			System.out.println();
			inorder(root);
			System.out.println();
		}
	}

	private void connect(Node root) {
		if (root == null)
			return;
		// Do a BFS and take a Queue Data Structure
		Deque<Node> queue1 = new LinkedList<>();
		Deque<Node> queue2 = new LinkedList<>();
		queue1.add(root);

		while (!queue1.isEmpty() || !queue2.isEmpty()) {
			while (!queue1.isEmpty()) {
				Node temp = queue1.pop();
				if (temp.left != null)
					queue2.add(temp.left);
				if (temp.right != null)
					queue2.add(temp.right);
				temp.nextRight = queue1.peek();
			}

			while (!queue2.isEmpty()) {
				Node temp = queue2.pop();
				if (temp.left != null)
					queue1.add(temp.left);
				if (temp.right != null)
					queue1.add(temp.right);
				temp.nextRight = queue2.peek();
			}
		}
	}

}
