package RecentProblems;

public class TypicalCasesOfPolymorphism {

	private int add(int a,int b) {
		return a+b;
	}

	@SuppressWarnings("unused")
	private int add(Object a, Object b) {
		return 1;
	}

	public static void main(String[] args) {

		TypicalCasesOfPolymorphism casesOfPolymorphism = new  TypicalCasesOfPolymorphism();

		int result = casesOfPolymorphism.add(5,7);
		//int result = casesOfPolymorphism.add(Integer.valueOf(5),Integer.valueOf(7));
		System.out.println("result is :"+result);
	}

}
