/*
 * Minimum number of coin to form total value
 * 
 * Total : 4 by 1,2,3 coins
 * 
 *  	//Time complexity of this function: O(mn)
        //Space Complexity of this function: O(n)
 */
package DynamicProgrammingPractise;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class CoinChange {

	public static int minimumCoinTopDown(int total, int coins[], Map<Integer, Integer> map) {
        //if total is 0 then there is nothing to do. return 0.
        if ( total == 0 ) {
            return 0;
        }
        //if map contains the result means we calculated it before. Lets return that value.
        if ( map.containsKey(total) ) {
            return map.get(total);
        }

        //iterate through all coins and see which one gives best result.
        int min = Integer.MAX_VALUE;
        for ( int i=0; i < coins.length; i++ ) {
            //if value of coin is greater than total we are looking for just continue.
            if( coins[i] > total ) {
                continue;
            }
            //recurse with total - coins[i] as new total
            int val = minimumCoinTopDown(total - coins[i], coins, map);

            //if val we get from picking coins[i] as first coin for current total is less
            // than value found so far make it minimum.
            if( val < min ) {
                min = val;
            }
        }

        //if min is MAX_VAL dont change it. Just result it as is. Otherwise add 1 to it.
        min =  (min == Integer.MAX_VALUE ? min : min + 1);   // 1 comming from 1 coin  we  picked from the above for loop

        //memoize the minimum for current total.
        map.put(total, min);
        return min;
    }
    
	public static void main(String[] args) {
		 
		int total = 13;
        int coins[] = {7, 3, 2, 6};
        Map<Integer, Integer> map = new HashMap<>();
        int topDownValue = minimumCoinTopDown(total, coins, map);
        System.out.print(String.format("Top down result %s", topDownValue));
	}

}
