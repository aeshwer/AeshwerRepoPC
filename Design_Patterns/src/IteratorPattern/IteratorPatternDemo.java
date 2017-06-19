package IteratorPattern;
/*
 * his pattern is used to get a way to access the elements of a collection object in sequential manner without any need to know its underlying representation.
 */
public class IteratorPatternDemo {
	
	   public static void main(String[] args) {
		   
	      NameRepository namesRepository = new NameRepository();
	      for(Iterator iter = namesRepository.getIterator(); iter.hasNext();)
	      {
	         String name = (String)iter.next();
	         System.out.println("Name : " + name);
	      } 	
	   }
}