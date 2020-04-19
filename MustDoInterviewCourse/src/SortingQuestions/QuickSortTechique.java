package SortingQuestions;

import java.util.Arrays;

//Complexcity - O(n^2) worst case
//				O(nlog(n)) best case
public class QuickSortTechique {

	public static void main(String[] args) {
		int arr[] = { 1, 4, 5, 2, 3 };
		System.out.println("Before Sort : " + Arrays.toString(arr));
		quickSort(arr, 0, arr.length - 1);
		System.out.println("After Sort : " + Arrays.toString(arr));

	}

	private static void quickSort(int[] arr, int l, int r) {
		if (l < r) {
			int pivot = partition(arr, l, r);
			quickSort(arr, l, pivot - 1);
			quickSort(arr, pivot + 1, r);
		}

	}

	private static int partition(int[] arr, int l, int r) {
		int pivot = arr[l];// select left element as pivot
		int i = l; // index of smaller element

		for (int j = l + 1; j <= r; j++) {
			if (arr[j] <= pivot) {
				i++;
				int temp = arr[j];
				arr[j] = arr[i];
				arr[i] = temp;
			}
		}
		// swap the pivot with arr[i] so the pivot is at the correct position
		int temp = arr[i];
		arr[i] = arr[l];
		arr[l] = temp;

		System.out.println("Sorting  : " + Arrays.toString(arr));
		return i;
	}
}
