package RecentProblems;

public class ImmutablePojoApp {

	public static void main(String[] args) {
		
		ImmutablePojo immutablePojo = new ImmutablePojo();
		
		immutablePojo.setAge(15);
		immutablePojo.setAge(20);
		
		System.out.println(immutablePojo.getAge());
		
	}

}
