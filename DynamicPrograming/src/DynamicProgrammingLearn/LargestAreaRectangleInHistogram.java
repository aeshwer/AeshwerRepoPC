package DynamicProgrammingLearn;

import java.util.Stack;

/*Find the largest rectangular area possible in a given histogram where the largest rectangle can be made of a 
 * number of contiguous bars. For simplicity, assume that all bars have same width and the width is 1 unit.
 * Refer : http://www.geeksforgeeks.org/largest-rectangle-under-histogram/
 * 
 * NOTE: THIS A HARD LEVEL PROGRAM AND REQUIRES STACK COLLECTION API
 * Contributed By Aeshwer Tyagi
 */
public class LargestAreaRectangleInHistogram {
	
	static void getMaxArea(Integer[] hist, int len)
	{ 
		// Create an empty stack. The stack holds indexes of hist[] array
	    // The bars stored in stack are always in increasing order of their heights.
		Stack<Integer> stack = new Stack<Integer>();
	    int max_area = 0; // Initalize max area
	    int tp;  // To store top of stack
	    int area_with_top; // To store area with top bar as the smallest bar
	    int area_temp = 0;
	    
	    // Run through all bars of given histogram
	    int i = 0;
	    while (i < len)
	    {
	    	// If this bar is higher than the bar on top stack, push it to stack
	        	if (stack.empty() || hist[stack.peek()] <= hist[i])
	        	{ stack.push(i++);}
	        

	        // If this bar is lower than top of stack, then calculate area of rectangle 
	        // with stack top as the smallest (or minimum height) bar. 'i' is 
	        // 'right index' for the top and element before top in stack is 'left index'
	        else
	        {
	        	tp = stack.pop().intValue();// store the top index
	            // Calculate the area with hist[tp] stack as smallest bar
	        	if(stack.empty()){
	        		area_temp = hist[tp]*i;
	        	}
	        	else{
	        		area_temp = hist[tp]*(i-stack.peek()-1);
	        	}
	        	 
	            // update max area, if needed	
	        	if(area_temp > max_area){
	        		max_area = area_temp;
	        	}
	           
	        }
	        
	    }
	    
	    
	    // Now pop the remaining bars from stack and calculate area with every
	    // popped bar as the smallest bar
	    while (stack.empty() == false)
	    {
	    	tp = stack.pop(); // store the top index
            // Calculate the area with hist[tp] stack as smallest bar
        	if(stack.empty()){
        		area_temp = hist[tp]*i;
        	}
        	else{
        		area_temp = hist[tp]*(i-stack.peek()-1);
        	}
        	 
            // update max area, if needed	
        	if(area_temp > max_area){
        		max_area = area_temp;
        	}
           
	    }
	    
	 System.out.println(max_area);
		
	}
	
	public static void main(String[] args) {
		Integer hist[] ={6, 2, 5, 4, 5, 1, 6};
	    int len = hist.length;
	    getMaxArea(hist, len);
	}
}
