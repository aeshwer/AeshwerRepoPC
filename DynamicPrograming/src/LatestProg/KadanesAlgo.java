package LatestProg;

public class KadanesAlgo {

	public static void main(String[] args) {
		// int arr[]= {-2,1,-3,4,-1,2,1,-5,4}; //6
		// int arr[]={-2, -3, 4, -1, -2, 1, 5, -3}; //7
		int arr[] = {-1 ,-2, -3, -4};

		// Kadanes algo- Maximum contigous subarray sum

		int maxValue = arr[0];
		for (int i = 1; i < arr.length; i++) {
			arr[i] = Math.max(arr[i], arr[i] + arr[i - 1]);
			maxValue = Math.max(arr[i], maxValue);
		}
		System.out.println("Maximum contigous subarray sum is  :" + maxValue);

	}
}
