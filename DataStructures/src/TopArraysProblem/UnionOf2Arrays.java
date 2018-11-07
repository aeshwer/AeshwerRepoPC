package TopArraysProblem;

public class UnionOf2Arrays {

	static void UnionArray(int arr1[], int arr2[], int m, int n) {
		{
			int i=0,j=0;
			while(i<m && j<n) 
			{
				if(arr1[i] < arr2[j])
					i++;
				else if(arr1[i] > arr2[j])
					j++;
				else 
				{
					System.out.println(arr2[j]);
					j++;
					i++;
				}
			}
		}
	}


	// Driver Code
	public static void main(String args[])
	{
		int arr1[] = {1, 2, 2, 2, 3};
		int arr2[] = {2, 3, 4, 5};
		int m = arr1.length;
		int n = arr2.length;
		UnionArray(arr1, arr2,m,n);
	}
}
