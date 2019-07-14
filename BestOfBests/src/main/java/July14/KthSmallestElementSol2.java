package July14;

import java.util.Comparator;
import java.util.PriorityQueue;

public class KthSmallestElementSol2 {

	public static class ReverseOrder implements Comparator<Integer> {

		public int compare(Integer o1, Integer o2) {
			if (o1 > o2)
				return -1;
			else if (o1 < o2)
				return 1;
			else
				return 0;
		}

	}

	public static int findKthMax(int arr[], int k) {
		ReverseOrder comp = new ReverseOrder();
		PriorityQueue<Integer> heap = new PriorityQueue<Integer>(comp);
		for (int i : arr) {
			heap.add(i);
			 if(heap.size()>arr.length-k+1) heap.poll(); 
		}
		// maintain size of heap to limit of k ...heap auto sort the array
		return heap.poll();
	}

	public static void main(String[] args) {
		int k = 2;
		int arr[] = { 21, 3, 1, 31 };
		System.out.println(findKthMax(arr, k));
	}

}
