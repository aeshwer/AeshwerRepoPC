package TopArraysProblem;


public class IntersectionArrayOF2Array {

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


	static void intersectionArray(int arr1[], int arr2[], int m, int n) 
	{
		m=removeDuplicateElements(arr1,m);
		n=removeDuplicateElements(arr2,n);
		int i=0,j=0;
		while(i<m && j<n) 
		{
			if(arr1[i] < arr2[j]) {
				System.out.print(arr1[i] + " ");
				i++;
			}

			else if(arr1[i] > arr2[j])
			{
				System.out.print(arr2[j]+ " ");
				j++;
			}
			else 
			{
				System.out.print(arr2[j]+ " ");
				j++;
				i++;
			}
		}

		// Print remaining elements of the larger array 
		while(i < m)
			System.out.print(arr1[i++]+" ");
		while(j < n)
			System.out.print(arr2[j++]+" ");
	}

	public static void main(String[] args) {
		int arr1[] = {1, 2, 4, 5, 6};
		int arr2[] = {2, 3, 5, 7};
		int m = arr1.length;
		int n = arr2.length;
		intersectionArray(arr1, arr2, m, n);
	}
}

