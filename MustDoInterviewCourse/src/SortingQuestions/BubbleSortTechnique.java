package SortingQuestions;

import java.util.Arrays;

//Complexcity - O(n^2) worst case
//				O(n) best case
public class BubbleSortTechnique {

	public static void main(String[] args) {
		int arr[] = { 4, 1, 22, 2, 34, 44, 15, 9 };
		System.out.println("Before Sort : " + Arrays.toString(arr));
		bubbleSort(arr, arr.length);
		System.out.println("After Sort : " + Arrays.toString(arr));
	}

	private static void bubbleSort(int[] arr, int length) {
		boolean swapped = false;
		for (int i = 0; i < length - 1; i++) {
			swapped = false;
			System.out.println("Sorting at i = : " + i + "  ---" + Arrays.toString(arr));
			for (int j = 0; j < length - i - 1; j++) {
				if (arr[j] > arr[j + 1]) {
					int temp = arr[j + 1];
					arr[j + 1] = arr[j];
					arr[j] = temp;
					swapped = true;
				}

			}
			if (swapped == false) {
				break;
			}

		}

	}

}
