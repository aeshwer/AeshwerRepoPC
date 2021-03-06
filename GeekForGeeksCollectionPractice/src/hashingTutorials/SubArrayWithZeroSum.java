package hashingTutorials;

import java.util.HashMap;

public class SubArrayWithZeroSum {
	
	 // Returns true if arr[] has a subarray with zero sum
    static Boolean printZeroSumSubarray(int arr[])
    { // Creates an empty hashMap hM
        HashMap<Integer, Integer> hM = new HashMap<Integer, Integer>();
        // Initialize sum of elements
        int sum = 0;   
        
        // Traverse through the given array
        for (int i = 0; i < arr.length; i++)
        {   
        	sum+=arr[i];
        	if(sum == 0)
        	{
        		return true;
        	}
        	
        	if(hM.containsKey(sum))
        	{
        		return true;
        	}
        	else
        	{
        		hM.put(sum, i);        	
        	}
        }
    	return false;
    }

	public static void main(String[] args) {
        int arr[] = {4, 2, -3, 1, 6};
        if (printZeroSumSubarray(arr))
            System.out.println("Found a subarray with 0 sum");
        else
            System.out.println("No Subarray with 0 sum"); 
	}

}
