//https://dzone.com/articles/java-8-lambas-limitations-closures

package TutorialPoint;

import java.util.ArrayList;
import java.util.List;

public class ClouserProperty {

	static int global = 0;
	public static void main(String[] args) {
		int count = 0;
		List<Integer> trick = new ArrayList<>();
		
		for(int i=0;i<5;i++) 
		{
			new Thread( () -> System.out.println(count)).start();    // allowed
			new Thread( () -> System.out.println(global++)).start(); // allowed
			//doing count++ is not allowed 
			//new Thread( () -> System.out.println(count++)).start();  // not allowed
			
			//lets cheat .. but don't do this as not thread safe..
			/*new Thread( () ->{
				trick.add(count);
				int temp= trick.get(0);
				trick.set(0, temp++);
			} ).start(); */
		}
		
		// same problem in old way also
		/*int answer = 42;
		Thread t = new Thread(new Runnable() {
		    public void run() {
		        System.out.println("The answer is: " + answer++);
		    }
		});
		t.start();*/
		
		
		// same problem in old way also
		/*int myVar = 42;
	    Supplier<Integer> lambdaFun = () -> myVar; // error
	    myVar++;
	    System.out.println(lambdaFun.get());*/
	}
}
