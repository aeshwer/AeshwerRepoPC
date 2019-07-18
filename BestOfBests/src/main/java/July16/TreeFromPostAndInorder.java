package July16;

public class TreeFromPostAndInorder {

	public static class Node {
		int data;
		Node left, right;

		Node(int item) {
			data = item;
			left = right = null;
		}
	}

	public static class Index {
		int index;
	}

	private Node buildTreeUtil(int[] in, int[] post, int start, int end, Index postIndex) {
		if (start > end) {
			return null;
		}

		Node tNode = new Node(post[postIndex.index--]);
		
		if (start == end) {
			return tNode;
		}

		int inIndex = findInIndex(in, start, end, tNode.data);

		tNode.right = buildTreeUtil(in, post, inIndex + 1, end, postIndex);
		tNode.left = buildTreeUtil(in, post, start, inIndex - 1, postIndex);

		return tNode;
	}

	private int findInIndex(int[] in, int start, int end, int data) {
		int i;
		for (i = start; i <= end; i++) {
			if (in[i] == data)
				return i;
		}
		return i;
	}

	private Node buildTree(int[] in, int[] post, int n) {
		Index pIndex = new Index();
		pIndex.index = n - 1;
		return buildTreeUtil(in, post, 0, n - 1, pIndex);
	}

	private void printPreOrder(Node root) {

		if (root == null)
			return;

		System.out.print(root.data + " ");
		printPreOrder(root.left);
		printPreOrder(root.right);

	}

	public static void main(String args[]) {
		TreeFromPostAndInorder tree = new TreeFromPostAndInorder();
		int in[] = new int[] { 4, 8, 2, 5, 1, 6, 3, 7 };
		int post[] = new int[] { 8, 4, 5, 2, 6, 7, 3, 1 };
		int n = in.length;
		Node root = tree.buildTree(in, post, n);
		System.out.println("Preorder of the constructed tree : ");
		tree.printPreOrder(root);
	}

}
