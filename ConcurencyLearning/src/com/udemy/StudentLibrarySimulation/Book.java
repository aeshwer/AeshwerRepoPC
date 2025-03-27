package com.udemy.StudentLibrarySimulation;

import java.util.concurrent.TimeUnit;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class Book {

	private int id;

	private ReentrantLock lock;

	public Book(int id) {
		this.id = id;
		this.lock = new ReentrantLock();
	}

	public void read(Student student) {
		try {
			if (lock.tryLock(1, TimeUnit.SECONDS)) {
				System.out.println(student + " starts reading " + this);
				Thread.sleep(4000);
			} else {
				System.out.println(student + "Book bussy,cannot read " + this);
				// Exit early if lock not acquired
				return;
			}
		} catch (InterruptedException e) {
			Thread.currentThread().interrupt(); // Preserve interrupt status
			e.printStackTrace();
		} finally {
			// Only unlock if the thread acquired the lock
			if (lock.isHeldByCurrentThread()) {
				lock.unlock();
				System.out.println(student + " has finished reading " + this);
			}
		}

	}

	@Override
	public String toString() {
		return "Book # " + id;
	}
}
