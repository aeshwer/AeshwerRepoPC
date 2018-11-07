package Collections;

public class Top {
	
	private int a= 1;
	private static int b= 1;
	
	
	public  static void test2() 
	{
		System.out.println("Hello Top"+b+" ");
	}

	public int test(int s) 
	{
		System.out.println("HelloQQQQQ");
		return b++;
	}
	
	
	public  void test() 
	{
		b++;
		System.out.println("Hello Top"+b +a);
	}
	
	
	
	public static void main(String[] args) {
		Top x = new Bottom();
		 x.test();
		x.test2();
	}

}
