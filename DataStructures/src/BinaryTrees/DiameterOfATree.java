package BinaryTrees;
/*
 * he diameter of a tree (sometimes called the width) is the number of nodes on the longest path between two leaves in the tree
 * http://www.geeksforgeeks.org/diameter-of-a-binary-tree/
 * O(N^2) ..there is another version of this  
 */

public class DiameterOfATree {
	Node root;
	public static class Node
	{
	    int key;
	    Node left, right;
	 
	    public Node(int key)
	    {
	        this.key = key;
	        left = right = null;
	    }
	}
	
	int diameter(Node root)
	{
		if(root== null)
		{return 0;}
		// get the height of left and right sub trees 
        int lheight = height(root.left);
        int rheight = height(root.right);
        

        /* get the diameter of left and right subtrees */
        int ldiameter = diameter(root.left);
        int rdiameter = diameter(root.right);
        
        /* Return max of following three
        1) Diameter of left subtree
       2) Diameter of right subtree
       3) Height of left subtree + height of right subtree + 1 */
      return Math.max(lheight + rheight + 1,Math.max(ldiameter, rdiameter));
	}
	
	 // The function Compute the "height" of a tree. 
	static int height(Node node)
	{
		/* base case tree is empty */
		if (node == null)
          return 0;

      /* If tree is not empty then height = 1 + max of left
         height and right heights */
      return (1 + Math.max(height(node.left), height(node.right)));
	}
  
	public static void main(String[] args) {
		
        /* creating a binary tree and entering the nodes */
		DiameterOfATree tree = new DiameterOfATree();
        tree.root = new Node(1);
        tree.root.left = new Node(2);
        tree.root.right = new Node(3);
        tree.root.left.left = new Node(4);
        tree.root.left.right = new Node(5);
 
        System.out.println("The diameter of given binary tree is : "+ tree.diameter(tree.root));
    }

}
