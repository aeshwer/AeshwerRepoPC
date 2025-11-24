package BussySpiningSolutionUsingBasicJava;

public class ConsumerThread implements Runnable {

	ProducerThread pt;

	ConsumerThread(ProducerThread pt) {
		System.out.println("Constructor Consumer Thread");
		this.pt = pt;
	}

	@Override
	public void run() {
		System.out.println("consumer before sync entry...");
		synchronized (pt) {
			while (pt.flag) { // Proper waiting instead of busy spinning
				System.out.println("Waiting...");
				try {
					pt.wait();
				} catch (InterruptedException e) {
					 Thread.currentThread().interrupt();
					e.printStackTrace();
				}
			}
		}

		System.out.println("Consumer starting");
		synchronized (pt) {
			for (Integer i : pt.sharedListObj) {
				System.out.println(i);
			}
		}
	}
}
