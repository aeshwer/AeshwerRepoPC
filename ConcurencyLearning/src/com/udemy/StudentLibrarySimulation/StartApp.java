package com.udemy.StudentLibrarySimulation;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class StartApp {

	public static final int NUMBER_OF_STUDENTS = 2;
	public static final int NUMBER_OF_BOOKS = 1;

	public static void main(String[] args) {

		Student[] student = new Student[NUMBER_OF_STUDENTS];
		Book[] books = new Book[NUMBER_OF_BOOKS];
		ExecutorService executorService = Executors.newFixedThreadPool(NUMBER_OF_STUDENTS);

		try {
			for (int i = 0; i < NUMBER_OF_BOOKS; i++) {
				books[i] = new Book(i);
			}

			for (int i = 0; i < NUMBER_OF_STUDENTS; i++) {
				student[i] = new Student(i, books);
				executorService.execute(student[i]);
			}
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			executorService.shutdown();
		}
	}
}
