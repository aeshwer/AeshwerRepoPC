package GarbageCollectionDemo;

public class Customer  {
	private String name;

	public Customer(String name) {
		this.name = name;
	}
	
	public Customer(Customer oldCustomer) {
		this.name = oldCustomer.name; 
	}
	
	public String getName() {
		return name;
	}
	
	public void setName(String name) {
		this.name = name;
	}
	
	public String toString() {
		return name;
	}
	// useless...its called by Garbage collector when it runs(which is unpredictable) ..so don't put clean up code here...
	
	public void finalize()
	{
		System.out.println("This object is been garbage collected");
	}
	
}
