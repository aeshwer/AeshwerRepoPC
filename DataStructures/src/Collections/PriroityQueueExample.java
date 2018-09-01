package Collections;

import java.util.Iterator;
import java.util.LinkedList;
import java.util.PriorityQueue;
import java.util.Queue;

public class PriroityQueueExample{
	
	public static void main(String[] args) {
		Queue<Integer> queue=new PriorityQueue<Integer>();  
		//Queue<Integer> queue=new LinkedList<Integer>();  
		queue.add(3);  
		queue.add(4);  
		queue.add(1);  
		queue.add(2);
		//queue.add(null); allowed for simple linklist
		System.out.println("head:"+queue.element());  
		System.out.println("head:"+queue.peek());  
		System.out.println("iterating the queue elements:");  
		Iterator<Integer> itr=queue.iterator();  
		while(itr.hasNext()){  
		System.out.println(itr.next());  
		}  
		queue.remove();  
		queue.poll();  
		System.out.println("after removing two elements:");  
		Iterator<Integer> itr2=queue.iterator();  
		while(itr2.hasNext()){  
		System.out.println(itr2.next());  
		}  
	}
}
