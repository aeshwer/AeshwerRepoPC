import java.util.HashSet;


public class PermuationOfNonDistinctString {
	 public String swap(String a, int i, int j)
	    {
	        char temp;
	        char[] charArray = a.toCharArray();
	        temp = charArray[i] ;
	        charArray[i] = charArray[j];
	        charArray[j] = temp;
	        return String.valueOf(charArray);
	    }
	 
	 private void permute(String str, int l, int r, HashSet<String> set)
	    {
	        if (l == r)
	        {	
	        	if(set.contains(str) == false)
	            {
	        		set.add(str);
	        		System.out.println(str);
	            }
	        }
	        else
	        {
	            for (int i = l; i <= r; i++)
	            {
	                str = swap(str,l,i);
	                permute(str, l+1, r,set);
	                str = swap(str,l,i);
	            }
	        }
	    }
	public static void main(String[] args) {

        String str = "ABCA";  // here the string has duplicates
        int n = str.length();
        PermuationOfNonDistinctString permutation = new PermuationOfNonDistinctString();
        HashSet<String> set = new HashSet<String>();
        permutation.permute(str, 0, n-1,set);
        
        
	}
}
