package BinaryTrees;
/*
 * HARD LEVEL ::: http://www.geeksforgeeks.org/convert-an-arbitrary-binary-tree-to-a-tree-that-holds-children-sum-property/
 */

public class ConvertTreeToChildSumPropertyTress {
	
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

	
    void convertTree(Node node) 
    {
    	int left_data = 0, right_data = 0, diff;
        /* If tree is empty or it's a leaf node then return true */
        if (node == null || (node.left == null && node.right == null)) {return;}
        else
        {
            // convert left and right subtrees .i.e start the conversion from the lowest leaf nodes
            convertTree(node.left);
            convertTree(node.right);
            
            /* If left child is not present then 0 is used as data of left child */
           if (node.left != null)
               left_data = node.left.key;
            
           /* If right child is not present then 0 is used as data of right child */
           if (node.right != null)
               right_data = node.right.key;
           
           /* get the diff of node's data and children sum */
           diff = left_data + right_data - node.key;
           
           /* If node's children sum is greater than the node's data */
           if (diff > 0)
               node.key = node.key + diff;
 
           /* THIS IS TRICKY --> If node's data is greater than children sum, then increment subtree by diff */
           if (diff < 0)
        	   // -diff is used to make diff positive
               increment(node, -diff);  
        }
    }
    

    /* This function is used to increment subtree by diff */
    void increment(Node node, int diff) 
    {
        /* IF left child is not NULL then increment it */
        if (node.left != null) 
        {
            node.left.key = node.left.key + diff;
            // Recursively call to fix the descendants of node->left
            increment(node.left, diff);
        } 
        else if (node.right != null) // Else increment right child
        {
            node.right.key = node.right.key + diff;
            // Recursively call to fix the descendants of node->right
            increment(node.right, diff);
        }
    }
    
    
    /* Given a binary tree, printInorder() prints out its inorder traversal*/
   void printInorder(Node root) 
   {
       if (root == null)
           return;
            
       /* first recur on left child */
       printInorder(root.left);
 
       /* then print the data of node */
       System.out.print(root.key + " ");
 
       /* now recur on right child */
       printInorder(root.right);
   }
   
	 // Driver program to test above functions
    public static void main(String args[]) 
    {
    	ConvertTreeToChildSumPropertyTress tree = new ConvertTreeToChildSumPropertyTress();
        tree.root = new Node(50);
        tree.root.left = new Node(7);
        tree.root.right = new Node(2);
        tree.root.left.left = new Node(3);
        tree.root.left.right = new Node(5);
        tree.root.right.left = new Node(1);
        tree.root.right.right = new Node(30);
  
        System.out.println("Inorder traversal before conversion is :");
        tree.printInorder(tree.root);
  
        tree.convertTree(tree.root);
        System.out.println("");
  
        System.out.println("Inorder traversal after conversion is :");
        tree.printInorder(tree.root);
  
    }
}
