package hashingTutorials;

import java.util.HashSet;

/*Given an unsorted array that may contain duplicates. Also given a number k which is smaller than size of array.
 *  Write a function that returns true if array contains duplicates within k distance.
 */
public class DublicateElemenstInArray {
	static boolean checkDuplicatesWithinK(int arr[], int k)
    {
		// Creates an empty hashset
        HashSet<Integer> set = new HashSet<>();
        // Traverse the input array
        for (int i=0; i<arr.length; i++)
        {
            // If already present n hash, then we found 
            // a duplicate within k distance .Checking here for immediate place 
            if (set.contains(arr[i]))
               return true;
        	
            // Add this item to hashset
            set.add(arr[i]);
            
            // Remove the k+1 distant item.Map size is always of order of K
            if (i >= k)
              set.remove(arr[i-k]);
 
        }
		return false;
    }
	
	public static void main(String[] args){
		int arr[] = {10, 5, 3, 4, 3, 5, 6};
        if (checkDuplicatesWithinK(arr, 3))
           System.out.println("Yes");
        else
           System.out.println("No");
    }
}
