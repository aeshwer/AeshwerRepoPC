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
			System.out.println("consumer got producer lock...");
			while (pt.flag) { // Proper waiting instead of busy spinning
				System.out.println("Waiting...");
				try {
					System.out.println("consumer release lock as producer still not produced ...");
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
