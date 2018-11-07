/*
 * Java 8 introduces a new concept of default method implementation in interfaces. 
 * This capability is added for backward compatibility so that old interfaces can be used to leverage the lambda expression capability of Java 8.
 */
package TutorialPoint;

public class DefaultMethod {

	public static void main(String[] args) {
		
		 Vehicle vehicle = new Car();
	      vehicle.print();
	   }
}

	interface Vehicle {

	   default void print() {
	      System.out.println("I am a vehicle!");
	   }
		
	   static void blowHorn() {
	      System.out.println("Blowing horn!!!");
	   }
	}

	interface FourWheeler {

	   default void print() {
	      System.out.println("I am a four wheeler!");
	   }
	}

	
 class Car implements Vehicle, FourWheeler {
	   public void print() {
	      Vehicle.super.print();
	      FourWheeler.super.print();
	      Vehicle.blowHorn();
	      System.out.println("I am a car!");
	   }
	}