/*
 * Annoymus  implementation
 */
package executorFramework1;

import java.util.concurrent.TimeUnit;

public class FifthWay {

	public static void main(String[] args) {
		
		System.out.println("MAIN THREAD START");
		
		Thread t = new Thread(new Runnable() {
			
			public void run() {
				for(int i=10;i>0;i--) {System.out.println(" TICK TICK "+i);
				
				try {
					TimeUnit.MILLISECONDS.sleep(200);
				} catch (InterruptedException e) {
					e.printStackTrace();
				}
				}
				
			}
		});
		
		t.start();

		System.out.println("MAIN THREAD ENDS");
	}

}
