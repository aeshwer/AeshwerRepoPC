package HandlingUncaughtException;

public class ExceptionLeakingTask implements Runnable{

	public void run() {
		throw new RuntimeException();
		// why runtime...why not some checked exception...because run method of runnable interface don't declare any checked exception..
		// ... so we are forced to handle all checked exception inside the run method
	}

}
