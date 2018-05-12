/*
 * My default main thread is assigned as main and workers thread are assigned as Thread 0 1 2 so on. 
 */
package namingTheThread;

public class NormalWayFirstWay {

	public static void main(String[] args) {
		
		String currentThread = Thread.currentThread().getName(); 
		
		System.out.println(currentThread + "Main Thread Starts Here");
		
		new Thread(new LoopTaskB()).start();
		new Thread(new LoopTaskB()).start();
		
		System.out.println(currentThread + "Main Thread ENDS Here");
	}
}
