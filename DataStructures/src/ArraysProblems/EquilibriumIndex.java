package ArraysProblems;

public class EquilibriumIndex {

	int equilibriumIndex(int[] arr,int len)
	{
		int sum = 0;      // initialize sum of whole array
        int leftsum = 0; // initialize leftsum

        /* Find sum of the whole array */
        for (int i = 0; i < len; ++i)
            {
        	sum += arr[i];
        	}
        
        for (int i = 0; i < len; ++i)
        {
            sum -= arr[i]; // sum is now right sum for index i
 
            if (leftsum == sum)
                return i;
 
            leftsum += arr[i];
        }
 
        /* If no equilibrium index found, then return 0 */
        return -1;
	}
	
	public static void main(String[] args) {
	
		int arr[] = {-7, 1, 5, 2, -4, 3, 0};
		EquilibriumIndex obj = new EquilibriumIndex();
		System.out.println("First equilibrium index is " + obj.equilibriumIndex(arr, arr.length));
	}
}