package com.udermy.DinnerPhilosopher;

import java.util.concurrent.TimeUnit;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class Chopsitick {

	private int id;
	private ReentrantLock lock;

	public Chopsitick(int id) {
		this.id = id;
		this.lock = new ReentrantLock();
	}

	// checks if a philosopher is able to pick up the chopstick
	public boolean canPickUp(Philosopher philosopher, State state) throws InterruptedException {
		// able to wait for a lock acquire for a time interval
		if (lock.tryLock(10, TimeUnit.MILLISECONDS)) {
			System.out.println(philosopher + " picked up " + state.getDisplayString(state) + id);
			return true;
		}

		return false;
	}

	// we unlock the lock on
	public void putUp(Philosopher philosopher, State state) throws InterruptedException {
		lock.unlock();
		System.out.println(philosopher + " put down " + state.getDisplayString(state) + id);
	}
}
