package BinaryTrees;

import BinaryTrees.RootToLeafPath.Node;

public class RootToLeafPathSum {
	
	final int sum = 21;
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
	
	void rootToLeafPaths(Node root, int[] path,int pathLen)
	{
		if (root == null)
 		{
 			return ;
 		}
		
		 /* append this node to the path array */
        path[pathLen] = root.key;
        pathLen++;
        
        /* it's a leaf, so check the path that led to here for the sum */
        if (root.left == null && root.right == null)
            CheckSumArray(path, pathLen);
        else
        { 
        /* otherwise try both subtrees */
    	rootToLeafPaths(root.left, path, pathLen);
    	rootToLeafPaths(root.right, path, pathLen);
        }
	}
	
	void CheckSumArray(int[] path,int pathLen)
	{
        int sumTemp = sum;
        for (int i = 0; i < pathLen; i++)
        {
        	sumTemp = sumTemp -path[i]; 
        } 
        if(sumTemp ==0){System.out.println("There exists a path with this sum ");}
        else System.out.println("FALSE ");
    }
	
	void printPaths(Node root) 
	{
		int path[] = new int[1000];
		rootToLeafPaths(root, path, 0);
	}
	
	public static void main(String[] args) {
		
		RootToLeafPathSum tree = new RootToLeafPathSum();
		tree.root = new Node(10);
        tree.root.left = new Node(8);
        tree.root.right = new Node(2);
        tree.root.left.left = new Node(3);
        tree.root.left.right = new Node(5);
        tree.root.right.left = new Node(2);
        
        /* Print all root-to-leaf paths of the input tree */
        tree.printPaths(tree.root);
	}
}
