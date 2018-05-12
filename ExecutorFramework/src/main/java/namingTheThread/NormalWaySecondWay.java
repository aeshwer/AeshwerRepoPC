/*
 * Dont rename the thread  at run time like first way,,its not recemended...rather name it before the thread starts or if not then in the run() method
 * use the Thread.getCurrentThreat().getName every time to extracr name  
 */
package namingTheThread;

public class NormalWaySecondWay {
	
	public static void main(String[] args) {
		
		String currentThread = Thread.currentThread().getName(); 
		
		System.out.println(currentThread + "Main Thread Starts Here");
		
		new Thread(new LoopTaskC(),"Amazing Thread").start();
		Thread t = new Thread(new LoopTaskC());
		t.setName("Batman");
		t.start();
		
		
		System.out.println(currentThread + "Main Thread ENDS Here");
		
	}

}
