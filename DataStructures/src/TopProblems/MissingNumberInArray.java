//https://www.geeksforgeeks.org/find-the-missing-number/
package TopProblems;

/* Get sum  total = n*(n+1)/2
 * Subtract all the numbers from sum and you will get the missing number.
 */
public class MissingNumberInArray {
	
	private static int getMissingNo(int[] arr, int n) {
	        int total  = (n+1)*(n+2)/2;   
	        for (int i = 0; i< n; i++)
	           {
	        	total = total - arr[i];
	        	}
	        return total;
	}

	public static void main(String[] args) {
		int arr[] = {1,2,4,5,6};
		int miss = getMissingNo(arr,arr.length);
		System.out.println(miss);   
	}

}
