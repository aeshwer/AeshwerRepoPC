//https://practice.geeksforgeeks.org/problems/palindromic-array/0
package July14;

import java.util.Scanner;

public class PalindromeArray {
	
	private static int numberOfOperationToMakePalindromeArray(int[] arr, int length) {
		int start=0;
		int end=length-1;
		int operation=0;
		
		while(start<=end) {
			if(arr[start]==arr[end])
			{
				start++;
				end--;
			}
			else if(arr[start]>arr[end]) {
				while(arr[end]<=arr[start]) 
				{
					arr[end-1] += arr[end];
					end--;
					operation++;
					if(arr[start]==arr[end]) 
					{
						start++;
						end--;
						break;
					}
				}
			}
			
			else if(arr[end]>arr[start]) {
				while(arr[start]<=arr[end]) 
				{
					arr[start+1] += arr[start];
					start++;
					operation++;
					if(arr[start]==arr[end]) 
					{
						start++;
						end--;
						break;
					}
				}
			}
			
		}
		return operation;	
	}

	public static void main(String[] args) {
		
		Scanner s = new Scanner(System.in);
		int cases = s.nextInt();
		
		while(--cases>=0) 
		{
			int n = s.nextInt();
			int i=0;
			int arr[] = new int[n];
			while(--n>=0) {
				arr[i++]=s.nextInt();
			}
			System.out.println(numberOfOperationToMakePalindromeArray(arr,arr.length));
		}
	}
}
