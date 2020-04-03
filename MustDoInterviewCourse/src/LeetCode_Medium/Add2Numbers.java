package LeetCode_Medium;

import java.math.BigInteger;

public class Add2Numbers {

	public static class ListNode {
		int val;
		ListNode next;

		ListNode(int x) {
			val = x;
		}
	}

	public static ListNode addTwoNumbers(ListNode l1, ListNode l2) {

		ListNode dummy = new ListNode(0);
		ListNode res = dummy;
		int carry = 0;
		while (l1 != null || l2 != null || carry != 0) {
			int sum = ((l2 == null) ? 0 : l2.val) + ((l1 == null) ? 0 : l1.val) + carry;
			int val = sum % 10;
			carry = sum / 10;
			dummy.next = new ListNode(val);
			dummy = dummy.next;

			l1 = (l1 == null) ? l1 : l1.next;
			l2 = (l2 == null) ? l2 : l2.next;
		}
		return res.next;

	}

	public static void main(String[] args) {
		ListNode l1 = new ListNode(2);
		l1.next = new ListNode(4);
		l1.next.next = new ListNode(3);

		ListNode l2 = new ListNode(5);
		l2.next = new ListNode(6);
		// Print Results
		ListNode addTwoNumbers = addTwoNumbers(l1, l2);
		while (addTwoNumbers != null) {
			System.out.print(addTwoNumbers.val + " ");
			addTwoNumbers = addTwoNumbers.next;
		}
	}
}