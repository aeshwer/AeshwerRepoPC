package BinaryTrees;

import BinaryTrees.DeleteATree.Node;

public class BinaryTreeToMirroTree {

	Node root;
	public static class Node
	{
		int key;
		Node left;
		Node right;
		Node(int key){
			this.key = key;
			left = right = null; 
		}
	}
	
	void mirrorTree(Node root){
		
		if(root == null){
			return ;
		}
		
		Node temp;
		temp = root.left;
		root.left = root.right;
		root.right = temp;
		
		mirrorTree(root.left);
		mirrorTree(root.right);
		
	}
	

	  /* Given a binary tree, print its nodes in preorder*/
	  void printPreorder(Node node)
	  {
	      if (node == null)
	          return;

	      /* first print data of node */
	      System.out.print(node.key + " ");

	      /* then recur on left sutree */
	      printPreorder(node.left);

	      /* now recur on right subtree */
	      printPreorder(node.right);
	  }
	
	public static void main(String[] args) {
		BinaryTreeToMirroTree tree = new BinaryTreeToMirroTree();
        tree.root = new Node(1);
        tree.root.left = new Node(2);
        tree.root.right = new Node(3);
        tree.root.left.left = new Node(4);
        tree.root.left.right = new Node(5);
        
        System.out.print("Pre order traversal of input tree is :");
        tree.printPreorder(tree.root);
        System.out.println();
        System.out.print("Pre order traversal of output tree is :");
        tree.mirrorTree(tree.root);
        tree.printPreorder(tree.root);
	}
}
