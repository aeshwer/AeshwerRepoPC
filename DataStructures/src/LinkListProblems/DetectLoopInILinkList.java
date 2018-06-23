package LinkListProblems;

/*Flyods cycle finding algo"
 * 
 * This is the fastest method. Traverse linked list using two pointers.  Move one pointer by one and other pointer by two.  
 * If these pointers meet at some node then there is a loop.  If pointers do not meet then linked list doesn’t have loop.
 */

public class DetectLoopInILinkList {

	Node head;
	class Node
	{
		int data;
		Node next;
		Node(int data)
		{
			this.data= data;
			this.next =null;
		}

	}

	/* Inserts a new Node at front of the list. */
	public void push(int new_data)
	{
		Node new_node = new Node(new_data);
		new_node.next = head;
		head = new_node;
	}

	public void printList()
	{
		Node tnode= head;
		while(tnode!=null)
		{
			System.out.print(tnode.data + " ");
			tnode=tnode.next;
		}
	}


	void detectAndFixLoop()
	{

		Node slow =head, fast = head;
		while (slow != null && fast != null && fast.next != null) {
			slow = slow.next;
			fast = fast.next.next;
			if (slow == fast) {
				System.out.println("Found loop");
				//Removed Loops
				slow.next= null;
				return ;
			}
		}
		return;
	}

	public static void main(String[] args) {

		DetectLoopInILinkList llist = new DetectLoopInILinkList();

		llist.push(1);
		llist.push(2);
		llist.push(3);
		llist.push(4);
		llist.push(5);

		System.out.println("\nLinked list created is: ");
		llist.printList();
		System.out.println();

		/*Create loop for testing */
		llist.head.next.next.next.next.next = llist.head.next;
		//llist.printList();
		llist.detectAndFixLoop();
		llist.printList();

	}
}
