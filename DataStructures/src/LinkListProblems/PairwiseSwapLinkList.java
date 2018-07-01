// https://www.geeksforgeeks.org/pairwise-swap-elements-of-a-given-linked-list/
package LinkListProblems;

public class PairwiseSwapLinkList {

	Node head; 
	public static class Node {
		int data;
		Node next;
		Node(int data) {
			this.data = data;
			this.next = null;
		}
	}

	void printlist(Node node) {
		while (node != null) {
			System.out.print(node.data + " ");
			node = node.next;
		}
	}

	private void pairWiseSwap(Node head) {
		/* There must be at-least two nodes in the list */
		if (head != null && head.next != null)
		{
			/* Swap the node's data with data of next node */
			swap(head, head.next);
			/* Call pairWiseSwap() for rest of the list */
			pairWiseSwap(head.next.next);
		}
	}
	private void swap(Node n1, Node n2) {
		int temp= n2.data;
		n2.data =n1.data;
		n1.data =temp;
	}

	public static void main(String[] args) {
		PairwiseSwapLinkList list = new PairwiseSwapLinkList();
		list.head = new Node(3);
		list.head.next = new Node(7);
		list.head.next.next = new Node(15);
		list.head.next.next.next = new Node(25);
		list.head.next.next.next.next = new Node(30);

		list.printlist(list.head);
		list.pairWiseSwap(list.head);
		System.out.println();
		list.printlist(list.head);
	}
}
