// https://www.geeksforgeeks.org/print-binary-tree-vertical-order-set-2/
//Time complexcity : nlog(n)
package TopProblems;
import java.util.ArrayList;
import java.util.Map.Entry;
import java.util.TreeMap;

public class VerticalPrintBinaryTree {

	Node root;
	public static class Node
	{
		private int key;
		private Node left ,right; 

		public Node(int key) {
			this.key = key;
			left = right =null;
		}
	}

	private void printVeritcalView(Node root) {
		TreeMap<Integer, ArrayList<Integer>> map = new TreeMap<Integer, ArrayList<Integer>>();
		int horizontalDistance = 0;
		getVerticalOrder(root,horizontalDistance,map);
		// Try using HashMap...u will get incorrect output since only Tree sorts the map on basic of key  
		//https://dzone.com/articles/hashmap-vs-treemap-vs
		
		// Traverse the map and print nodes at every horizontal distance (hd)
        for (Entry<Integer, ArrayList<Integer>> entry : map.entrySet())
        {
            System.out.println(entry.getValue());
        }
	}

	// basic behind is pre order traversal
	private void getVerticalOrder(Node root, int hd,
			TreeMap<Integer, ArrayList<Integer>> map) {
		
		// Base case
        if(root == null)
            return;
         
        //get the Array list at 'hd'
        ArrayList<Integer> list =  map.get(hd);
         
        // Store current node in map 'm'
        if(list == null)
        {
        	list = new ArrayList<>();
        	list.add(root.key);
        }
        else
        {
        	list.add(root.key);
        }
         
        map.put(hd, list);
         
        // Store nodes in left subtree
        getVerticalOrder(root.left, hd-1, map);
         
        // Store nodes in right subtree
        getVerticalOrder(root.right, hd+1, map);
				
	}

	public static void main(String[] args) {

		VerticalPrintBinaryTree tree = new VerticalPrintBinaryTree();
		tree.root = new Node(1);
		tree.root.left = new Node(2);
		tree.root.right = new Node(3);
		tree.root.left.left = new Node(4);
		tree.root.left.right = new Node(5);
		tree.printVeritcalView(tree.root);
	}
}
