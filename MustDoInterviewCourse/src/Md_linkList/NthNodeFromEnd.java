package Md_linkList;

public class NthNodeFromEnd {

	static class Node {
		int data;
		Node next;

		Node(int d) {
			data = d;
			next = null;
		}
	}

	/*
	 * Should return data of n'th node from the end of linked list. head: head of
	 * the linked list n: nth node from end to find
	 */
	int getNthFromLast(Node head, int n) {
        Node mainPointer = head, refPointer = head;
        for(int i=1; i<=n-1; i++){
            refPointer = refPointer.next;
            if(refPointer == null) return -1;
        }
        while(refPointer.next != null){
            mainPointer = mainPointer.next;
            refPointer = refPointer.next;
        }
        return mainPointer.data;
    }

	public static void main(String[] args) {

	}
}
