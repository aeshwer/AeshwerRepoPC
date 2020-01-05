package Md_linkList;

import java.util.Scanner;

public class CheckIfListIsPalindrome {
	Node head;

	static class Node {
		int data;
		Node next;

		Node(int d) {
			data = d;
			next = null;
		}
	}

	/* Function to print linked list */
	void printList(Node head) {
		Node temp = head;
		while (temp != null) {
			System.out.print(temp.data + " ");
			temp = temp.next;
		}
		System.out.println();
	}

	/* Inserts a new Node at front of the list. */
	public void addToTheLast(Node node) {
		if (head == null) {
			head = node;
		} else {
			Node temp = head;
			while (temp.next != null)
				temp = temp.next;
			temp.next = node;
		}
	}

	public static void main(String args[]) {
		Scanner sc = new Scanner(System.in);
		int t = sc.nextInt();

		while (t > 0) {
			int n = sc.nextInt();
			// int k = sc.nextInt();
			CheckIfListIsPalindrome llist = new CheckIfListIsPalindrome();
			// int n=Integer.parseInt(br.readLine());
			int a1 = sc.nextInt();
			Node head = new Node(a1);
			llist.addToTheLast(head);
			for (int i = 1; i < n; i++) {
				int a = sc.nextInt();
				llist.addToTheLast(new Node(a));
			}

			CheckIfListIsPalindrome g = new CheckIfListIsPalindrome();
			if (g.isPalindrome(llist.head) == true)
				System.out.println(1);
			else
				System.out.println(0);
			t--;
		}

	}

	// Function to check if linked list is palindrome
	boolean isPalindrome(Node head) {
		if (head != null) {
			// First Get the middle of the LinkList
			Node slow = head;
			Node fast = head;
			while (fast != null && fast.next != null) {
				slow = slow.next;
				fast = fast.next.next;

			}

			Node middle = slow;
			Node start = head;

			middle = GetReverseList(middle.next);
			while (middle != null) {
				if (start.data != middle.data) {
					return false;
				}
				start = start.next;
				middle = middle.next;
			}

			if (start != slow && start.data != slow.data) {
				return false;
			}
		}
		return true;
	}

	private Node GetReverseList(Node head) {
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

}
