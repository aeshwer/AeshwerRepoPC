package BestPracticeHashing;

import java.util.Map;

public class HashApp {

	private static Map<Employee, String> map;
	
	public static void main(String[] args) {
		
		Employee e1 = new Employee("Aeshwer", 28);
		Employee e2 = new Employee("Karan", 8);
		
		map.put(e1	,e1.getName());
		map.put(e2	,e2.getName());
		
		for(Map.Entry<Employee, String> m : map.entrySet()) 
		{
			System.out.println(m.getKey() + " : " + m.getValue());
		}
	}
}
