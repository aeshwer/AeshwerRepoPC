package BinaryTrees;
/*
 * To identify if two trees are identical, we need to traverse both trees simultaneously, and while traversing we 
 * need to compare data and children of the trees
 */

import BinaryTrees.HeightOfBinaryTreeIterative.Node;

public class IdenticalTrees {
	Node root1,root2;
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
	
	boolean checkIdentical(Node root1, Node root2)
	{
		 /*1. both empty */
	    if (root1 == null && root2 == null)
	        return true;
	    
	    /* 2. both non-empty -> compare them */
        if (root1 != null && root2 != null){
        	return (root1.key == root2.key
                    && checkIdentical(root1.left,  root2.left)
                    && checkIdentical(root1.right, root2.right));
        }
        /* 3. one empty, one not -> false */
        return false;
		
	}
	
	public static void main(String[] args) {
		

		IdenticalTrees tree = new IdenticalTrees();
		//first tree
        tree.root1 = new Node(1);
        tree.root1.left = new Node(2);
        tree.root1.right = new Node(3);
        tree.root1.left.left = new Node(4);
        tree.root1.left.right = new Node(5);
        
        //second tree
        tree.root2 = new Node(1);
        tree.root2.left = new Node(2);
        tree.root2.right = new Node(3);
        tree.root2.left.left = new Node(4);
        tree.root2.left.right = new Node(5);
        tree.root2.left.right = new Node(9);
        
        System.out.println("Trees are identical :: "+ tree.checkIdentical(tree.root1,tree.root2));
		
	}

}
