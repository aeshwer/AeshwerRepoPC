//Time Complexity : O(n)
//Auxiliary Space : O(1)
package TopArraysProblem;

import java.util.Arrays;

public class RemovingDublicatesFromArray {
	
	public static int removeDuplicateElements(int arr[], int n){  
		 if (n == 0 || n == 1)
	            return n;
	      
	        // To store index of next unique element
	        int j = 0;
	      
	        // Just maintaining another updated index i.e. j
	        for (int i = 0; i < n-1; i++)
	            {
	        		if (arr[i] != arr[i+1])
	        			{
	        				arr[j++] = arr[i];
	        			}
	            }
	      
	        arr[j++] = arr[n-1]; //handled the end element case
	      
	        return j;  
    }  
       
    public static void main (String[] args) {  
        int arr[] = {10,70,30,90,20,20,30,40,70,50};//unsorted array  
        Arrays.sort(arr);//sorting array  
        int length = arr.length;  
        length = removeDuplicateElements(arr, length);  
        //printing array elements  
        for (int i=0; i<length; i++)  
           System.out.print(arr[i]+" ");  
    }

}
