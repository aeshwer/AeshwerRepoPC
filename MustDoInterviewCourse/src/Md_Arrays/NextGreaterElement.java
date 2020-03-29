package Md_Arrays;

import java.util.List;
import java.util.Stack;

//https://leetcode.com/discuss/interview-question/384662/Salesforce-or-Sr.-DevOps-or-OA
// https://www.geeksforgeeks.org/next-greater-element/
//O(n)
public class NextGreaterElement {

	private static void printNGE(int[] arr, int n) {
		int element = 0;
		int next = 0;
		Stack<Integer> stack = new Stack<>();
		stack.push(arr[0]);

		for (int i = 1; i < arr.length; i++) {

			next = arr[i];

			if (!stack.isEmpty()) {
				element = stack.pop();

				/*
				 * If the popped element is smaller than next, then a) print the pair b) keep
				 * popping while elements are smaller and stack is not empty
				 */
				while (element < next) {
					System.out.println(element + " --> " + next);
					if (stack.isEmpty())
						break;
					element = stack.pop();
				}

				/*
				 * If element is greater than next, then push the element back
				 */
				if (element > next)
					stack.push(element);
			}

			/*
			 * push next to stack so that we can find next greater for it
			 */
			stack.push(next);

		}
		/* After iterating over the loop, the remaining  
        elements in stack do not have the next greater  
        element, so print -1 for them */
		while (stack.isEmpty() == false)  
        { 
            element = stack.pop(); 
            next = -1; 
            System.out.println(element + " -- " + next); 
        } 
	}

	public static void main(String args[]) {
		int arr[] = { 11, 6,7,13, 21, 3 };
		int n = arr.length;
		printNGE(arr, n);
	}

}
