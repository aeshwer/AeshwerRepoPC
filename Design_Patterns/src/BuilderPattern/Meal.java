package BuilderPattern;

import java.util.ArrayList;
import java.util.List;

public class Meal {
	 private List<Item> listOfItems = new ArrayList<Item>();	

	   public void addItem(Item item){
	      listOfItems.add(item);
	   }

	   public float getCost(){
	      float cost = 0.0f;
	      
	      for (Item item : listOfItems) {
	         cost += item.price();
	      }		
	      return cost;
	   }

	   public void showItems(){
	   
	      for (Item item : listOfItems) {
	         System.out.print("Item : " + item.name());
	         System.out.print(", Packing : " + item.packing().pack());
	         System.out.println(", Price : " + item.price());
	      }		
	   }	
	}