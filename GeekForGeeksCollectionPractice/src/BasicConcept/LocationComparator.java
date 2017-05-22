package BasicConcept;

import java.util.Comparator;

public class LocationComparator implements Comparator<Employee>{
	
	@Override
	public int compare(Employee e1 , Employee e2)
	{
		return e1.location.compareTo(e2.location);
	}

}
