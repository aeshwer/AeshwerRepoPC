package RecentProblems;

public class NormalClass extends AbstractClass{

	@Override
	int add(int a, int b) {
		return a+b;
	}

	@Override
	int sub(int a, int b) {
		return a-b;
	}
	
	void methodOfNormalClass() 
	{
		System.out.println("Hello Mr. Normal class");
	}

}
