package Md_linkList;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class ReverseAListInGroups {
	static Node head;

	static class Node {
		int data;
		Node next;

		Node(int key) {
			data = key;
			next = null;
		}
	}

	public static void printList(Node node) {
		while (node != null) {
			System.out.print(node.data + " ");
			node = node.next;
		}
	}

	public static void addToTheLast(Node node) {
		if (head == null) {
			head = node;
		} else {
			Node temp = head;
			while (temp.next != null)
				temp = temp.next;
			temp.next = node;
		}
	}

	public static void main(String[] args) {

		Scanner sc = new Scanner(System.in);
		int t = sc.nextInt();

		while (t-- > 0) {
			int n = sc.nextInt();
			int a1 = sc.nextInt();
			Node head = new Node(a1);
			addToTheLast(head);
			for (int i = 1; i < n; i++) {
				int a = sc.nextInt();
				addToTheLast(new Node(a));
			}

			int k = sc.nextInt();
			ReverseAListInGroups gfg = new ReverseAListInGroups();
			Node res = gfg.reverse(head, k);
			printList(res);
			System.out.println();
		}

	}

	private Node reverse(Node node, int k) {
		Node temp = node;
		int count = k;

		// Move temp to k+1 node
		while (temp != null && --count >= 0) {
			temp = temp.next;
		}

		List<Node> value = reverseTheListTillKNodeAndReturnLastNode(node, k);
		Node resHead = value.get(0);
		Node end = value.get(1);

		while (temp != null) {
			count=k;
			Node updateTemp = temp;
			while (updateTemp != null && --count >= 0) {
				updateTemp = updateTemp.next;
			}
			List<Node> location = reverseTheListTillKNodeAndReturnLastNode(temp, k);
			Node first = location.get(0);
			Node last = location.get(1);
			end.next = first;
			end = last;
			temp = updateTemp;
		}

		return resHead;
	}

	public static List<Node> reverseTheListTillKNodeAndReturnLastNode(Node headFront, int k) {
		Node pre = null;
		Node current = headFront;
		Node next = null;

		while (current != null && k-- > 0) {
			next = current.next;
			current.next = pre;
			pre = current;
			current = next;
		}

		Node start = pre;
		while (pre != null && pre.next != null) {
			pre = pre.next;
		}
		Node end = pre;
		List<Node> res = new ArrayList<>();
		res.add(start);
		res.add(end);
		return res;
	}
	
}
