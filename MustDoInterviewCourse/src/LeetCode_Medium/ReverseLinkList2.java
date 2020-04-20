package LeetCode_Medium;

public class ReverseLinkList2 {

	public static class ListNode {
		int val;
		ListNode next;

		ListNode(int x) {
			val = x;
		}
	}

	public static ListNode reverseBetween(ListNode head, int m, int n) {
		if (head == null)
			return null;
		
		ListNode dummy = new ListNode(0); // create a dummy node to mark the head of this list
		dummy.next = head;
		
		ListNode pre = dummy; // make a pointer pre as a marker for the node before reversing
		for (int i = 0; i < m - 1; i++)
			pre = pre.next;

		ListNode start = pre.next; // a pointer to the beginning of a sub-list that will be reversed
		ListNode then = start.next; // a pointer to a node that will be reversed

		// 1 - 2 -3 - 4 - 5 ; m=2; n =4 ---> pre = 1, start = 2, then = 3
		// dummy-> 1 -> 2 -> 3 -> 4 -> 5

		for (int i = 0; i < n - m; i++) {
			start.next = then.next;
			then.next = pre.next;
			pre.next = then;
			then = start.next;
		}

		// first reversing : dummy->1 - 3 - 2 - 4 - 5; pre = 1, start = 2, then = 4
		// second reversing: dummy->1 - 4 - 3 - 2 - 5; pre = 1, start = 2, then = 5
		// (finish)

		return dummy.next;
	}

	public static void printList(ListNode head) {

		while (head != null) {
			System.out.print(head.val + "->");
			head = head.next;
		}

		System.out.println();
	}

	public static void main(String[] args) {

		ListNode head = new ListNode(3);
		head.next = new ListNode(5);
		// head.next.next = new ListNode(3);
		// head.next.next.next = new ListNode(4);
		// head.next.next.next.next = new ListNode(5);
		System.out.println("INPUT :  ");
		printList(head);

		ListNode res = reverseBetween(head, 1, 2);
		System.out.println("OUTPUT :  ");
		printList(res);

	}
}
