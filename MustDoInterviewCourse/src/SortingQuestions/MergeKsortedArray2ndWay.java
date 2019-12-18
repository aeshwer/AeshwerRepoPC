package SortingQuestions;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.PriorityQueue;
import java.util.Scanner;

//https://www.programcreek.com/2014/05/merge-k-sorted-arrays-in-java/
/*1
3
1 2 3 4 5 6 7 8 9*/ 
public class MergeKsortedArray2ndWay {

	  public static class ArrayContainer {
	    int[] arr;
	    int index;

	    public ArrayContainer(final int[] arr, final int index) {
	      this.arr = arr;
	      this.index = index;
	    }
	  }

	  public static class GfG {
	    public static ArrayList<Integer> mergeKArrays(final int[][] arrays, final int k) {

	      final ArrayList<Integer> result = new ArrayList<>();
	      final PriorityQueue<ArrayContainer> queue =
	          new PriorityQueue<>(
	              k,
	              new Comparator<ArrayContainer>() {
	                @Override
	                public int compare(final ArrayContainer o1, final ArrayContainer o2) {
	                  return Integer.compare(o1.arr[o1.index], o2.arr[o2.index]);
	                }
	              });
	      
	      int total = 0;
	    //add arrays to heap
			for (int i = 0; i < arrays.length; i++) {
				queue.add(new ArrayContainer(arrays[i], 0));
				total = total + arrays[i].length;
			}

			//while heap is not empty
	      while (!queue.isEmpty()) {
	        final ArrayContainer ac = queue.poll();
	        result.add(ac.arr[ac.index]);

	        if (ac.index < ac.arr.length - 1) {
	          queue.add(new ArrayContainer(ac.arr, ac.index + 1));
	        }
	      }
	      return result;
	    }

	    public static void main(final String[] args) {
	      final Scanner sc = new Scanner(System.in);
	      int t = sc.nextInt();
	      while (t-- > 0) {
	        final int n = sc.nextInt();
	        final int[][] a = new int[n][n];
	        for (int i = 0; i < n; i++) {
	          for (int j = 0; j < n; j++) {
	            a[i][j] = sc.nextInt();
	          }
	        }
	        final GfG g = new GfG();
	        final ArrayList<Integer> arr = GfG.mergeKArrays(a, n);
	        printArray(arr, n * n);
	      }
	    }

	    public static void printArray(final ArrayList<Integer> arr, final int size) {
	      for (int i = 0; i < size; i++) {
	        System.out.print(arr.get(i) + " ");
	      }
	      System.out.println();
	    }
	  }


}
