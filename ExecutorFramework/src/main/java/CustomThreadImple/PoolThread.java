//http://tutorials.jenkov.com/java-concurrency/thread-pools.html
package CustomThreadImple;

public class PoolThread extends Thread {

	private BlockingQueue taskQueue = null;
	private boolean isStopped = false;

	public PoolThread(BlockingQueue queue) {
		taskQueue = queue;
	}

	public void run() {
		while (!isStopped()) {
			try {
				// The Runnable will be dequeued by an idle PoolThread and executed.
				Runnable runnable = (Runnable) taskQueue.dequeue();
				runnable.run();
			} catch (Exception e) {
				// log or otherwise report exception,
				// but keep pool thread alive.
			}
		}
	}

	public synchronized void doStop() {
		isStopped = true;
		this.interrupt(); // break pool thread out of dequeue() call.
	}
	/*
	 * The threads will stop after finishing any task they are currently executing.
	 * Notice the this.interrupt() call in PoolThread.doStop(). This makes sure that
	 * a thread blocked in a wait() call inside the taskQueue.dequeue() call breaks
	 * out of the wait() call, and leaves the dequeue() method call with an
	 * InterruptedException thrown. This exception is caught in the PoolThread.run()
	 * method, reported, and then the isStopped variable is checked. Since isStopped
	 * is now true, the PoolThread.run() will exit and the thread dies.
	 */

	public synchronized boolean isStopped() {
		return isStopped;
	}
}
