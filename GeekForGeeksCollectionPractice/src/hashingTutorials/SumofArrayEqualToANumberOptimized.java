package hashingTutorials;

import java.util.HashMap;
import java.util.HashSet;
/*Write a C program that, given an array A[] of n numbers and another number x, 
 * determines whether or not there exist two elements in S whose sum is exactly x. 
 * O(n) solution using hashmap
 */

public class SumofArrayEqualToANumberOptimized {

	static void printpairs(int arr[],int sum)
    {       
		HashMap<Integer, Integer> map = new HashMap<>();        
		for (int i=0; i<arr.length; ++i)
        {
            int temp = sum-arr[i];
 
            // checking for condition and handling duplicates
            if (temp>=0 && map.containsKey(temp) && map.get(temp)!= 0 )
            {
                System.out.println("Pair with given sum " +
                                    sum + " is (" + arr[i] +
                                    ", "+temp+")");
                map.put(arr[i],map.get((arr[i]))-1);
            }
            //From here we are adding the number to map 
            if(map.containsKey(arr[i])) 
            {
            	map.put(arr[i],map.get((arr[i]))+1);
            }
            else
            {
            	map.put(arr[i],1);
            }
        }
    }

	public static void main(String[] args) {
		int A[] = {1, 4, 45, 6, 6};
		int n = 12;
		printpairs(A,  n);
	}

}
