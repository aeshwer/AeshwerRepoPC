//https://www.geeksforgeeks.org/lowest-common-ancestor-binary-tree-set-1/

/*
 * The idea is to traverse the tree starting from root. If any of the given keys (n1 and n2) 
 * matches with root, then root is LCA (assuming that both keys are present). If root doesn’t
 * match with any of the keys, we recur for left and right subtree. The node which has one key 
 * present in its left subtree and the other key present in right subtree is the LCA.
 * If both keys lie in left subtree, then left subtree has LCA also, otherwise LCA lies in right subtree.
 */
package TopProblems;
public class LowestCommonAncestorInBST {

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

	 // This function returns pointer to LCA of two given
    // values n1 and n2. This function assumes that n1 and
    // n2 are present in Binary Tree
	private Node findLCA(Node root , int n1,int n2) {

		// Base case
        if (root == null)
            return null;
 
        // If either n1 or n2 matches with root's key, report
        // the presence by returning root (Note that if a key is
        // ancestor of other, then the ancestor key becomes LCA
        if (root.key == n1 || root.key == n2)
            return root;
 
        // Look for keys in left and right subtrees
        Node left_lca = findLCA(root.left, n1, n2);
        Node right_lca = findLCA(root.right, n1, n2);
 
        // If both of the above calls return Non-NULL, then one key
        // is present in one subtree and other is present in other,
        // So this node is the LCA
        if (left_lca!=null && right_lca!=null)
            return root;
 
        // Otherwise check if left subtree or right subtree is LCA
        return (left_lca != null) ? left_lca : right_lca;
	}

	public static void main(String[] args) {

		LowestCommonAncestorInBST tree = new LowestCommonAncestorInBST();
		tree.root = new Node(1);
		tree.root.left = new Node(2);
		tree.root.right = new Node(3);
		tree.root.left.left = new Node(4);
		tree.root.left.right = new Node(5);
		tree.root.right.left = new Node(6);
		tree.root.right.right = new Node(7);

		System.out.println("LCA(4, 5): " + tree.findLCA(tree.root,4,5).key);
        System.out.println("LCA(4, 6): " + tree.findLCA(tree.root,4,6).key);
        System.out.println("LCA(3, 4): " + tree.findLCA(tree.root,3,4).key);
        System.out.println("LCA(2, 4): " + tree.findLCA(tree.root,2,4).key);
	}
}
