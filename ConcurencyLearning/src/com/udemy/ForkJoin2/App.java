package com.udemy.ForkJoin2;

import java.util.concurrent.ForkJoinPool;

import com.udemy.ForkJoin.SimpelRecursiveAction;

public class App {

	public static void main(String[] args) {
		int numberOfCore = Runtime.getRuntime().availableProcessors();
		ForkJoinPool forkJoinPool =  new ForkJoinPool(numberOfCore);
		
		SimpleRecursiveTask simpelRecursiveTask = new SimpleRecursiveTask(200);
		System.out.println(forkJoinPool.invoke(simpelRecursiveTask));
	}

}
