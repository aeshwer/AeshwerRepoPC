package Md_linkList;

import Md_linkList.ReverseAListInGroups.Node;

public class RemoveALoopInLinkList {

	static class Node {
		int data;
		Node next;

		Node(int key) {
			data = key;
			next = null;
		}
	}

	// This function will remove the loop from the linked list
	public static void removeTheLoop(Node head) {
		Node slow = head;
		Node fast = head;
		while (slow != null && fast != null && fast.next != null) {
			slow = slow.next;
			fast = fast.next.next;
			if (slow == fast)
				break;
		}

		if (slow == fast) {
			slow = head;
			while (slow.next != fast.next) {
				slow = slow.next;
				fast = fast.next;
			}
			fast.next = null;
		}

	}
}
