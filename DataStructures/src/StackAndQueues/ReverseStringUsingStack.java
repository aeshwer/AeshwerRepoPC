package StackAndQueues;

import java.util.Stack;

public class ReverseStringUsingStack {

	 static void reverse(StringBuffer str)
	 {	
		 // create a empty stack and push the string 
		 Stack<Character> s = new Stack<Character>();
		 int len = str.length();
		 for(int i= 0; i<len ;i ++)
		 {
			 s.push(str.charAt(i));
		 }
		 
		 //pop the string and print it
		 for(int i= 0; i<len ;i ++)
		 {
			 System.out.print(s.pop());
		 }
	 }
	
	
	public static void main(String[] args) {
		//create a new string
        StringBuffer  s = new StringBuffer("GeeksforGeeks");
        System.out.println("Original string is : " + s );
        //print the reversed string
        System.out.print("Reversed string is : " );
        //call reverse method
        reverse(s);
	}

}
