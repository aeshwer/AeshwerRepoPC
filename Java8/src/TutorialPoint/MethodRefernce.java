/*Method references help to point to methods by their names. A method reference is described using "::" symbol.
 *A method reference can be used to point the following types of methods ->> static, instance methods and constructor using new operator 
 *
 * Here we have passed System.out::println method as a static method reference.
 */
package TutorialPoint;

import java.util.ArrayList;
import java.util.List;

public class MethodRefernce {
	
		  public static void main(String args[]) {
		      List<String> names = new ArrayList();
		      names.add("Mahesh");
		      names.add("Suresh");
		      names.add("Ramesh");
		      names.add("Naresh");
		      names.add("Kalpesh");
				
		      names.forEach(System.out::println);
		   }
}
