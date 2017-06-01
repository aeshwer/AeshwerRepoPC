package BinaryTrees;

import BinaryTrees.BinaryTreeTraversal.Node;

public class IsomorphismTree {
	
	Node root1,root2;
	public static class Node
	{
	    int data;
	    Node left, right;
	 
	    public Node(int key)
	    {
	        this.data = data;
	        left = right = null;
	    }
	}
	 /* Given a binary tree, print its nodes in reverse level order */
    boolean isIsomorphic(Node n1, Node n2) 
    {
        // Both roots are NULL, trees isomorphic by definition
        if (n1 == null && n2 == null)
            return true;
  
        // Exactly one of the n1 and n2 is NULL, trees not isomorphic
        if (n1 == null || n2 == null)
            return false;
  
        if (n1.data != n2.data)
            return false;

        // There are two possible cases for n1 and n2 to be isomorphic
        // Case 1: The subtrees rooted at these nodes have NOT been "Flipped". Both of these subtrees have to be isomorphic.
        // Case 2: The subtrees rooted at these nodes have been "Flipped"
        // i.e here we check if case 1 is true or case 2 is true ...any of the cases being true works for us 
        return (isIsomorphic(n1.left, n2.left) && isIsomorphic(n1.right, n2.right))|| (isIsomorphic(n1.left, n2.right) && isIsomorphic(n1.right, n2.left));
    }

	public static void main(String[] args) {
		IsomorphismTree tree = new IsomorphismTree();
        // Let us create trees shown in above diagram
        tree.root1 = new Node(1);
        tree.root1.left = new Node(2);
        tree.root1.right = new Node(3);
        tree.root1.left.left = new Node(4);
        tree.root1.left.right = new Node(5);
        tree.root1.right.left = new Node(6);
        tree.root1.left.right.left = new Node(7);
        tree.root1.left.right.right = new Node(8);
  
        tree.root2 = new Node(1);
        tree.root2.left = new Node(3);
        tree.root2.right = new Node(2);
        tree.root2.right.left = new Node(4);
        tree.root2.right.right = new Node(5);
        tree.root2.left.right = new Node(6);
        tree.root2.right.right.left = new Node(8);
        tree.root2.right.right.right = new Node(7);
  
        if (tree.isIsomorphic(tree.root1, tree.root2) == true)
            System.out.println("Yes");
        else
            System.out.println("No");
    }
}
