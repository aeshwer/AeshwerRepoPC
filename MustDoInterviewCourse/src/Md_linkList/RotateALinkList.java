package Md_linkList;

import Md_linkList.NthNodeFromEnd.Node;

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
		Node initialHead = head;
		Node tempHead1 = head;

		// Get to the kth node
		for (int i = 1; i <= k - 1; i++) {
			tempHead1 = tempHead1.next;
			if(tempHead1 == null) return null;
		}
		head = tempHead1.next;
		tempHead1.next = null;

		Node newHeadTemp = head;
		while (newHeadTemp.next != null) {
			newHeadTemp = newHeadTemp.next;
		}

		newHeadTemp.next = initialHead;
		return head;
	}

	public static void main(String[] args) {

	}

}
