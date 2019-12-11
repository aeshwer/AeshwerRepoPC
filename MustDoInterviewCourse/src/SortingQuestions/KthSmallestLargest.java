package SortingQuestions;

import java.util.Arrays;
import java.util.Comparator;
import java.util.PriorityQueue;

public class KthSmallestLargest {

	public static void main(final String[] args) {
		final Integer arr[] = { 1, 22, 2, 44, 9, 33, 11 };
		final Integer arr2[] = { 1, 22, 2, 44, 9, 33, 11 };
		Arrays.sort(arr2);
		System.out.println(Arrays.toString(arr2));
		final int k = 2;
		getKthLargestElementInUnsortedArray(arr, k); // O(nlog(k))
		getKthSmallestElementInUnsortedArray(arr, k); // O(nlog(k))
		getKthLargestElementInUnsortedArrayUsingQuickSortPartition(arr, arr.length - k, 0, arr.length - 1);

		getKthSmallestElementInUnsortedArrayUsingQuickSortPartition(arr, arr.length - k, 0,
				arr.length - 1); /* Average case timeis O(n),worstcase time is O(n^2). */
	}

	private static void getKthSmallestElementInUnsortedArray(final Integer[] arr, final int k) {

		final PriorityQueue<Integer> pq = new PriorityQueue<>(k, Comparator.reverseOrder());

		for (int i = 0; i < k; i++) {
			pq.add(arr[i]);
		}

		for (int i = k; i < arr.length; i++) {
			if (arr[i] < pq.peek()) {
				pq.add(arr[i]);
				pq.poll();
			}
		}

		System.out.println("Kth largest element is : " + pq.peek());

	}

	private static void getKthLargestElementInUnsortedArray(final Integer[] arr, final int k) {

		final PriorityQueue<Integer> pq = new PriorityQueue<>(k);

		for (int i = 0; i < k; i++) {
			pq.add(arr[i]);
		}

		for (int i = k; i < arr.length; i++) {
			if (arr[i] > pq.peek()) {
				pq.add(arr[i]);
				pq.poll();
			}
		}

		System.out.println("Kth largest element is : " + pq.peek());
	}

	private static void getKthLargestElementInUnsortedArrayUsingQuickSortPartition(final Integer[] arr, final int k,
			final int l, final int r) {

		final int pivot = arr[l];
		int i = l;

		for (int j = l + 1; j <= r; j++) {
			if (arr[j] <= pivot) {
				i++;
				final int temp = arr[j];
				arr[j] = arr[i];
				arr[i] = temp;
			}
		}

		final int temp = arr[i];
		arr[i] = arr[l];
		arr[l] = temp;

		if (i > k) {
			getKthLargestElementInUnsortedArrayUsingQuickSortPartition(arr, k, l, i - 1);
		} else if (i < k) {
			getKthLargestElementInUnsortedArrayUsingQuickSortPartition(arr, k, i + 1, r);
		} else if (i == k) {
			System.out.println("Kth largest element is : " + arr[i]);
			return;
		}
	}

	private static void getKthSmallestElementInUnsortedArrayUsingQuickSortPartition(final Integer[] arr, final int k,
			final int l, final int r) {

		final int pivot = arr[l];
		int i = l;

		for (int j = l + 1; j <= r; j++) {
			if (arr[j] >= pivot) {
				i++;
				final int temp = arr[j];
				arr[j] = arr[i];
				arr[i] = temp;
			}
		}

		final int temp = arr[i];
		arr[i] = arr[l];
		arr[l] = temp;

		if (i > k) {
			getKthSmallestElementInUnsortedArrayUsingQuickSortPartition(arr, k, l, i - 1);
		} else if (i < k) {
			getKthSmallestElementInUnsortedArrayUsingQuickSortPartition(arr, k, i + 1, r);
		} else if (i == k) {
			System.out.println("Kth smallest element is : " + arr[i]);
			return;
		}
	}
}
