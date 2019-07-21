//https://practice.geeksforgeeks.org/problems/factor-or-multiple/0

package July20;

import java.util.Scanner;

public class FactorOrMultiply {

	private static void resolveResult(int[] arr, int multipleOf) {

		int result=0;
		for (int i = 0; i < arr.length; i++) {
			if(arr[i]%multipleOf==0) {
				result = result | arr[i];
			}
		}
		System.out.println(result);

	}

	public static void main(String[] args) {
		Scanner s = new Scanner(System.in);
		int cases = s.nextInt();

		while (--cases >= 0) {
			int n = s.nextInt();
			int multipleOf = s.nextInt();

			int arr[] = new int[n];
			int i = 0;
			while (--n >= 0) {
				arr[i++] = s.nextInt();
			}
			resolveResult(arr, multipleOf);
		}
	}
}
