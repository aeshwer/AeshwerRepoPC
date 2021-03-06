package hashingTutorials;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.Collections;
import java.util.HashMap;
/*Write a C program that, given an array A[] of n numbers and another number x, 
 * determines whether or not there exist two elements in S whose sum is exactly x. 
 * O(n) solution using hashmap
 */
import java.util.Iterator;

public class SumofArrayEqualToANumber {
	
	int findNumberOfPairs(Integer[] arr, int k)
	{
		int n = arr.length;
		int temp = n-1 , count = 0; 
		ArrayList< Integer> list = new ArrayList<Integer>();
		Collections.addAll(list,arr);
		//Sort the list
		Collections.sort(list);
		//print sorted list
		Iterator<Integer> itr = list.iterator();
        while(itr.hasNext())
        {
        	System.out.print(itr.next() + " ");
        }
        //logic
        for(int i = 0; i<=temp ; )
		{ 
        	int sum = list.get(i) +list.get(temp);
        	if(sum > k)
        	{temp = temp-1;}
        	else if(sum == k){count++;
        	i=i+1;temp = temp-1;
        	System.out.println("Pairs is" + " " + list.get(i) +"and "+ list.get(temp));}
        	else if(sum < k){ i=i+1; }
		}
        return count;
        
	}

	public static void main(String[] args) {
		Integer arr[] = {1, 4, 10, 6, 45, -8};
		int x = 16; // the given sum ..we can also take this form console
		SumofArrayEqualToANumber sumofArrayEqualToANumber = new SumofArrayEqualToANumber();
		int pairs = sumofArrayEqualToANumber.findNumberOfPairs(arr,x);
		System.out.println("Total pairs are" + " " +   pairs);

	}

}
