/*
 * This is an interesting array coding problem, just opposite of question related to finding duplicates in array.
 *  Here you need to find the unique number which is not repeated twice. 
 * For example if given array is {1, 1, 2, 2, 3, 4, 4, 5, 5} then your program should return 3.
 */
package TopArraysProblem;

import java.util.HashMap;
import java.util.Map;

public class FindUNiqueElement {
	
	private static void uniqueNumber(int[] arr1, int m) {
		HashMap<Integer, Integer> map = new HashMap<>();
		for(int i=0; i<m;i++) 
		{
			if(map.containsKey(arr1[i])) {
			map.put(arr1[i], map.get(arr1[i])+1);
			}
			else
			map.put(arr1[i],1);
		}
		
		for(Map.Entry<Integer, Integer> m1 : map.entrySet()) 
		{
			if(m1.getValue()==1) 
			{
				System.out.println(m1.getKey());
			}
		}
	}
	public static void main(String[] args) {
		int arr1[] = {1, 1, 2, 2, 3, 4, 4, 5, 5};
		int m = arr1.length;
		uniqueNumber(arr1, m);
	}
}
