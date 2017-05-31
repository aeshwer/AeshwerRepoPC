package ArraysProblems;
/*
 * You are given an array of 0s and 1s in random order. Segregate 0s on left side and 1s on right side of the array. Traverse array only once.
 */
public class SeggreagetZerosAndOnes {

	 void seggreagte(int[] arr,int len)
	 {
	        /* Initialize left and right indexes */
	        int left = 0, right = len - 1;
	        while (left < right) 
	        {
	            /* Increment left index while we see 0 at left */
	            while (arr[left] == 0 && left < right)
	               left++;
	 
	            /* Decrement right index while we see 1 at right */
	            while (arr[right] == 1 && left < right)
	                right--;
	 
	            /* If left is smaller than right then there is a 1 at left
	               and a 0 at right.  Exchange arr[left] and arr[right]*/
	            if (left < right) 
	            {
	                arr[left] = 0;
	                arr[right] = 1;
	                left++;
	                right--;
	            }
	        }
	 }
	 
	 public static void main(String[] args) {
		int arr[] = {0, 1, 0, 1, 1, 1};
		SeggreagetZerosAndOnes obj = new SeggreagetZerosAndOnes();
		obj.seggreagte(arr,arr.length);
		
		 System.out.print("Array after segregation is ");
	        for (int i  = 0; i < arr.length; i++)
	            System.out.print(arr[i] + " ");
	}

}
