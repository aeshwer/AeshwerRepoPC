package LinkListProblems;

import java.util.LinkedHashMap;
import java.util.TreeMap;

public class IntersectionPointOfTwoList {

	static Node a, b; // two heads for 2 list
	static class Node {
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

	private void findItersectionNode(Node a, Node b) {
		
		LinkedHashMap<Integer, Integer> map = new LinkedHashMap<>();
		while(a != null) 
		{
			map.put(a.hashCode(),a.data);
			a = a.next;
		}
		
		while(b != null) 
		{
			if(map.containsKey(b.hashCode()))
			{
				System.out.println("Found Intersection point : " + b.data);
				break;
			}
			b = b.next;
		}
	}

	public static void main(String[] args) {

		IntersectionPointOfTwoList list = new IntersectionPointOfTwoList();
		//Let us create intersecting linked lists to test
		// creating first linked list
        list.a = new Node(3);
        list.a.next = new Node(7);
        list.a.next.next = new Node(15);
        list.a.next.next.next = new Node(25);
        list.a.next.next.next.next = new Node(30);
 
        // creating second linked list
        list.b = new Node(10);
        list.b.next = new Node(15);
        list.b.next.next =  list.a.next.next.next;
        
		System.out.println("List a :");
		list.printlist(a);
		System.out.println("");
		System.out.println("List b :");
		list.printlist(b);

		list.findItersectionNode(a,b);	
	}
}
