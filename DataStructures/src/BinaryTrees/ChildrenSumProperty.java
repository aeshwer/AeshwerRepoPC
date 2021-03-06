package BinaryTrees;

/*
 * For every node, data value must be equal to sum of data values in left and right children. 
 * Consider data value as 0 for NULL children. Below tree is an example
 */

public class ChildrenSumProperty {
	
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
	
	boolean isSumProperty(Node root)
	{
        /* left_data is left child data and right_data is for right 
           child data*/
        int left_data = 0, right_data = 0;
		if(root == null || (root.left == null && root.right == null))
		{
			return true;
		}
		else
		{  
            /* If left child is not present then 0 is used as data of left child */
         if (root.left != null) 
             left_data = root.left.key;

         /* If right child is not present then 0 is used as data of right child */
         if (root.right != null) 
             right_data = root.right.key;

         /* if the node and both of its children satisfy the property return true else false*/
         if ((root.key == left_data + right_data) && (isSumProperty(root.left) !=  false) && (isSumProperty(root.right) != false))
             return true;
         else
             return false;
		}
	}
	
	public static void main(String[] args) {

		ChildrenSumProperty tree = new ChildrenSumProperty();
		tree.root = new Node(10);
        tree.root.left = new Node(8);
        tree.root.right = new Node(2);
        tree.root.left.left = new Node(3);
        tree.root.left.right = new Node(5);
        tree.root.right.right = new Node(2);
        
        System.out.println("The sum Property is ::" +tree.isSumProperty(tree.root));
	}
}
