package BinaryTrees;

import java.util.LinkedList;
import java.util.Queue;

public class LevelOrderLineByLine {

	Node root;
	static class Node
	{
		Node left,right;
		int key;
		Node(int key)
		{
			left= right= null;
			this.key =key;
		}
	}

	void printLevelOrder()
	{
		Queue<Node> queue = new LinkedList<Node>();
		queue.add(root);
		int node = 0;
		while(true)
		{
			node=queue.size();
			if(node == 0)
				return ;
			System.out.println();
			while(node>0)
			{
				Node temp = queue.poll();
				System.out.print(temp.key+ " ");
				if(temp.left != null)
				{
					queue.add(temp.left);
				}
				if(temp.right != null)
				{
					queue.add(temp.right);
				}
				node --;
			}	
		}

	}

	public static void main(String[] args) {

		LevelOrderLineByLine tree = new LevelOrderLineByLine();
		tree.root = new Node(1);
		tree.root.left = new Node(2);
		tree.root.right = new Node(3);
		tree.root.left.left = new Node(4);
		tree.root.left.right = new Node(5);
		tree.root.left.left.left = new Node(6);
		tree.root.left.left.right = new Node(7);

		System.out.println("Level order traversal of binary tree is - ");
		tree.printLevelOrder();
	}
}
