package com.udemy.ForkJoin;

import java.util.concurrent.RecursiveAction;

public class SimpelRecursiveAction extends RecursiveAction {

	private int simulatedWork;

	public SimpelRecursiveAction(int simulatedWork) {
		super();
		this.simulatedWork = simulatedWork;
	}

	@Override
	protected void compute() {

		// of work is large then split that task .. amd here we split it into 2 .. its
		// is task cause extends recursive Action
		if (simulatedWork > 100) {
			System.out.println("Parllel execution and split task : " + simulatedWork);
			SimpelRecursiveAction simpelRecursiveAction1 = new SimpelRecursiveAction(simulatedWork / 2);
			SimpelRecursiveAction simpelRecursiveAction2 = new SimpelRecursiveAction(simulatedWork / 2);

			// FORK - Asynchronously submits a subtask for execution in the ForkJoinPool.
			// It places the task in a work-stealing queue, allowing idle threads to take
			// over work from busy threads.
			simpelRecursiveAction1.fork();
			simpelRecursiveAction2.fork();
		} else {
			System.out.println("Dont need parallel execution : " + simulatedWork);
		}
	}

}
