//CONCEPT : https://www.techiedelight.com/sort-k-sorted-array/
//https://practice.geeksforgeeks.org/problems/nearly-sorted-algorithm/0

//Time:O(nLogk)
//extra space: O(K)
package July13;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.PriorityQueue;
import java.util.Scanner;

public class NearlySortedArray {
	
	private static void sortArray(List<Integer> list, int k) {
		
		//create a empty min heap and insert first k+1 elements in the heap
		PriorityQueue<Integer> pq = new PriorityQueue<Integer>(list.subList(0, k+1));
		
		int index=0;
		
		//do for remaining elements of the array
		for (int i = k + 1; i < list.size(); i++)
		{
			// pop top element from min-heap and assign it to
			// next available array index
			//list.set Api:Replaces the element at the specified position in this list with the specified element.
			list.set(index++, pq.poll());

			// push next array element into min-heap
			pq.add(list.get(i));
		}
		

		// pop all remaining elements from the min heap and assign it to
		// next available array index
		while(!pq.isEmpty())
		{
			list.set(index++, pq.poll());
		}
		
		for(Integer l : list) 
		{
			System.out.print(l+" ");
		}
		System.out.println();
		
	}

	public static void main(String[] args) throws NumberFormatException, IOException {
		
		Scanner s = new Scanner(System.in);
		
		int cases = s.nextInt();
		
		while(--cases >= 0) {
			int n= s.nextInt();
			int k= s.nextInt();
			
			 List<Integer> list  = new ArrayList<Integer>(n);
			
			 while(--n>=0)
		        {
		            list.add(s.nextInt());
		        }

			 sortArray(list,k);
		}
	}

}
