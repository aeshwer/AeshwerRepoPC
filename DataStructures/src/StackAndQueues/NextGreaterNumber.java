package StackAndQueues;

import java.util.Stack;

/*
 * Given an array, print the Next Greater Element (NGE) for every element. The Next greater Element for an element x is the first greater element 
 * on the right side of x in array. Elements for which no greater element exist, consider next greater element as -1.
 * LINK:: http://www.geeksforgeeks.org/?p=8405
 */
public class NextGreaterNumber {
	
	static void printNGE(Integer[] arr,int len)
	{
		Stack<Integer> s = new Stack<Integer>();
		s.push(arr[0]);
		int next = 0, temp=0; // marks the current element
		
		 for(int i= 1; i<len; i ++)
		 {
			 	next = arr[i];
			 	if(s.isEmpty() == false)
			 	{
			 		 temp = s.pop();
			 		while(next > temp)
			 		{   
			 			System.out.println(temp + "====>> "+ next);
			 			if(s.isEmpty() == true){break;}
			 			s.pop();
			 		}
			 		/* If element is greater than next, then push the element back */
			 		if(next < temp)
			 		{
			 		  s.push(temp);	
			 		}
			 	}
			 	/* push next to stack so that we can find next greater for it */
		        s.push(next);
		 	}
		 
		 /* After iterating over the loop, the remaining elements in stack do not have the next greater element, so print -1 for them */
	    while (s.isEmpty() == false)
	    {
	        temp = s.pop();
	        next = -1;
	        System.out.println(temp + "====>> "+ next);
	    }
		 
	}
	
	public static void main(String[] args) {
	    Integer arr[]= {11, 13, 21, 3};
	    int len = arr.length;
	    printNGE(arr, len);
	}
}
