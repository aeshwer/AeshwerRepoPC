package SortingQuestions;

import java.util.Arrays;
import java.util.Iterator;
import java.util.PriorityQueue;

//order O(nLogk)
public class KnearlySortedArray {

	public static void main(final String[] args) {
		final int k = 3;
		final int arr[] = { 2, 6, 3, 12, 56, 8 };
		final int n = arr.length;
		kSort(arr, n, k);
		System.out.println("Following is sorted array" + Arrays.toString(arr));
	}

	private static void kSort(final int[] arr, final int n, final int k) {
		// min heap
		final PriorityQueue<Integer> priorityQueue = new PriorityQueue<>();

		// add first k + 1 items to the min heap
		for (int i = 0; i < k + 1; i++) {
			priorityQueue.add(arr[i]);
		}

		int index = 0;
		for (int i = k + 1; i < n; i++) {
			arr[index++] = priorityQueue.peek();
			priorityQueue.poll();
			priorityQueue.add(arr[i]);
		}

		final Iterator<Integer> itr = priorityQueue.iterator();

		while (itr.hasNext()) {
			arr[index++] = priorityQueue.peek();
			priorityQueue.poll();
		}
	}

}
