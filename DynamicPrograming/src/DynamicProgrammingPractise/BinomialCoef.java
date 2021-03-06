/*
 * Write a function that takes two parameters n and k and returns the value of Binomial Coefficient C(n, k). 
 * For example, your function should return 6 for n = 4 and k = 2, and it should return 10 for n = 5 and k = 2.
 * 
 * C(n, k) = C(n-1, k-1) + C(n-1, k)
   C(n, 0) = C(n, n) = 1
 */
package DynamicProgrammingPractise;

import java.util.Arrays;

public class BinomialCoef {
	static int MAX= 100;
	static int[][] lookup = new int[MAX][MAX];

	private static void initialize() {
		// Filling a 2d array with some default value
        for (int[] row : lookup)
            Arrays.fill(row, -1);
	}
	
	private static int BioCoef(int n, int k) {
		
		if(lookup[n][k]== -1)
		{
			if(k==0 || k==n){
				lookup[n][k] = 1;
			}
			else
			{
				lookup[n][k] = BioCoef(n-1, k-1) +BioCoef(n-1,k);
			}
			
		}
		return lookup[n][k];
	}
	
	public static void main(String[] args) {
		int n = 4; 
		int k =	2;	
		initialize();
		System.out.println("Binomial Coefficient Value is : " +BioCoef(n,k));
	}

}
