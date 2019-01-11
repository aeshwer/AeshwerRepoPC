package BinaryTrees;
import java.util.LinkedList;
import java.util.NoSuchElementException;
import java.util.Queue;

/*
 * For each node, first the node is visited and then it’s child nodes are put in a FIFO queue
 */

public class LevelOrderTransversal {

	
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
	
	/* Given a binary tree. Print its nodes in level order
    using array for implementing queue  */
	void printLevelOrder() throws NoSuchElementException 
	{
		Queue<Node> queue = new LinkedList<Node>();
        queue.add(root);
        while (!queue.isEmpty()) 
        {
        	/* poll() removes the present head.
            For more information on poll() visit 
            http://www.tutorialspoint.com/java/util/linkedlist_poll.htm */
            Node tempNode = queue.remove(); // learn difference between poll and remove
            System.out.print(tempNode.key + " ");
            
            /*Enqueue left child */
            if (tempNode.left != null) {
                queue.add(tempNode.left);
            }
 
            /*Enqueue right child */
            if (tempNode.right != null) {
                queue.add(tempNode.right);
            }
        }
	} 
	
	
	public static void main(String[] args) throws NoSuchElementException  {

		LevelOrderTransversal tree = new LevelOrderTransversal();
        tree.root = new Node(1);
        tree.root.left = new Node(2);
        tree.root.right = new Node(3);
        tree.root.left.left = new Node(4);
        tree.root.left.right = new Node(5);
        
        System.out.println("Level order traversal of binary tree is - ");
        tree.printLevelOrder();
        
	}
}
