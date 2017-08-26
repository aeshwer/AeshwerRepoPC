/*
 * http://www.geeksforgeeks.org/dynamic-programming-set-13-cutting-a-rod/
 */
package DynamicProgrammingPractise;

public class RodCuttingProblem {
 
 public static int maxValue1(int price[]){
     int max[] = new int[price.length+1];
     //fill the matrix with  prices starting from index 1 
     for(int i=1; i <= price.length; i++){
         max[i] = price[i-1];
     }
     for(int i=1 ; i <= price.length; i++){
         for(int j=1; j < i ; j++){
             max[i] = Math.max(max[i], max[i-j] + max[j]);
         }
     }
     return max[price.length];
 }
 
 
	public static void main(String[] args) {
		int arr[] = new int[] {1, 5, 8, 9, 10, 17, 17, 20};
        int size = arr.length;
        System.out.println("Maximum Obtainable Value is " + maxValue1(arr));
	}
}
