package BinaryTrees;

import BinaryTrees.HeightOfBinaryTreeIterative.Node;
/*
 * Size of a tree is the number of elements present in the tree. Size of the below tree is 5
 * NOTE::  Size of a tree = Size of left subtree + 1 + Size of right subtree ,ie number of nodes
 */
public class SizeOfATree {

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
			this.key =key;
		}
	}
	
	int SizeOfTree(Node root)
	{
		if(root == null) {return 0;}
		int leftSize = SizeOfTree(root.left);
		int rightSize = SizeOfTree(root.right);
		return leftSize+rightSize+1;
	}
	
	public static void main(String[] args) {
		
		SizeOfATree tree = new SizeOfATree();
        tree.root = new Node(1);
        tree.root.left = new Node(2);
        tree.root.right = new Node(3);
        tree.root.left.left = new Node(4);
        tree.root.left.right = new Node(5);
        tree.root.left.left.left = new Node(6);
        tree.root.left.left.right = new Node(7);
        
        System.out.println("Height of tree is :: "+ tree.SizeOfTree(tree.root));
	}
}
