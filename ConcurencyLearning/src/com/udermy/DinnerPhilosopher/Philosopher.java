package com.udermy.DinnerPhilosopher;

import java.util.Random;

public class Philosopher implements Runnable{
	
	private int id;
	
	private Chopsitick left;
	
	private Chopsitick right;
	
	private Random random ; // as we want that every philosopher is eating and thinking for random time
	
	private int eatingCount;
	
	private volatile boolean isFull = false; // make sure we get this from memory for all threads 

	public Philosopher(int id, Chopsitick left, Chopsitick right) {
		this.id = id;
		this.left = left;
		this.right = right;
		this.random = new Random();
	}

	public boolean isFull() {
		return isFull;
	}

	public void setFull(boolean isFull) {
		this.isFull = isFull;
	}
	
	@Override
	public String toString() {
		return "Philosopher "+id;
	}

	@Override
	public void run() {
			try {
				while(!isFull){
				think();
				if(left.pickUp(this, State.LEFT))
				{
					if(right.pickUp(this, State.RIGHT))
					{
						eat();
						right.putUp(this, State.RIGHT);
					}
					left.putUp(this, State.LEFT);
				}
				}
			} catch (Exception e) {
				e.printStackTrace();
			}
		
	}
	
	private void think() throws InterruptedException
	{
		System.out.println(this + " is thinking...");
		Thread.sleep(random.nextInt(1000));
	}
	
	private void eat() throws InterruptedException
	{
		System.out.println(this + " is eating...");
		this.eatingCount++;
		Thread.sleep(random.nextInt(1000));
	}
	
	public int getCounter()
	{ 	
		return this.eatingCount;
	}
	

}
