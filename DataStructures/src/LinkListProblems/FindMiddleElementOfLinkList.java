// https://www.geeksforgeeks.org/write-a-c-function-to-print-the-middle-of-the-linked-list/
package LinkListProblems;


public class FindMiddleElementOfLinkList {
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
	
	/*Traverse linked list using two pointers. Move one pointer by one and other pointer by two. 
	When the fast pointer reaches end slow pointer will reach middle of the linked list.*/
	private int findMidElement() {
		Node slow = head ,fast = head;
		while(fast!=null && fast.next!=null ) 
		{
			
			slow = slow.next; 
			fast = fast.next.next;
		}
		return slow.data;
	}

	public static void main(String[] args) {
		FindMiddleElementOfLinkList  obj = new FindMiddleElementOfLinkList();
		//obj.pushInFront(6);
		obj.pushInFront(5);
		obj.pushInFront(4);
		obj.pushInFront(3);
		obj.pushInFront(2);
		obj.pushInFront(1);
		
		obj.printLinkList();
		System.out.println();
		System.out.println("Mid element is : "+ obj.findMidElement()) ;

	}

}
