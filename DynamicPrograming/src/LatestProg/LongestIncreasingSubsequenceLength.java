package LatestProg;

public class LongestIncreasingSubsequenceLength {

	public static void main(String[] args) {
		int arr[] = {50, 3, 10, 7, 40, 80};
		int n = arr.length;
		getLongestIncreasingSubsequence(arr, n);
	}

	private static void getLongestIncreasingSubsequence(int[] arr, int n) {
		int T[] = new int[n];

		int index=0;
		int length = n;
		while(length-->0) {
			T[index++] = 1;
		}

		int j = 0;
		for (int i = 1; i < n; i++) {
			j=0;
			while (j < i) {
				if (arr[i] > arr[j]) {
					T[i]= Math.max(T[i] , T[j]+1); 
				}
				j++;
			}
		}
		
		System.out.println("Sequence Lenght is ->"+ T[n-1]);
		
	}

}


