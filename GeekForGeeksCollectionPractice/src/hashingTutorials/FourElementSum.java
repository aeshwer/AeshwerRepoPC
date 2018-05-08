package hashingTutorials;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;

/* Given an array of distinct integers, find if there are two pairs (a, b) and (c, d)
 *  such that a+b = c+d, and a, b, c and d are distinct elements. 
 * If there are multiple answers, then print any of them.
 * * Complexcity O(n2Log n)  ..... improved by using  hashset O(n2)
 * Input : {3, 4, 7, 1, 2, 9, 8}; Output : (3, 8) and (4, 7)
 */
public class FourElementSum {
	
	
	class pair 
	{
		int first ,second;
		pair(int first, int second)
		{  
			this.first =  first;
			this.second =second; 
		}
	}
	
	boolean findPairs(List<Integer> arr, int n)
	{
		HashMap<Integer, pair> map =  new HashMap<Integer, pair>();
		
		// Traverse through all possible pairs of arr[]
        for (int i=0; i<n; i++)
        {
            for (int j=i+1; j<n; j++)
            {
            	// If sum of current pair is not in hash,
                // then store it and continue to next pair
                int sum = arr.get(i) + arr.get(j);
                if (!map.containsKey(sum))
                { map.put(sum,new pair(i,j));}
                else // Else (Sum already present in hash)
                {
                	pair p =  map.get(sum);
                	// Since array elements are distinct, we don't
                    // need to check if any element is common among pairs
                	System.out.println("("+arr.get(p.first)+", "+arr.get(p.second)+
                            ") and ("+arr.get(i)+", "+arr.get(j)+")");
                	
                	return true;
                }            	
            }
        }
		return false;
	}
	
	public static void main(String[] args) throws IOException{
		
		BufferedReader read = new BufferedReader(new InputStreamReader(System.in));
		System.out.println("Enter array length");
		int n = Integer.parseInt(read.readLine());
		System.out.println("Enter the Array now");
		int length =  n; 
		List<Integer> list = new ArrayList<Integer>(); 
		while(n-- > 0)
		{   int x =  Integer.parseInt(read.readLine()); 
			list.add(x);
		}		
		//Printing Array
		System.out.println("You Entered this Array");
		Iterator<Integer> itr = list.iterator();
        while(itr.hasNext())
        {
        	System.out.println(itr.next() + " ");
        	
        }
        
        FourElementSum fourElementSum =  new FourElementSum();
        fourElementSum.findPairs(list,length);
	}
	

}
