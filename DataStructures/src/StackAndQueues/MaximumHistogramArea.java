package StackAndQueues;

import java.util.Stack;

public class MaximumHistogramArea {

	public static void main(String[] args) {

		int input[]={2,2,2,6,1,5,4,2,2,2,2};//12
		//int input[]={4,2,0,3,2,5};//6
		//int input[] = { 2, 1, 2, 3, 1 }; // 5
		int maxArea = maxHistogram(input);
		System.out.println(maxArea);
	}

	private static int maxHistogram(int[] heights) {
		// Initialize the variabale and stack
		Stack<Integer> stack = new Stack<Integer>();
		int i=0;
		int top = 0;
		int area = 0;
		int maxArea = 0;

		if (heights.length == 1)
			return heights[0] * 1;

		// Core logic
		for ( i = 0; i < heights.length; i++) {

			if (stack.isEmpty() || heights[stack.peek()] < heights[i])
				stack.add(i);
			else {
				while (!stack.isEmpty() && heights[stack.peek()] > heights[i]) {
					top = stack.pop();
					if (stack.isEmpty()) {
						area = heights[top] * i;
						maxArea = Math.max(area, maxArea);
					} else {
						area = heights[top] * (i - stack.peek()-1);
						maxArea = Math.max(area, maxArea);
					}
				}
				stack.add(i);

			}
		}

		while (!stack.isEmpty()) {
			top = stack.pop();
			if (stack.isEmpty()) {
				area = heights[top] * i;
				maxArea = Math.max(area, maxArea);
			} else {
				area = heights[top] * (i - stack.peek()-1);
				maxArea = Math.max(area, maxArea);
			}
			
		}

		return maxArea;
	}

}
