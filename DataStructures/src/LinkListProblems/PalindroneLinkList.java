package LinkListProblems;

import LinkListProblems.PairwiseSwapLinkList.Node;

public class PalindroneLinkList {

	Node head; 
	public static class Node {
		int data;
		Node next;
		Node(int data) {
			this.data = data;
			this.next = null;
		}
	}

	void printlist(Node node) {
		while (node != null) {
			System.out.print(node.data + " ");
			node = node.next;
		}
	}


	private boolean IsPalindrome(Node head) {
		//finding middle
		Node slow = head;
		Node fast = head;
		while(fast!=null && fast.next!=null ) 
		{
			slow = slow.next; 
			fast = fast.next.next;
		}
		//slow is now middle and reversing from middle to end
		slow = ReverseLinkList(slow);
		Node temp = head;
		//comparing
		while(temp!=null) 
		{
			if(temp.data!=slow.data)
			{
				return false;
			}
			temp=temp.next;
			slow=slow.next;
		}
		return true;
	}

	private Node ReverseLinkList(Node slow) {
		Node previous = null;
		Node current = slow;
		Node next = null;
		
		if (slow == null || slow.next ==null)
       	{ 	return slow;}
		
		while(current!=null)
		{
			next = current.next;
			current.next = previous;
			previous=current;
			current=next;
		}
		slow=previous;
		return slow;
	}

	public static void main(String[] args) {
		PalindroneLinkList list = new PalindroneLinkList();
		list.head = new Node(1);
		list.head.next = new Node(2);
		list.head.next.next = new Node(3);
		list.head.next.next.next = new Node(2);
		list.head.next.next.next.next = new Node(1);

		list.printlist(list.head);
		System.out.println();
		System.out.println("Is palindrome :  "+list.IsPalindrome(list.head));
	}
}
