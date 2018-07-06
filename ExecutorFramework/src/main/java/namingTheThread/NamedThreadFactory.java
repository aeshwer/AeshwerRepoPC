package namingTheThread;

import java.util.concurrent.ThreadFactory;
import java.util.concurrent.atomic.AtomicInteger;

public class NamedThreadFactory implements ThreadFactory{
	
	private static AtomicInteger count = new AtomicInteger(0);
	private static String NAME = "MyThread-";
	
	
	public Thread newThread(Runnable r) {
		Thread t = new Thread(r,NAME+ count.incrementAndGet());
		return t;
	}

}
