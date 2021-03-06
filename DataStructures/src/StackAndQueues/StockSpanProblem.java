package StackAndQueues;
/*
 * http://www.geeksforgeeks.org/the-stock-span-problem/
 * https://www.youtube.com/watch?v=LvQzYMXEANs
 */
import java.util.Stack;

public class StockSpanProblem {
	
	static void calculateSpan(int[] price, int len)
	{	
		Integer[] span = new Integer[len];
	 // Create a stack and push index of first element to it
		Stack<Integer> s = new Stack<Integer>();
		s.push(0);
		// Span value of first element is always 1
		span[0] = 1;
		// Calculate span values for rest of the elements
		  for (int i = 1; i < len; i++)
		  {
			  // Pop elements from stack while stack is not empty and top of stack is smaller than price[i]
			  while ( s.empty()== false && price[s.peek()] <= price[i])
			         {s.pop();}
			  
			  // If stack becomes empty, then price[i] is greater than all elements
		      // on left of it, i.e., price[0], price[1],..price[i-1].  Else price[i]
		      // is greater than elements after top of stack
		      span[i] = (s.empty())? (i + 1) : (i - s.peek());
		 
		      // Push this element to stack
		      s.push(i);
		  }
		
		// A utility function to print elements of array
		      for (int i = 0; i < len; i++)
		      {System.out.print(span[i]  + " ");}
	}
	
	public static void main(String[] args) {
	    int price[] = {10, 4, 5, 90, 120, 80};
	    int len = price.length;
	    calculateSpan(price, len);
	}
}