/* (Top Down): The memoized program for a problem is similar to the recursive version with a small modification that it looks into a lookup table before computing solutions. 
 * We initialize a lookup array with all initial values as NIL. Whenever we need solution to a subproblem, we first look into the lookup table. 
 * If the precomputed value is there then we return that value, otherwise we calculate the value and put the result in lookup table so that it can be reused later.
 */
package DynamicProgrammingPractise;

import java.util.Arrays;

public class FabonacciMemorizationMethod {
	  private static final int MAX = 100;
	  private static final int NIL = -1;
	  private static int lookup[] = new int[MAX];
	  
	  /* Function to initialize NIL values in lookup table */
	  public static void initialize()
	  {
	    	Arrays.fill(lookup, NIL);
	  }
	  
	  /* function for nth Fibonacci number */
	  public static int fib(int n)
	  {
	    if (lookup[n] == NIL)
	    {
	      if (n <= 1)
	          lookup[n] = n;
	      else
	          lookup[n] = fib(n-1) + fib(n-2);
	    }
	    return lookup[n];
	  }
	
	public static void main(String[] args)
	  {
	    int n = 5;
	    initialize();
	    System.out.println(n + "th "+ "Fibonacci number is" + " " + fib(n));
	  }
}
