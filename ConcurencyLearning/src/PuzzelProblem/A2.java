package PuzzelProblem;

public class A2 implements Runnable {

	private int seconds;

	public A2(int seconds) {
		this.seconds = seconds;
	}

	@Override
	public void run() {
		System.out.println("Hello From A2 with time " + seconds);

	}

	public int getSeconds() {
		return seconds;
	}

	public void setSeconds(int seconds) {
		this.seconds = seconds;
	}

}
