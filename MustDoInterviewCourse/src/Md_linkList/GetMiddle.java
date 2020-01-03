package Md_linkList;

public class GetMiddle {

	static class Node {
		int data;
		Node next;

		Node(int d) {
			data = d;
			next = null;
		}
	}

	// Function to find middle element a linked list
	int getMiddle1(Node head) {
		Node tempHead = head;
		int count = 0;
		while (tempHead != null) {
			tempHead = tempHead.next;
			count++;
		}
		if (count % 2 == 0) {
			count = count + 1;
		}
		count = count / 2;

		while (--count >= 0) {
			head = head.next;
		}

		return head.data;
	}

	// Can also be done using 2 pointers- move 1 pointer by 1 and other by 2.whenfast pointer
	// reaches end , the mid pointer reaches mid
	int getMiddle2(Node head) {
		Node slowPointer = head;
		Node fastPointer = head;
		int count = 0;
		while (fastPointer != null && fastPointer.next != null) {
			slowPointer = slowPointer.next;
			fastPointer = fastPointer.next.next;
			count++;
		}
		
		while (--count >= 0) {
			head = head.next;
		}

		return head.data;
	}

	public static void main(String[] args) {

	}
}
