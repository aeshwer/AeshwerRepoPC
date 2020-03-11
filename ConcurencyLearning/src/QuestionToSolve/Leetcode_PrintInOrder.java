package QuestionToSolve;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

// https://leetcode.com/problems/print-in-order/
public class Leetcode_PrintInOrder {

	volatile boolean  first = false;
	volatile boolean  second = false;

	public Leetcode_PrintInOrder() {

	}

	public void first(Runnable printFirst) throws InterruptedException {

		// printFirst.run() outputs "first". Do not change or remove this line.
		printFirst.run();
		first = true;
	}

	public void second(Runnable printSecond) throws InterruptedException {

		// printSecond.run() outputs "second". Do not change or remove this line.
		while (!first) {
		}
		printSecond.run();
		second = true;
	}

	public void third(Runnable printThird) throws InterruptedException {

		// printThird.run() outputs "third". Do not change or remove this line.
		while (!second) {
		}
		printThird.run();
	}

	public static void main(String[] args) {
		Leetcode_PrintInOrder tester = new Leetcode_PrintInOrder();
		ExecutorService newFixedThreadPool = Executors.newFixedThreadPool(3);

		newFixedThreadPool.submit(() -> {
			try {
				tester.first(new Runnable() {
					@Override
					public void run() {
						try {
							TimeUnit.MILLISECONDS.sleep(1000);
						} catch (InterruptedException e) {
							e.printStackTrace();
						}
						System.out.println("FIRST");

					}
				});
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		});
		newFixedThreadPool.submit(() -> {
			try {
				tester.second(new Runnable() {
					@Override
					public void run() {
						System.out.println("SECOND");

					}
				});
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		});
		newFixedThreadPool.submit(() -> {
			try {
				tester.third(new Runnable() {
					@Override
					public void run() {
						System.out.println("THIRD");

					}
				});
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		});

		newFixedThreadPool.shutdown();
	}
}
