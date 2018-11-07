package ConceptOfStatic;

public class NonStaticClass {
	
	private static int a=1; // can be retreived from anywhere
	
	private int b=2; // can't be retreived from no static method 

	static void StaticMethod1() 
	{
		System.out.println("StaticMethod1 :"+ a /*+ b*/);
	}
	
	void NonStaticMethod1() 
	{
		System.out.println("NonStaticMethod2:"+ a + b);
	}
	
	void NonStaticMethod2() 
	{
		System.out.println("NonStaticMethod2");
	}
}
