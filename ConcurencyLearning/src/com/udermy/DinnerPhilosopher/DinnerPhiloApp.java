package com.udermy.DinnerPhilosopher;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class DinnerPhiloApp {

	public static final int NUMBER_OF_PHILOSOPHER = 5;
	public static final int NUMBER_OF_CHOPSTICKS = 5;
	public static final int SIMULATION_RUNTIME = 5000; // in milli seconds
	public static final ExecutorService executerService = Executors.newFixedThreadPool(NUMBER_OF_PHILOSOPHER);
	public static final Philosopher[] philosopher = new Philosopher[NUMBER_OF_PHILOSOPHER];
	public static final Chopsitick[] Chopsiticks = new Chopsitick[NUMBER_OF_CHOPSTICKS];

	public static void main(String[] args) throws InterruptedException {
		try {

			for (int i = 0; i < NUMBER_OF_CHOPSTICKS; i++) {
				// initializing the chopsticks with id and each get a new reentrant lock
				// also(see constructor)
				Chopsiticks[i] = new Chopsitick(i);
			}

			for (int i = 0; i < NUMBER_OF_PHILOSOPHER; i++) {
				// assign 2 chopstick to each philosoper
				philosopher[i] = new Philosopher(i, Chopsiticks[i], Chopsiticks[(i + 1) % NUMBER_OF_CHOPSTICKS]);
				executerService.submit(philosopher[i]);
			}

			Thread.sleep(SIMULATION_RUNTIME);
			// stop the philosopher by setting the termination flag
			for (Philosopher p : philosopher) {
				p.setFull(true);
			}

		} finally {
			executerService.shutdown();
			while (!executerService.isTerminated()) {
				Thread.sleep(1000);
			}

			for (Philosopher p : philosopher) {
				System.out.println(p + "eats " + p.getCounter());
			}

		}
	}

}
