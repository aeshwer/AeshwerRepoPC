/* If s1 and s2 are two given strings, then write a java program to check whether s2 is a rotated version of s1?
 * 
 * EXAPMLE:::::::: If “JavaJ2eeStrutsHibernate” is a string then below are some rotated versions of this string.
	“StrutsHibernateJavaJ2ee”, “J2eeStrutsHibernateJava”, “HibernateJavaJ2eeStruts”.
 */
public class OneStringRotationOfOther {

	public static void main(String[] args) {
		String s1 = "JavaJ2eeStrutsHibernate";
        String s2 = "StrutsHibernateJavaJ2ee";
 
        //Step 1
        if(s1.length() != s2.length())
        {
            System.out.println("s2 is not rotated version of s1");
        }
        else
        {
            //Step 2
            String s3 = s1 + s1;
            //Step 3
            if(s3.contains(s2))
            {
                System.out.println("s2 is a rotated version of s1");
            }
            else
            {
                System.out.println("s2 is not rotated version of s1");
            }
        }
	}
}