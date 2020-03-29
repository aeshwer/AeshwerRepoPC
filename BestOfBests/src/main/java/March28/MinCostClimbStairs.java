package March28;

//https://leetcode.com/problems/min-cost-climbing-stairs/
public class MinCostClimbStairs {

		public static int minCostClimbingStairs(int[] cost) {
	        for (int i = 2; i < cost.length; i++) {
	            cost[i] += Math.min(cost[i-1], cost[i-2]);
	        }
	        return Math.min(cost[cost.length-1], cost[cost.length-2]);}

	public static void main(String[] args) {
		int[] cost = {  0,1,2,2 };
		System.out.println(minCostClimbingStairs(cost));
	}

}
