package com.udemy.ForkJoin;

import java.util.concurrent.ForkJoinPool;

public class App {

	public static void main(String[] args) {
		
		int numberOfCore = Runtime.getRuntime().availableProcessors();
		ForkJoinPool forkJoinPool =  new ForkJoinPool(numberOfCore);
		
		SimpelRecursiveAction simpelRecursiveAction = new SimpelRecursiveAction(200);
		forkJoinPool.invoke(simpelRecursiveAction);
	}

}
