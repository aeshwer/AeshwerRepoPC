package BinaryTrees;

import java.util.LinkedList;
import java.util.Stack;

public class InorderTraversalWithoutRecursion {
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
	void inorder()
	{
		//base case
		 if (root == null) {return;}
		// Create an empty stack for level order tarversal
        Stack<Node> s = new Stack<Node>();	
        //push the entire left nodes
        while (root != null) {
            s.push(root);
            root = root.left;
        }
        
     // traverse the tree
        while (s.size() > 0)
        {
            // visit the bottom left node
            root = s.pop();
            System.out.print(root.key + " ");
            if (root.right != null) 
            {
                root = root.right;
                // the next node to be visited is the leftmost
                while (root != null) 
                {
                    s.push(root);
                    root = root.left;
                }
            }
        }
	}
	
	public static void main(String[] args) {
		
		InorderTraversalWithoutRecursion tree = new InorderTraversalWithoutRecursion();
        tree.root = new Node(1);
        tree.root.left = new Node(2);
        tree.root.right = new Node(3);
        tree.root.left.left = new Node(4);
        tree.root.left.right = new Node(5);
        
        tree.inorder();
	}
}
