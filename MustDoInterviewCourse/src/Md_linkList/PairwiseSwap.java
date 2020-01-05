package Md_linkList;

public class PairwiseSwap {

	static class Node {
		int data;
		Node next;

		Node(int d) {
			data = d;
			next = null;
		}
	}

	public static Node pairwise_swap(Node head) {

		if (head != null) {

			Node first = head;
			Node second = head.next;

			while (first != null && second != null) {
				int temp = first.data;
				first.data = second.data;
				second.data = temp;

				first = second.next;
				second = first == null ? null : first.next;

			}
		}
		return head;
	}

}
