package SortingQuestions;

import java.util.Arrays;
import java.util.Comparator;
import java.util.PriorityQueue;

public class KthSmallestLargest {


	  public static void main(final String[] args) {
	    final Integer arr[] = {1, 22, 2, 44, 9, 33, 11};
	    final Integer arr2[] = {1, 22, 2, 44, 9, 33, 11};
	    Arrays.sort(arr2);
	    System.out.println(Arrays.toString(arr2));
	    final int k = 2;
	    getKthLargestElementInUnsortedArray(arr, k);
	    getKthSmallestElementInUnsortedArray(arr, k);
	  }

	  private static void getKthSmallestElementInUnsortedArray(final Integer[] arr, final int k) {

	    final PriorityQueue<Integer> pq = new PriorityQueue<>(k, Comparator.reverseOrder());

	    for (final int i : arr) {
	      pq.offer(i);

	      if (pq.size() > k) {
	        pq.poll();
	      }
	    }

	    System.out.println("Kth Smallest element is : " + pq.peek());
	  }

	  private static void getKthLargestElementInUnsortedArray(final Integer[] arr, final int k) {

	    final PriorityQueue<Integer> pq = new PriorityQueue<>(k);

	    for (final int i : arr) {
	      pq.offer(i);

	      if (pq.size() > k) {
	        pq.poll();
	      }
	    }

	    System.out.println("Kth largest element is : " + pq.peek());
	  }


}
