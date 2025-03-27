package com.udemy.ForkJoin;

import java.util.concurrent.ForkJoinPool;

public class App {

	public static void main(String[] args) {

		int numberOfCore = Runtime.getRuntime().availableProcessors();
		// ForkJoinPool is a specialized thread pool designed for parallel processing of
		// recursive tasks using a divide-and-conquer approach.
		// Used where Tasks that can be broken down into smaller independent subtasks.

		ForkJoinPool forkJoinPool = new ForkJoinPool(numberOfCore);

		SimpelRecursiveAction simpelRecursiveAction = new SimpelRecursiveAction(200);
		forkJoinPool.invoke(simpelRecursiveAction);
	}

}
