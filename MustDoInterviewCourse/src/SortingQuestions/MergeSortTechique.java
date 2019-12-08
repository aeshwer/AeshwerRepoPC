package SortingQuestions;

import java.util.Arrays;

//Complexcity : O(nlog(n)) for worst and best case

public class MergeSortTechique {

	public static void main(String[] args) {
		int arr[] = { 4, 1, 22, 2, 34, 44, 15, 9 };
		System.out.println("Before Sort : " + Arrays.toString(arr));
		mergeSort(arr, 0, arr.length-1);
		System.out.println("After Sort : " + Arrays.toString(arr));

	}

	private static void mergeSort(int[] arr, int l, int r) {

		if (l < r) {
			//Partition 
			int m = (l + r) / 2;
			mergeSort(arr, l, m);
			mergeSort(arr, m + 1, r);
			//Merge now
			merge(arr, l, m, r);
		}

	}

	private static void merge(int[] arr, int l, int m, int r) {
		//find size of 2 subarray
		int n1 = m - l + 1;
		int n2 = r - m;

		//create temp array
		int L[] = new int[n1];
		int R[] = new int[n2];

		//copy data to temp array
		for (int i = 0; i < n1; i++) {
			L[i] = arr[l + i];
		}

		for (int j = 0; j < n2; j++) {
			R[j] = arr[m + 1+ j];
		}

		//Merge temp arrays
		int i = 0;
		int j = 0;
		int k = l;//initial index of merged array
		while (i < n1 && j < n2) {
			if (L[i] <= R[j]) {
				arr[k] = L[i];
				i++;
			}
			else {
				arr[k] = R[j];
				j++;
			}
			k++;
		}
		//copy remaining elements if any

		while (i < n1) {
			arr[k] = L[i];
			i++;
			k++;
		}
		while (j < n2) {
			arr[k] = R[j];
			j++;
			k++;
		}
	}
}
