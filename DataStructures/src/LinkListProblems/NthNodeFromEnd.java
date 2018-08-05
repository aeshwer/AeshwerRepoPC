//https://www.geeksforgeeks.org/nth-node-from-the-end-of-a-linked-list/
package LinkListProblems;

public class NthNodeFromEnd {

	Node head;
	class Node
	{
		private int data;
		private Node next;

		public Node(int data) {
			this.data = data;
			this.next=null;
		}
	}

	/* Inserts a new Node at front of the list. */
	public void push(int new_data)
	{
		Node new_node = new Node(new_data);
		new_node.next = head;
		head = new_node;
	}

	void PrintLinkList()
	{
		Node tnode= head;
		while(tnode!=null)
		{
			System.out.print(tnode.data + " ");
			tnode=tnode.next;
		}
	}

	private void findNthNodeFromEnd(int n) {
		int len = 0;
		Node temp = head;
		// 1) count the number of nodes in Linked List
		while (temp != null)
		{
			temp = temp.next;
			len++;
		}
		// check if value of n is not more than length of the linked list
		if (len < n)
			return;

		temp = head;
		// 2) get the (len-n+1)th node from the begining
		for (int i = 1; i < len-n+1; i++)
			temp = temp.next;

		System.out.println();
		System.out.println("Answer is :"+ temp.data);
	}

	public static void main(String[] args) {

		NthNodeFromEnd llist = new NthNodeFromEnd();

		llist.push(1);
		llist.push(2);
		llist.push(3);
		llist.push(4);
		llist.push(5);

		llist.PrintLinkList();
		llist.findNthNodeFromEnd(2);
	}


}
