//https://algorithms.tutorialhorizon.com/rearrange-positive-and-negative-elements-at-alternate-positions-in-an-array-in-o1-extra-space/
package TopArraysProblem;

public class ReArrangeArrayInAlternateNegAndPosNumbers {

	public void rerrange(int[] arrA) {
		int pivot = 0;
		int left = 0;
		int right = arrA.length - 1;
		while (right > left) {
			while (arrA[left] < 0 && left < right)
				left++;
			while (arrA[right] > 0 && left < right)
				right--;
			if (left < right) {
				int temp = arrA[left];
				arrA[left] = arrA[right];
				arrA[right] = temp;
				left++;
				right--;
			}
		}
		// At the point all the negative elements on the left half and
		// positive elements on the right half of the array
		// swap the every alternate element in the left half (negative
		// elements) with the elements in the right (positive elements)
		left = 1;
		int high = 0;
		while (arrA[high] < 0) {
			high++;
		}
		//high now points to the 1st positive number

		right = high;
		while (arrA[left] < 0 && right < arrA.length) {
			int temp = arrA[left];
			arrA[left] = arrA[right];
			arrA[right] = temp;
			left = left + 2;
			right++;
		}
	}

	// A utility function to print an array 'arr[]' of size 'n'
	void printArray(int arr[], int n) 
	{
		for (int i = 0; i < n; i++)
			System.out.print(arr[i] + " ");
		System.out.println("");
	}

	public static void main(String[] args) {

		ReArrangeArrayInAlternateNegAndPosNumbers rearrange = new ReArrangeArrayInAlternateNegAndPosNumbers();
		//int arr[n] = {-5, 3, 4, 5, -6, -2, 8, 9, -1, -4};
		//int arr[] = {-5, -3, -4, -5, -6, 2 , 8, 9, 1 , 4};
		//int arr[] = {5, 3, 4, 2, 1, -2 , -8, -9, -1 , -4};
		//int arr[] = {-5, 3, -4, -7, -1, -2 , -8, -9, 1 , -4};
		int arr[] = {-5, -2, 5, 2, 4, 7, 1, 8, 0, -8};
		int n = arr.length;

		System.out.println("Given array is ");
		rearrange.printArray(arr, n);

		rearrange.rerrange(arr);

		System.out.println("RearrangeD array is ");
		rearrange.printArray(arr, n);
	}
}
