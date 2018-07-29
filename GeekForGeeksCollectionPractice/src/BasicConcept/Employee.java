package BasicConcept;

public class Employee implements Comparable<Employee>{
	
	String name ;
	String location ;
	int age;
	
	Employee(String name , String location ,int age)
	{
		this.name = name;
		this.location = location;
		this.age = age;
				
	}

	@Override
	public int compareTo(Employee o) {
		if(this.age==o.age)  
			return 0;  
		else if(this.age>o.age)  
			return 1;  
		else  
		return -1;
	}
	
	
}
