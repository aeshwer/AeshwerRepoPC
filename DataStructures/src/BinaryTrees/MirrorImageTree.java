package BinaryTrees;

import BinaryTrees.DeleteATree.Node;
/*
 * http://www.geeksforgeeks.org/symmetric-tree-tree-which-is-mirror-image-of-itself/
 */
public class MirrorImageTree {
	
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
	boolean MirrorImageTree(Node root1,Node root2){
		if( root1 == null && root2 == null)
			{return true;}
		 // For two trees to be mirror images, the following three conditions must be true
        // 1 - Their root node's key must be same
        // 2 - left subtree of left tree and right subtree
        //      of right tree have to be mirror images
        // 3 - right subtree of left tree and left subtree
        //      of right tree have to be mirror images
		if(root1.key == root2.key &&  root1 != null && root2 != null )
		{	return MirrorImageTree(root1.left,root2.right) && MirrorImageTree(root1.right,root2.left) ;
		}
		return false;
	}

	public static void main(String[] args) {

		MirrorImageTree tree = new MirrorImageTree();
		tree.root = new Node(1);
        tree.root.left = new Node(2);
        tree.root.right = new Node(2);
        tree.root.left.left = new Node(3);
        tree.root.left.right = new Node(4);
        tree.root.right.left = new Node(4);
        tree.root.right.right = new Node(3);
        
        boolean  check = tree.MirrorImageTree(tree.root,tree.root);
        System.out.println("They are Symmetric ::  " + check);
	}
}
