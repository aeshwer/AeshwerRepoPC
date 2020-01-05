package Md_linkList;

import java.util.Scanner;

public class StackUsingLinkList {

	StackNode top;

	static class StackNode {
		int data;
		StackNode next;

		StackNode(int a) {
			data = a;
			next = null;
		}
	}

	// Note that top is by default null in Java
	void push(int a) {
		StackNode newNode = new StackNode(a);
		if (top == null) {
			top = newNode;
		} else {
			newNode.next = top;
			top = newNode;
		}
	}

	int pop() {
		int num = -1;
		if (top != null) {
			num = top.data;
			top = top.next;
		}
		return num;
	}

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int t = sc.nextInt();
		while (t > 0) {
			StackUsingLinkList obj = new StackUsingLinkList();
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