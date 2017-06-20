package softLeaks;
/*
 * Soft leaks: an object is referenced on the stack even though it will never be used again
 * change heap size in the run config and then arguments tab
 */

public class CustomerHarness {
	
	public static void main(String[] args)  {
		CustomerManager cm = new CustomerManager();
		GenerateCustomerTask task = new GenerateCustomerTask(cm);
		for (int user = 0; user < 10; user++) {
			Thread t = new Thread(task);
			t.start();
		}
		
		//main thread is now acting as the monitoring thread
		while (true) {
			try {
				Thread.sleep(5000);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			cm.howManyCustomers();
			System.out.println("Available memory: " + Runtime.getRuntime().freeMemory() / 1024 + "k");
			
		}
	}

}
