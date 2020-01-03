package Md_linkList;

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
		if (head != null) {
			for (int i = 1; i <= k - 1; i++) {
				if (tempHead1.next == null) {
					tempHead1.next = head;
					continue;
				}
				tempHead1 = tempHead1.next;
			}

			if (tempHead1.next != null) {
				head = tempHead1.next;
				tempHead1.next = null;
				}

			Node newHeadTemp = head;
			while (newHeadTemp.next != null) {
				newHeadTemp = newHeadTemp.next;
			}

			newHeadTemp.next = initialHead;
			return head;

		} else {
			return null;
		}

	}

	public static void main(String[] args) {

	}

}
