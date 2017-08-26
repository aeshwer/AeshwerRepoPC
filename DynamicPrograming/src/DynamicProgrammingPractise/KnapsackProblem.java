/*
 * http://www.geeksforgeeks.org/knapsack-problem/	
 */
package DynamicProgrammingPractise;

public class KnapsackProblem {
	 /**
     * Solves 0/1 knapsack in bottom up dynamic programming
     */
    public static int bottomUpDP(int val[], int wt[], int W){
        int K[][] = new int[val.length+1][W+1];
        for(int i=0; i <= val.length; i++){
            for(int j=0; j <= W; j++){
                if(i == 0 || j == 0){
                    K[i][j] = 0;
                    continue;
                }
                if(j - wt[i-1] >= 0){           // our current weight is less than items weight
                    K[i][j] = Math.max(K[i-1][j], K[i-1][j-wt[i-1]] + val[i-1]);
                }else{
                    K[i][j] = K[i-1][j];  //  if weight is more than the items weight, then go up this option
                }
            }
        }
        return K[val.length][W];
    }

	public static void main(String[] args) {
	        int val[] = {60, 100, 120};
	        int wt[] = {10, 20, 30};
	        int r1 =bottomUpDP(val, wt, 50);  //  knapsack capacity is 30
	        System.out.println(r1);
	}

}
