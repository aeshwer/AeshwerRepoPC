/*Using lambda expression, you can refer to any final variable or effectively final variable (which is assigned only once).
 * Lambda expression throws a compilation error, if a variable is assigned a value the second time.
 */

package Lesson1;

public class LambdaExpression2 {
	
	final static String salutation = "Hello! ";
	   
	public static void main(String[] args) {
		
	      GreetingService greetService1 = message -> System.out.println(salutation + message);
	      System.out.println("hello start");
	      greetService1.sayMessage("Mahesh");
	      System.out.println("hello final");
		
	}
	
	 interface GreetingService {
	    void sayMessage(String message);
	   }
}
