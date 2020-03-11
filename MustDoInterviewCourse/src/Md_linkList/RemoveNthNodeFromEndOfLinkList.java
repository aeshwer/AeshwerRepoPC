package Md_linkList;

public class RemoveNthNodeFromEndOfLinkList {
	public static class ListNode {
		int val;
		ListNode next;

		ListNode(int x) {
			val = x;
		}
	}

	public static ListNode removeNthFromEnd(ListNode head, int n) {
		int len = 0;
		ListNode temp = head;
		while (temp != null) {
			temp = temp.next;
			len++;
		}
		if (len - n == 0) {
			return head.next;
		}
		int fromStart = len - n - 1;

		temp = head;
		while (temp != null) {
			if (fromStart == 0) {
				temp.next = temp.next.next;
			} else {
				temp = temp.next;
			}
			fromStart--;

		}

		return head;

	}

	public static void main(String[] args) {
		ListNode head = new ListNode(1);
		//head.next = new ListNode(2);
		// head.next.next = new ListNode(3);
		// head.next.next.next = new ListNode(4);
		// head.next.next.next.next = new ListNode(5);

		System.out.println("Inital list");
		printList(head);
		head= removeNthFromEnd(head, 1);
		System.out.println("Inital removing nth last ");
		printList(head);
	}

	private static void printList(ListNode head) {

		while (head != null) {
			System.out.print(head.val + " ");
			head = head.next;
		}
		System.out.println();

	}
}