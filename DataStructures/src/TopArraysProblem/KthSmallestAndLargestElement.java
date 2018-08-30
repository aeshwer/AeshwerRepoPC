package TopArraysProblem;

import java.util.Arrays;

public class KthSmallestAndLargestElement {

	private static void smallestElement(int[] arr, int m, int k) {
        // Sort the given array
        Arrays.sort(arr);
        // Return k'th element in the sorted array
        System.out.println("smallest : "+ arr[k-1]);
	}

	private static void largestElement(int[] arr, int m, int k) {
		  // Sort the given array
        Arrays.sort(arr);
        // Return k'th element in the sorted array
        System.out.println("largest : "+ arr[m-k+1]);
	}

	public static void main(String[] args) {
		int arr1[] = {1, 2, 3, 9, 4};
		int m = arr1.length;
		int k= 2;
		smallestElement(arr1, m,k);
		largestElement(arr1, m,k);
	}
}
