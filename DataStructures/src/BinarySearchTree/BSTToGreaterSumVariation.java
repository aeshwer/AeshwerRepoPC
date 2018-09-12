//https://www.geeksforgeeks.org/convert-bst-to-a-binary-tree/
package BinarySearchTree;

public class BSTToGreaterSumVariation {
	
	public static int sum = 0;	
	Node root;
	public static class Node {
		int key;
		Node left, right;

		public Node(int item) {
			key = item;
			left = right = null;
		}
	}

	void printPreorder(Node root)
	{
		if (root == null)
			return;

		/* first print data of node */
		System.out.print(root.key + " ");

		/* then recur on left subtree */
		printPreorder(root.left);

		/* now recur on right subtree */
		printPreorder(root.right);
	}

	// Use reverse IN-order, i.e (R Root L) 
	public void convertToGreaterSumTree(Node root)
	{
		// Base case
		if (root == null)  return;

		// Recur for right subtree
		convertToGreaterSumTree(root.right);

		int temp = root.key;

		//update the sum, sum till previous visited node
		root.key = temp + sum;
		//update the sum for the next node
		sum = sum + temp;

		// Recur for left subtree
		convertToGreaterSumTree(root.left);
	}

	public static void main(String[] args) {
		BSTToGreaterSumVariation tree = new BSTToGreaterSumVariation();

		/* Let us create following BST
              20
           /     \
          10      30
         /  \      
       5   	11     	 */
		tree.root = new Node(20);
		tree.root.left = new Node(10);
		tree.root.right = new Node(30);
		tree.root.left.left = new Node(5);
		tree.root.left.right = new Node(11);

		tree.printPreorder(tree.root);
		tree.convertToGreaterSumTree(tree.root);
		System.out.println();
		tree.printPreorder(tree.root);
	}

}
