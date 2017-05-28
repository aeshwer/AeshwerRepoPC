package BinaryTrees;

import BinaryTrees.LevelOrderLineByLine.Node;

public class HeightOfBinaryTressRecursion {

	Node root;
	static class Node
	{
		Node left;
		Node right;
		int key;
		Node(int key)
		{
			this.left= left;
			this.right= right;
			this.key = key;
		}
	}
	
	int heightOfTree(Node root)
	{
		if(root == null){return -1;}
		int leftHeight=  heightOfTree(root.left);
		int rightHeight=  heightOfTree(root.right);
		return Math.max(leftHeight,rightHeight) +1;
		
	}
	
	public static void main(String[] args) {

		HeightOfBinaryTressRecursion tree = new HeightOfBinaryTressRecursion();
        tree.root = new Node(1);
        tree.root.left = new Node(2);
        tree.root.right = new Node(3);
        tree.root.left.left = new Node(4);
        tree.root.left.right = new Node(5);
        
        System.out.println("Level order traversal of binary tree is - ");
        int h = tree.heightOfTree(tree.root);
        System.out.println("The height is :: "+ h);
        
	}
	
}
