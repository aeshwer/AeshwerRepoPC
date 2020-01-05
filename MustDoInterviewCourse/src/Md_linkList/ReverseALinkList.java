package Md_linkList;

public class ReverseALinkList {

	static class Node {
		int data;
		Node next;

		Node(int d) {
			data = d;
			next = null;
		}
	}

	Node reverseList(Node head) {
		Node pre = null;
		Node current = head;
		Node next = null;

		while (current != null) {
			next = current.next;
			current.next = pre;
			pre = current;
			current = next;

		}

		return pre;
	}

	public static void main(String[] args) {

	}
}
