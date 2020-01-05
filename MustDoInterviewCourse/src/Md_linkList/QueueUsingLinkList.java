package Md_linkList;

import java.util.Scanner;

public class QueueUsingLinkList {

	QueueNode front, rear;

	static class QueueNode {
		int data;
		QueueNode next;

		QueueNode(int a) {
			data = a;
			next = null;
		}
	}

	// This function should add an item at rear
	void push(int a) {
		if (front == null) {
			front = new QueueNode(a);
			rear = front;
		} else {
			rear.next = new QueueNode(a);
			rear = rear.next;
		}
	}

	// This function should remove front
	// item from queue and should return
	// the removed item.
	int pop() {
		if (front == null) {
			return -1;
		} else {
			int popedData = front.data;
			front = front.next;
			return popedData;
		}
	}

	public static void main(String[] args) {

		Scanner sc = new Scanner(System.in);
		int t = sc.nextInt();
		while (t > 0) {
			QueueUsingLinkList obj = new QueueUsingLinkList();
			int Q = sc.nextInt();
			while (Q > 0) {
				int QueryType = 0;
				QueryType = sc.nextInt();
				if (QueryType == 1) {
					int a = sc.nextInt();

					obj.push(a);

				} else if (QueryType == 2) {
					System.out.print(obj.pop() + " ");
				}
				Q--;
			}
			System.out.println("");
			t--;
		}
	}

}
