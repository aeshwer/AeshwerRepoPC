package PuzzelProblem;

public class A1 implements Runnable {

	private int seconds;

	public A1(int seconds) {
		this.seconds = seconds;
	}

	@Override
	public void run() {
		System.out.println("Hello From A1 with time " + seconds);

	}

	public int getSeconds() {
		return seconds;
	}

	public void setSeconds(int seconds) {
		this.seconds = seconds;
	}

}
