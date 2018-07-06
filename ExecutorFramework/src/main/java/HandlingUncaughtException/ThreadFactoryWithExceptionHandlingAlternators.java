package HandlingUncaughtException;

import java.util.concurrent.atomic.AtomicInteger;

import namingTheThread.NamedThreadFactory;

public class ThreadFactoryWithExceptionHandlingAlternators extends NamedThreadFactory{
	
	private AtomicInteger count = new AtomicInteger(0);
	
	@Override
	public Thread newThread(Runnable r) {
		Thread t = super.newThread(r);
		if(count.incrementAndGet() %2 == 0)
		{
			t.setUncaughtExceptionHandler(new ThreadExceptionHandler());
		}
		return t;
	}

}
