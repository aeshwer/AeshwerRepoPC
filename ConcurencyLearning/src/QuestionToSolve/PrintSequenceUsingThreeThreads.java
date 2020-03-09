package QuestionToSolve;

import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

/*
 * https://java2blog.com/print-sequence-3-threads-java/
 * You are given 3 threads. You need to print sequence using these 3 threads.You need to print in natural order up to MAX.
 */
public class PrintSequenceUsingThreeThreads implements Runnable {

	private static Integer MAX_LIMIT = 10;
	static int number = 1;
	private int remainder;
	static Object lock = new Object();

	public PrintSequenceUsingThreeThreads(int remainder) {
		this.remainder = remainder;
	}

	@Override
	public void run() {
		synchronized (lock) {
			while (number < MAX_LIMIT - 1) {
				while (number % 3 != remainder) { // wait for numbers other than remainder
					try {
						lock.wait();
					} catch (InterruptedException e) {
						e.printStackTrace();
					}
				}
				System.out.println(Thread.currentThread().getName() + " : " + number);
				number++;
				lock.notifyAll();
			}
		}
	}

	public static void main(String[] args) {
		PrintSequenceUsingThreeThreads obj1 = new PrintSequenceUsingThreeThreads(1);
		PrintSequenceUsingThreeThreads obj2 = new PrintSequenceUsingThreeThreads(2);
		PrintSequenceUsingThreeThreads obj3 = new PrintSequenceUsingThreeThreads(0);

		Thread t1 = new Thread(obj1, "T1");
		Thread t2 = new Thread(obj2, "T2");
		Thread t3 = new Thread(obj3, "T3");

		t1.start();
		t2.start();
		t3.start();
	}

}
