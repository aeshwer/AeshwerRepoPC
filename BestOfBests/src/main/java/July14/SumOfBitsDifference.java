//https://practice.geeksforgeeks.org/problems/sum-of-bit-differences/0

//Done by me

package July14;

import java.util.Scanner;

public class SumOfBitsDifference {
	
	private static void resolveBitsDifferenceSum(int[] arr, int length) {
		
		int sum=0;
		
		for(int i=0; i<length; i++) {
			for(int j=0; j<length; j++) {
				if(j!=i)
				sum+= computeDifference(arr[i],arr[j]);
			}
			
		}
		
		System.out.println(sum);
	}

	
	private static int computeDifference(int i, int j) {
		
		String binaryString1 = Integer.toBinaryString(i);
		String binaryString2 = Integer.toBinaryString(j);
		
		int length1 = binaryString1.length();
		int length2 = binaryString2.length();
		
		int index= Math.max(length1, length2);
		int sum=0;
		while(length1>0 && length2>0 )
		{	
			/*if(length1==0 || length2==0) {
				sum++;
				length1--;
				length2--;
				}*/
			if(!(binaryString1.charAt(--length1) == binaryString2.charAt(--length2))) {
				sum=sum+1;
			}
			index--;
			
		}
		if(length1!=0) {
			while(index>0) {
				if(binaryString1.charAt(--index)=='1') {
					sum++;
				}
			}
		}
		
		else if (length2!=0) {
			while(index>0) {
				if(binaryString2.charAt(--index)=='1') {
					sum++;
				}
			
				
			}
		}
		
		return sum;
	}


	public static void main(String[] args) {
		
		Scanner s = new Scanner(System.in);
		int cases = s.nextInt();
		
		while(--cases>=0){	
			int n = s.nextInt();
			int arr[] = new int[n];
			int i=0;
			while(--n>=0){
				arr[i++]=s.nextInt();
			}
			
			resolveBitsDifferenceSum(arr,arr.length);
		}
	}
}
