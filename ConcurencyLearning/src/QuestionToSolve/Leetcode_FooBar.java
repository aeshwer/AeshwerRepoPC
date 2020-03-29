package QuestionToSolve;

import java.util.concurrent.Semaphore;

//https://leetcode.com/problems/print-foobar-alternately/

// NOTE : refer for more solution 
//https://leetcode.com/problems/print-foobar-alternately/discuss/348546/Java-4-Java-threading-solutions-(SynchronizedLockVolatileCAS)
public class Leetcode_FooBar {

	private int n;
	Semaphore runFoo = new Semaphore(1);
	Semaphore runBar = new Semaphore(0);

	public Leetcode_FooBar(int n) {
		this.n = n;
	}

	public void foo(Runnable printFoo) throws InterruptedException {

		for (int i = 0; i < n; i++) {
			runFoo.acquire();
			// printFoo.run() outputs "foo". Do not change or remove this line.
			printFoo.run();
			runBar.release();
		}
	}

	public void bar(Runnable printBar) throws InterruptedException {

		for (int i = 0; i < n; i++) {
			// printBar.run() outputs "bar". Do not change or remove this line.
			runBar.acquire();
			printBar.run();
			runFoo.release();
		}
	}

	public static void main(String[] args) throws InterruptedException {
		Leetcode_FooBar obj = new Leetcode_FooBar(5);
		Thread t1 = new Thread(() -> {
			try {
				obj.foo(new Runnable() {
					@Override
					public void run() {
						System.out.print("Foo");
					}
				});
			} catch (InterruptedException e) {
				e.printStackTrace();
			}

		});
		Thread t2 = new Thread(() -> {
			try {
				obj.bar(new Runnable() {

					@Override
					public void run() {
						System.out.print("Bar");
					}
				});
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		});

		t1.start();
		t2.start();
	}
}
