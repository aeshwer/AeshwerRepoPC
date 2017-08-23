/*
 * This method takes the first character of a string (str.charAt(0)) and puts it at the end of the string. And then calls itself on the remainder of the string (str.substring(1)).
 *  Finally adds these two things to get the reverse of the passed string (recursiveMethod(str.substring(1)) + str.charAt(0)). When the passed string is one character or less (str.length() <= 1),
 *   it stops calling itself and just returns the string passed.
	If the “MyJava” is the string to reverse, then this method works like this.

1st Call —>   recursiveMethod(“MyJava”)
2nd Call —> recursiveMethod(“yJava”) + “M”
3rd Call —>  (recursiveMethod(“Java”) + “y”) + “M”
4th call —>  ((recursiveMethod(“ava”) + “J”)+”y”) + “M”
5th Call —>  (((recursiveMethod(“va”) + “a”) + “J”)+”y”) + “M”
6th Call —>  ((((recursiveMethod(“a”) + “v”) + “a”) + “J”)+”y”) + “M”
 */
public class ReverseTheString {
	
	static String recursiveMethod(String str)
    {
         if ((null == str) || (str.length() <= 1))
         {
                return str;
         }
         return recursiveMethod(str.substring(1)) + str.charAt(0);
    }
	
	public static void main(String[] args) {
		String str = "MyJava aes";
        //1. Using StringBuffer Class
        StringBuffer sbf = new StringBuffer(str);
        System.out.println(sbf.reverse());    //Output : avaJyM
 
        //2. Using iterative method
        char[] strArray = str.toCharArray();
        for (int i = strArray.length - 1; i >= 0; i--)
        {
            System.out.print(strArray[i]);    //Output : avaJyM
        }
        System.out.println();
 
        //3. Using Recursive Method
        System.out.println(recursiveMethod(str));    //Output : avaJyM
        
        // Understanding substring function
    	String str1 = "Aes";
    	System.out.println(str1.substring(1));
	}

}
