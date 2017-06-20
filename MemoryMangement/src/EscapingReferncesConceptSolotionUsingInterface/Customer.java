package EscapingReferncesConceptSolotionUsingInterface;

public class Customer implements ICustomerReadOnly {
	
	private String name;

	public Customer(String name) {
		this.name = name;
	}
	
	//copy constructor
	public Customer(Customer oldCustomername) {
		this.name = oldCustomername.name;
	}

	/* (non-Javadoc)
	 * @see EscapingReferncesConceptSolotionUsingInterface.ICustomerReadOnly#getName()
	 */
	@Override
	public String getName() {
		return name;
	}
	
	public void setName(String name) {
		this.name= name;
	}
	
		/* (non-Javadoc)
		 * @see EscapingReferncesConceptSolotionUsingInterface.ICustomerReadOnly#toString()
		 */
		@Override
		public String toString() {
		return name;
	}
	
}
