// Leaking Exceptions from threads cannot be caught

package HandlingUncaughtException;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

import namingTheThread.NamedThreadFactory;

public class HandlingUncaughtExeceptionForEveryThread {

	public static void main(String[] args) throws Exception {
		String currentThread = Thread.currentThread().getName(); 
		System.out.println(currentThread + "Main Thread Starts Here");

		ExecutorService executorService = Executors.newCachedThreadPool(new NamedThreadFactory());

		System.out.println(currentThread + "Main Thread ENDS Here");
	}
}

