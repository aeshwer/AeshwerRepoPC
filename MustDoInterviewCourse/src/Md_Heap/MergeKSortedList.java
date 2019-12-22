package Md_Heap;

import java.util.Comparator;
import java.util.PriorityQueue;
import java.util.Scanner;
//https://practice.geeksforgeeks.org/problems/merge-k-sorted-linked-lists/1/?track=md-heap&batchId=144
/*I/P
1
4
3 1 2 3 2 4 5 2 5 6 2 7 8
Output:
1 2 3 4 5 5 6 7 8*/
public class MergeKSortedList {

	public static class Node {
		int data;
		Node next;

		Node(int key) {
			data = key;
			next = null;
		}
	}

	public static class MergeLL {
		static Node head;

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

		public static void printList(Node node) {
			if (node == null)
				return;
			while (node != null) {
				System.out.print(node.data + " ");
				node = node.next;
			}
		}

		public static void main(String[] args) {
			Scanner sc = new Scanner(System.in);

			int t = sc.nextInt();
			while (t-- > 0) {
				int N = sc.nextInt();
				Node[] a = new Node[N];
				for (int i = 0; i < N; i++) {
					int n = sc.nextInt();
					int p = sc.nextInt();
					Node start = null, cur = null;
					Node head = new Node(p);
					start = head;
					cur = head;
					for (int j = 1; j < n; j++) {
						int a1 = sc.nextInt();
						Node ptr = new Node(a1);
						cur.next = ptr;
						cur = ptr;
					}
					a[i] = start;
				}
				Node start = a[0];
				Merge g = new Merge();

				Node res = g.mergeKList(a, N);
				if (res != null)
					printList(res);
				System.out.println();

			}

		}
	}

	/*
	 * a is an array of Nodes of the heads of linked lists and N is size of array a
	 */
	public static class ArrayEntry {

		Node node;
		int index;

		public ArrayEntry(Node node, int index) {
			this.node = node;
			this.index = index;
		}
	}

	public static class Merge {
		Node mergeKList(Node[] a, int N) {
			Node headPointer = new Node(0);
			Node result = headPointer;

			PriorityQueue<ArrayEntry> pq = new PriorityQueue<>(N, new Comparator<ArrayEntry>() {
				@Override
				public int compare(ArrayEntry o1, ArrayEntry o2) {
					return Integer.compare(o1.node.data, o2.node.data);
				}
			});

			// Add first node of all linkList in heap(PriorityQueue)
			for (int i = 0; i < a.length; i++) {
				pq.add(new ArrayEntry(a[i], i));
				a[i] = a[i].next;
			}

			// Keep polling elements from queue and add from linklist whoes element was
			// polled
			while (!pq.isEmpty()) {
				ArrayEntry polledElement = pq.poll();
				result.next = polledElement.node;
				result = result.next;

				int indexOfList = polledElement.index;
				Node newNodeToAdd = a[indexOfList];
				if (newNodeToAdd != null) {
					a[indexOfList] = newNodeToAdd.next;
					pq.add(new ArrayEntry(newNodeToAdd, indexOfList));
				}

			}
			return headPointer.next;
		}
	}
}
