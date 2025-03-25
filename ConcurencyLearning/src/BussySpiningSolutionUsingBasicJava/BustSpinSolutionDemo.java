package BussySpiningSolutionUsingBasicJava;

public class BustSpinSolutionDemo {

	public static void main(String[] args) {
		ProducerThread pt = new ProducerThread();
		Thread t1 = new Thread(pt, "Producer");
		// passing producer thread in consumer thread
		Thread t2 = new Thread(new ConsumerThread(pt), "Consumer");
		t1.start();
		t2.start();    
	}
}