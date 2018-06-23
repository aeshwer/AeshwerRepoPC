package LinkListProblems;

import LinkListProblems.FindMiddleElementOfLinkList.Node;

public class RotateLinkList {

	Node head;
	class Node
	{
		Node next;
		private int data;
		public Node(int data) {
			this.data = data;
			this.next = null;
		}
	}

	private void pushInFront(int data) {
		Node newNode = new Node(data); 
		newNode.next = head;
		head = newNode;
	}

	private void printLinkList() {

		Node temp = head;
		while(temp!=null)
		{
			System.out.print(temp.data +" ");
			temp = temp.next;
		}

	}

	private void rotate(int k) {
		if (k == 0) return;

		// Let us understand the below code for example k = 4
		// and list = 10->20->30->40->50->60.
		Node current  = head;

		// current will either point to kth or NULL after this
		// loop. current will point to node 40 in the above example
		int count = 1;
		while (count < k && current !=  null)
		{
			current = current.next;
			count++;
		}

		// If current is NULL, k is greater than count
		// of nodes in linked list. Don't change the list in this case
		if (current == null)
			return;

		// current points to kth node. Store it in a variable.
		// kthNode points to node 40 in the above example
		Node kthNode = current;

		// current will point to last node after this loop
		// current will point to node 60 in the above example
		while (current.next != null)
			current = current.next;

		// Change next of last node to previous head
		// Next of 60 is now changed to node 10

		current.next = head;

		// Change head to (k+1)th node
		// head is now changed to node 50
		head = kthNode.next;

		// change next of kth node to null
		kthNode.next = null;
	}


	public static void main(String[] args) {
		RotateLinkList  obj = new RotateLinkList();
		obj.pushInFront(60);
		obj.pushInFront(50);
		obj.pushInFront(40);
		obj.pushInFront(30);
		obj.pushInFront(20);
		obj.pushInFront(10);

		obj.printLinkList();
		obj.rotate(4);
		System.out.println();
		//assuming k is smaller than link list length
		System.out.println("After rotation by k times counterclosewise :  k is "+ 4) ;
		obj.printLinkList();

	}

}
