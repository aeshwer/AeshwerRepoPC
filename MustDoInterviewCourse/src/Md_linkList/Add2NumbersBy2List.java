package Md_linkList;

import java.math.BigInteger;
import java.util.Scanner;

public class Add2NumbersBy2List {

	static class Add_LinkedList {
		Node head;

		void printList(Node head) {
			while (head != null) {
				System.out.print(head.data + " ");
				head = head.next;
			}
			// System.out.println("");
		}

		public void push(int new_data) {
			/*
			 * 1 & 2: Allocate the Node & Put in the data
			 */
			Node new_node = new Node(new_data);
			/* 3. Make next of new Node as head */
			new_node.next = head;
			/* 4. Move the head to point to new Node */
			head = new_node;
		}

		public static void main(String[] args) {
			Scanner sc = new Scanner(System.in);
			int T = sc.nextInt();
			while (T > 0) {
				int n1 = sc.nextInt();
				Add_LinkedList list1 = new Add_LinkedList();
				for (int i = 1; i <= n1; i++) {
					int a = sc.nextInt();
					list1.push(a);
				}
				int n2 = sc.nextInt();
				Add_LinkedList list2 = new Add_LinkedList();
				for (int i = 0; i < n2; i++) {
					int b = sc.nextInt();
					list2.push(b);
				}
				Add_LinkedList list3 = new Add_LinkedList();
				Add2NumbersBy2List g = new Add2NumbersBy2List();
				Node rs = g.addTwoLists(list1.head, list2.head);
				list3.printList(rs);
				System.out.println();
				T--;
			}
		}
	}

	static class Node {
		int data;
		Node next;

		Node(int d) {
			data = d;
			next = null;
		}

	}

	Node addTwoLists(Node first, Node second) {

		// BigInteger sum1 = 0;
		// BigInteger sum2 = 0;
		int c1 = 0;
		int c2 = 0;
		String s1 = "";
		String s2 = "";
		while (first != null) {
			// sum1 = (sum1 + (first.data * Math.pow(10, c1)));
			s1 = String.valueOf(first.data) + s1;
			first = first.next;
			c1++;
		}

		while (second != null) {
			// sum2 = (sum2 + (second.data * Math.pow(10, c2)));
			s2 = String.valueOf(second.data) + s2;
			second = second.next;
			c2++;
		}

		// double totalSum = sum1 + sum2;
		BigInteger totalSum = new BigInteger(s1).add(new BigInteger(s2));

		Node dummy = new Node(0);
		Node resHead = dummy;

		while (totalSum.signum()==1) {
			BigInteger[] divideAndRemainder = totalSum.divideAndRemainder(new BigInteger("10"));
			int rem = divideAndRemainder[1].intValue();
			totalSum = divideAndRemainder[0];
			resHead.next = new Node(rem);
			resHead = resHead.next;

		}

		return dummy.next;

	}
}
