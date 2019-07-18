package July16;

public class TreeFromPreAndInorder {
	private static int preIndex = 0;

	public static class Node {
		char data;
		Node left, right;

		Node(char item) {
			data = item;
			left = right = null;
		}
	}

	private Node buildTree(char[] in, char[] pre, int start, int end) {

		if (start > end)
			return null;

		Node tNode = new Node(pre[preIndex++]);

		if (start == end)
			return tNode;

		int inIndex = findInInorder(in, start, end, tNode.data);

		tNode.left = buildTree(in, pre, start, inIndex - 1);
		tNode.right = buildTree(in, pre, inIndex + 1, end);

		return tNode;
	}

	private int findInInorder(char[] in, int start, int end, char data) {
		 int i; 
	        for (i = start; i <= end; i++) { 
	            if (in[i] == data) 
	                return i; 
	        } 
	        return i; 
	}

	private void printInorder(Node root) {

		if (root == null)
			return;

		printInorder(root.left);
		System.out.print(root.data + " ");
		printInorder(root.right);

	}

	public static void main(String args[]) {
		TreeFromPreAndInorder tree = new TreeFromPreAndInorder();
		char in[] = new char[] { 'D', 'B', 'E', 'A', 'F', 'C' };
		char pre[] = new char[] { 'A', 'B', 'D', 'E', 'C', 'F' };
		int len = in.length;
		Node root = tree.buildTree(in, pre, 0, len - 1);

		// building the tree by printing inorder traversal
		System.out.println("Inorder traversal of constructed tree is : ");
		tree.printInorder(root);
	}

}
