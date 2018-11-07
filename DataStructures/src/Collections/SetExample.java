package Collections;

import java.util.HashSet;
import java.util.Iterator;
import java.util.LinkedHashSet;
import java.util.Set;
import java.util.TreeSet;


public class SetExample {

	public static void main(String[] args) {
		Set<Integer> set = new LinkedHashSet<>();
		//Tree set dont allow NULL
		
		// Add elements to the set
	      set.add(3);
	      set.add(2);
	      set.add(4);
	      set.add(3);
	      set.add(null);
	      

	      // Iterating over the elements in the set
	      Iterator<Integer> it = set.iterator();

	      while (it.hasNext()) {
	         // Get element
	         Object element = it.next();
	         if(null!=element )
	         System.out.println(element.toString());
	      }
	}
}
