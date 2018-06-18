//https://www.geeksforgeeks.org/convert-array-into-zig-zag-fashion/
// The converted array should be in form a < b > c < d > e < f.
package TopProblems;

import java.util.Arrays;
// O(n) time using an Efficient Approach
public class ArrayInZigZagFaction {

	// Method for zig-zag conversion of array using bubble sort 
	static int[]  zigZag(int arr[])
	{
		// Flag true indicates relation "<" is expected,
		// else ">" is expected.  The first expected relation is "<"
		boolean flag = true;
		int temp = 0;
		for (int i=0; i<=arr.length-2; i++)
		{
			if (flag)  /* "<" relation expected */
			{
				/* If we have a situation like A > B 
                   we get A < B  by swapping A and B */
				if (arr[i] > arr[i+1])
				{
					// swap
					temp  = arr[i];
					arr[i] = arr[i+1];
					arr[i+1] = temp;
				}

			}
			else /* ">" relation expected */
			{
				/* If we have a situation like A < B ,
                   we get A > B by swapping A and B */
				if (arr[i] < arr[i+1])
				{
					// swap
					temp = arr[i];
					arr[i] = arr[i+1];
					arr[i+1] = temp;
				}
			}
			flag = !flag; /* flip flag */
		}
		return arr;
	}


	public static void main(String[] args) {
		int arr[] = new int[]{4, 3, 7, 8, 6, 2, 1};
		System.out.println("Input Array : " + Arrays.toString(arr));
		System.out.println("Input Array : " + Arrays.toString(zigZag(arr)));
	}

}
