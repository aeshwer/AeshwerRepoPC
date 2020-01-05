package Md_linkList;

import java.util.Scanner;

public class RotateALinkList {

	static class Node {
		int data;
		Node next;

		Node(int d) {
			data = d;
			next = null;
		}
	}

	/*
	 * This function should rotate list counter- clockwise by k and return new head
	 * (if changed)
	 */
	public Node rotate(Node head, int k) {
		Node newHead = head;
		Node prev = null;

		if (head != null) {
			// Get the K and k+1 Node
			for (int i = 0; i < k; i++) {
				if (newHead.next != null) {
					prev = newHead;
					newHead = newHead.next;
				} else {
					prev = null;
					newHead = head;
				}

			}

			/*
			 * if (newHead == null) return head;
			 */
			if (newHead != head) {
				Node tail = newHead;
				while (tail.next != null)
					tail = tail.next;

				tail.next = head;
				prev.next = null;

				return newHead;
			} else {
				return head;
			}
		} else {
			return head;
		}

	}

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int t = sc.nextInt();
		while (t-- > 0) {
			int n = sc.nextInt();
			Node head = null;
			for (int i = 0; i < n; i++) {
				int a = sc.nextInt();
				head = addToTheLast(new Node(a), head);
			}
			int k = sc.nextInt();
			RotateALinkList g = new RotateALinkList();
			head = g.rotate(head, k); // rotate linked list anti-clockwise by k nodes
			printList(head);
		}
	}

	// insert function to build linked list
	public static Node addToTheLast(Node node, Node head) {
		if (head == null) {
			head = node;
		} else {
			Node temp = head;
			while (temp.next != null) {
				temp = temp.next;
			}
			temp.next = node;
		}
		return head;
	}

	public static void printList(Node node) {
		while (node != null) {
			System.out.print(node.data + " ");
			node = node.next;
		}
		System.out.println();
	}

}
