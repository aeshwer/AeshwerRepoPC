package com.udemy.ForkJoin2;

import java.util.concurrent.RecursiveTask;

import com.udemy.ForkJoin.SimpelRecursiveAction;

public class SimpleRecursiveTask extends RecursiveTask<Integer> {

	private int simulateWork;

	public SimpleRecursiveTask(int simulateWork) {
		this.simulateWork = simulateWork;
	}

	@Override
	protected Integer compute() {

		// of work is large then split that task .. amd here we split it into 2 .. its
		// is task cause extends recursive Action
		if (simulateWork > 100) {
			System.out.println(" Parallel execution needed : " + simulateWork);
			SimpleRecursiveTask simpleRecursiveTask1 = new SimpleRecursiveTask(simulateWork / 2);
			SimpleRecursiveTask simpleRecursiveTask2 = new SimpleRecursiveTask(simulateWork / 2);

			simpleRecursiveTask1.fork();
			simpleRecursiveTask2.fork();

			int solution = 0;
			// JOIN: Waits for the task to complete and retrieves the result.
			// It blocks the current thread until the computation of the forked task is
			// finished.
			solution = solution + simpleRecursiveTask1.join();
			solution = solution + simpleRecursiveTask2.join();
			return solution;

		} else {
			System.out.println("Dont need parallel execution : " + simulateWork);
			return 2 * simulateWork;
		}
	}

}
