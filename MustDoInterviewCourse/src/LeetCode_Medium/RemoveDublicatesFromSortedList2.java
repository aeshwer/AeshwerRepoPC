package LeetCode_Medium;

public class RemoveDublicatesFromSortedList2 {

	public static class ListNode {
		int val;
		ListNode next;

		ListNode(int x) {
			val = x;
		}
	}

	public static ListNode deleteDuplicates(ListNode head) {
		if (head == null || head.next == null)
			return head;

		ListNode res = new ListNode(Integer.MAX_VALUE);
		ListNode dummy = res;
		ListNode preNode = res;

		while (head != null) {
			if (preNode.val == head.val) {
				head = head.next;
			} else {
				preNode = head;
				if (head.next == null) {
					res.next = head;
					res = head;
					break;
				} else if (head.next != null && head.next.val == preNode.val) {
					head = head.next;
				} else if (head.next != null && head.next.val != preNode.val) {
					res.next = head;
					res = head;
					head = head.next;
				}
			}
		}

		res.next = null;
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
		ListNode head = new ListNode(1);
		head.next = new ListNode(2);
		head.next.next = new ListNode(3);
		head.next.next.next = new ListNode(3);
		head.next.next.next.next = new ListNode(4);
		head.next.next.next.next.next = new ListNode(5);
		System.out.println("INPUT :  ");
		printList(head);

		ListNode res = deleteDuplicates(head);
		System.out.println("OUTPUT :  ");
		printList(res);

	}
}
