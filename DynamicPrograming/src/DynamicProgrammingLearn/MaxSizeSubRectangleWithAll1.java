package DynamicProgrammingLearn;

import java.util.Stack;

import org.omg.PortableInterceptor.INACTIVE;

//Given a binary matrix, find the maximum size rectangle binary-sub-matrix with all 1’s 
//Complexity  is O(Row X Column)
public class MaxSizeSubRectangleWithAll1 {

	static int getMaxArea(Integer[] hist , int len)
	{
		Stack<Integer> stack = new Stack<Integer>();
		int i=0;
		int tp=0;
		int area=0, max_area=0;
		while(i<len)
		{
			if(stack.empty() || hist[stack.peek()] <= hist[i])
			{
				stack.push(i++);
			}
			else
			{
				tp = stack.pop();
				if(stack.isEmpty())
				{
					area= hist[tp]*i;
				}
				
				else
				{
					area = hist[tp]*(i-hist[stack.peek()]-1);
				}
				
				if(area> max_area)
				{
					max_area= area;
				}
			}
			
		}
		
		while(stack.empty() == false)
		{
			tp = stack.pop();
			if(stack.isEmpty())
			{
				area= hist[tp]*i;
			}
			
			else
			{
				area = hist[tp]*(i-hist[stack.peek()]-1);
			}
			
			if(area> max_area)
			{
				max_area= area;
			}
		}
		
		return max_area;
	}
	
	
	static void printMaxSubRectangle(Integer arr[][],int row,int col)
	{
		Integer[] row_Array = new Integer[col];
		
		// copy first row as it in
		for(int i=0; i < col ;i++)
		{
			row_Array[i] = arr[0][i];
		}
		// calcuate its max are and update it
		int max_area = getMaxArea(row_Array, col);
		int area=0;
		
		int temp_row_index = 1;
		// now sweep other rows and find the max histogram area and core logic...watch video for this  part 
		while(temp_row_index < (row-1))
		{ 
			for(int i=0; i < col ;i++)
			{
				if(arr[temp_row_index][i]==0){
				row_Array[i] =0;
			}
			else
			{ 	row_Array[i] = arr[temp_row_index][i] + 1;}
		}
		
		area = getMaxArea(row_Array, col);
		if(area> max_area)
		{
			max_area =area;
		}
		temp_row_index++;
		}
		
		System.err.println("Max area is " + max_area);
		
	}
	
	
	
	public static void main(String[] args) {
		  Integer M[][] ={	{0, 1, 1, 0 },
				  			{1, 1, 1, 1 },
				  			{1, 1, 1, 1 },
				  			{1, 1, 0, 0 } };
		                
		  printMaxSubRectangle(M,4,4);
	}
}
