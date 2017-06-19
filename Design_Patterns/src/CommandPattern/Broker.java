package CommandPattern;

import java.util.ArrayList;
import java.util.List;
/*
 * A class Broker is created which acts as an invoker object. It can take and place orders.
 * Broker object uses command pattern to identify which object will execute which command based on the type of command.
 */
public class Broker {
	private List<Order> orderList = new ArrayList<Order>(); 

	   public void takeOrder(Order order){
	      orderList.add(order);		
	   }

	   public void placeOrders(){
	   
	      for (Order order : orderList) {
	         order.execute();
	      }
	      orderList.clear();
	   }
	}