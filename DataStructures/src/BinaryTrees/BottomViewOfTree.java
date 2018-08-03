/*https://www.geeksforgeeks.org/bottom-view-binary-tree/
For the above tree the output should be 5 10 4 14 25.*/

package BinaryTrees;

import java.util.Iterator;
import java.util.LinkedList;
import java.util.Map;
import java.util.Map.Entry;

import BinaryTrees.CountLeafNodes.Node;

import java.util.Queue;
import java.util.Set;
import java.util.TreeMap;

public class BottomViewOfTree {

	Node root;
	public static class Node
	{
		private int data;
		int hd;
		private Node left ,right; 

		public Node(int data) {
			this.data = data;
			hd= Integer.MAX_VALUE; 
			left = right =null;
		}
	}

	  // Method that prints the bottom view. : Level order Traversal + Vertical Tree Print logic
    public void printBottomView(Node root)
    {
        if (root == null)
            return;
 
        // Initialize a variable 'hd' with 0 for the root element.
        int hd = 0;
 
        // TreeMap which stores key value pair sorted on key value
        Map<Integer, Integer> map = new TreeMap<>();
 
         // Queue to store tree nodes in level order traversal
        Queue<Node> queue = new LinkedList<Node>();
 
        // Assign initialized horizontal distance value to root
        // node and add it to the queue.
        root.hd = hd;
        queue.add(root);
 
        // Loop until the queue is empty (standard level order loop)
        while (!queue.isEmpty())
        {
            Node temp = queue.remove();
 
            // Extract the horizontal distance value from the
            // dequeued tree node.
            hd = temp.hd;
 
            // Put the dequeued tree node to TreeMap having key
            // as horizontal distance. Every time we find a node
            // having same horizontal distance we need to replace
            // the data in the map.
            map.put(hd, temp.data);
 
            // If the dequeued node has a left child add it to the
            // queue with a horizontal distance hd-1.
            if (temp.left != null)
            {
                temp.left.hd = hd-1;
                queue.add(temp.left);
            }
            // If the dequeued node has a left child add it to the
            // queue with a horizontal distance hd+1.
            if (temp.right != null)
            {
                temp.right.hd = hd+1;
                queue.add(temp.right);
            }
        }
 
        // Extract the entries of map into a set to traverse
        // an iterator over that.
        Set<Entry<Integer, Integer>> set = map.entrySet();
 
        // Make an iterator
        Iterator<Entry<Integer, Integer>> iterator = set.iterator();
 
        // Traverse the map elements using the iterator.
        while (iterator.hasNext())
        {
            Map.Entry<Integer, Integer> me = iterator.next();
            System.out.print(me.getValue()+" ");
        }
    }

	public static void main(String[] args) {
		BottomViewOfTree tree = new BottomViewOfTree();
		tree.root = new Node(20);
		tree.root.left = new Node(8);
        tree.root.right = new Node(22);
        tree.root.left.left = new Node(5);
        tree.root.left.right = new Node(3);
        tree.root.right.left = new Node(4);
        tree.root.right.right = new Node(25);
        tree.root.left.right.left = new Node(10);
        tree.root.left.right.right = new Node(14);
        System.out.println("Bottom view of the given binary tree:");
		tree.printBottomView(tree.root);
	}
}
