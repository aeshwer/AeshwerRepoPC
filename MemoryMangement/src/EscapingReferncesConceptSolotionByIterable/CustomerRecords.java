package EscapingReferncesConceptSolotionByIterable;

import java.util.Collection;
import java.util.Collections;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

import javax.xml.bind.annotation.adapters.CollapsedStringAdapter;

public class CustomerRecords implements Iterable<Customer>{
	private Map<String, Customer> records;
	
	public CustomerRecords() {
		this.records = new HashMap<String, Customer>();
	}
	
	public void addCustomer(Customer c) {
		this.records.put(c.getName(), c);
	}
	/*	
	//solution 2
	public Map<String, Customer> getCustomers() {
		//lets return a new hashmap and pass existing hashmap  in the constructor of the new hashmap 
		return new HashMap<String, Customer>(this.records);
		// so return a copy of hashmap
	}*/

	//solution 1 
	@Override
	public Iterator<Customer> iterator() {
		return records.values().iterator();
	}
	
	
	//solution 3
	public Map<String, Customer> getCustomers() {
		//lets return a new hashmap and pass existing hashmap  in the constructor of the new hashmap 
		return Collections.unmodifiableMap(this.records);
		// so return a copy of immytable hashmap
	}
	
	/*
	//yet another escaping  refernce problem....solve it by making a copy constructor like in collection case
	public Customer getCustomerByName(String name)
	{
		return this.records.get(name);
	}
	 */
	
	//Solution to this method
		public Customer getCustomerByName(String name)
		{
			return new Customer(this.records.get(name));
		}
	
	}
