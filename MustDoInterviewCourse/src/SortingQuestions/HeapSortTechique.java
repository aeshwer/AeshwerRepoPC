package SortingQuestions;

import java.util.Arrays;

//Complexcity - O(nlog(n)) best and worst case
public class HeapSortTechique {

	public static void main(String[] args) {
		int arr[] = { 4, 1, 22, 2, 34, 44, 15 };
		System.out.println("Before Sort : " + Arrays.toString(arr));
		heapSort(arr);
		System.out.println("After Sort : " + Arrays.toString(arr));
	}

	private static void heapSort(int[] arr) {

		int n = arr.length;

		// build max heap
		for (int i = n / 2 - 1; i >= 0; i--) {
			heapify(arr, n, i);
		}

		System.out.println("Max heap build is   : " + Arrays.toString(arr));

		// Extraction phase O(log(n))
		for (int i = n - 1; i >= 0; i--) {
			// swap head(max value) with the last leaf node and decrease heap size
			int temp = arr[0];
			arr[0] = arr[i];
			arr[i] = temp;

			heapify(arr, i, 0);
		}

	}

	// complexcity if building a max heap is O(n)
	//n= heap size and i = index where we want to heapify
	private static void heapify(int[] arr, int n, int i) {
		int largest = i;
		int l = 2 * i + 1; 
		int r = 2 * i + 2; 

		if (l < n && arr[l] > arr[largest]) {
			largest = l;
		}
		if (r < n && arr[r] > arr[largest]) {
			largest = r;
		}

		if (largest != i) {
			// swap largest and root i
			int temp = arr[i];
			arr[i] = arr[largest];
			arr[largest] = temp;
			
			//Recursively heapify the affected sub-tree
			heapify(arr, n, largest);
		}

	}

}
