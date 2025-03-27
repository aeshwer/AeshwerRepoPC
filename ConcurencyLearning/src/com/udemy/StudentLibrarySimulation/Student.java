package com.udemy.StudentLibrarySimulation;

import java.util.Random;

public class Student implements Runnable {

	private int id;

	private Book[] book;

	public Student(int id, Book[] book) {
		this.id = id;
		this.book = book;
	}

	@Override
	public void run() {
		Random randon = new Random();
		// infinite simulation
		while (true) {
			int bookId = randon.nextInt(StartApp.NUMBER_OF_BOOKS); // selects a random book to read
			try {
				book[bookId].read(this);
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
	}

	@Override
	public String toString() {
		return "Student #" + id;
	}
}
