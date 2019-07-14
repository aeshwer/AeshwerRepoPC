//https://practice.geeksforgeeks.org/problems/kth-smallest-element/0
package July14;

import java.util.Arrays;
import java.util.Scanner;

public class KthSmallestElement {

	private static void resolveKthSmallestElement(int[] arr, int length, int k) {
		Arrays.sort(arr);
		
		System.out.println(arr[k-1]);
		
	}

	public static void main(String[] args) {
		Scanner s = new Scanner(System.in);
		int cases = s.nextInt();
		
		while(--cases>=0) {
			
			int n= s.nextInt();
			int arr[]= new int[n];
			int i=0;
			while(--n>=0) {
				arr[i++]=s.nextInt();
			}
			int k=s.nextInt();
			
			resolveKthSmallestElement(arr,arr.length,k);
		}
		
	}
}
