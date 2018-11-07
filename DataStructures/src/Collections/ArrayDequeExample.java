package Collections;

import java.util.ArrayDeque;
import java.util.Deque;

public class ArrayDequeExample {
	public static void main(String[] args) {  
		//Creating Deque and adding elements  
		Deque<Integer> deque = new ArrayDeque<Integer>();  
		deque.add(4);    
		deque.add(1); 
		deque.add(3);
		//deque.add(null);
		//Traversing elements  
		for (Integer str : deque) {  
			System.out.println(str);  
		}  
	}  
}
