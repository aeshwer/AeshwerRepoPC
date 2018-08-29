package hashingTutorials;

import java.util.HashMap;
import java.util.HashSet;
/*Write a C program that, given an array A[] of n numbers and another number x, 
 * determines whether or not there exist two elements in S whose sum is exactly x. 
 * O(n) solution using hashmap
 */

public class SumofThreeNumberEqualToASum {

	static void printpairs(int arr[],int sum)
    {       
		int j=0;
		int temp2 = 0 ,temp; 
		HashMap<Integer, Integer> map = new HashMap<>();        
		for (int i=0; i<arr.length; ++i)
        { 	
			temp = sum-arr[i];
			for (j=i+1; j<arr.length-1; ++j) 
			{
				temp2 = temp- arr[j];
 
            // checking for condition and handling duplicates
            if (temp2>=0 && map.containsKey(temp2) && map.get(temp2)!= 0 )
            {	
				System.out.println("Triple Pair with given sum " +
                                    sum + " is (" + arr[i] + ", " +arr[j] + ", " + temp2+")");
                map.put(arr[i],map.get((arr[i]))-1);
            }
            //From here we are adding the number to map 
            if(map.containsKey(arr[j])) 
            {
            	map.put(arr[j],map.get((arr[j]))+1);
            }
            else
            {
            	map.put(arr[j],1);
            }
			
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
		int n = 16;
		printpairs(A,  n);
	}

}
