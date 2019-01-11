package BinaryTrees;

/*
 * Use Postorder for this, because before deleting the parent node we should delete its children nodes first
 */
public class DeleteATree {
	
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
	
     void deleteTree(Node root){
		
    	 if(root == null )
    	 {
    		 return ;
    	 }
    	 
    	 /* first delete both subtrees */
    	 deleteTree(root.left);
    	 deleteTree(root.right);
    	 
    	 /* then delete the node */
         System.out.println("The deleted node is " + root.key);
         root = null;
	}
     
     /* Wrapper function that deletes the tree and sets root node as null .*/
     void deleteTreeRef(Node nodeRef)
     {
    	 deleteTree(nodeRef);
    	 nodeRef = null;
     }
	
	public static void main(String[] args) {
		
		DeleteATree tree = new DeleteATree();
        tree.root = new Node(1);
        tree.root.left = new Node(2);
        tree.root.right = new Node(3);
        tree.root.left.left = new Node(4);
        tree.root.left.right = new Node(5);
        
        /* Note that we pass root node here */
        tree.deleteTreeRef(tree.root);
        
	}
}
