package InternalizedStrings;

/*Since java.lang.String class override equals method, It return true if 
 * two String object contains same content but == will only return true if 
 * two references are pointing to the same object. 
 */

public class InternalizedString {

	public static void main(String[] args) {

		//EXAMPLE 1

		String s1= "Hello";
		String s2= "Hello";

		//EXAMPLE 2

		String s3= new String("Hello");
		String s4= new Integer(79).toString().intern(); //intern forces the string to be placed in the string pool
		String s5=  "79";
		String s6=  "100";
		String s7=  new Integer(100).toString();


		System.out.println("-----------HASH CODES-----------");
		System.out.println(s1.hashCode());
		System.out.println(s2.hashCode());
		System.out.println(s3.hashCode());
		System.out.println(s4.hashCode());
		System.out.println(s5.hashCode());
		System.out.println(s6.hashCode());
		System.out.println(s7.hashCode());

		System.out.println("-----------COMPARISON RESULTS-----------");
		System.out.println("s1 Equals s2 = "+s1.equals(s2));  // Equals compares the content
		System.out.println("s1 Equals s3 = "+s1.equals(s3));
		System.out.println("s4 Equals s5 = "+s4.equals(s5));
		System.out.println("s6 Equals s7 = "+s6.equals(s7));

		//EXTRA
		boolean x = s4==s5 ? true : false;
		boolean y = s6==s7 ? true : false;

		System.out.println("s4 == s5 = "+x); // == is for checking same memory reference 
		System.out.println("s6 == s7 = "+y);
	}


}
