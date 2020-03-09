package com.udemyCollectionConcurrency;

import java.util.concurrent.Delayed;
import java.util.concurrent.TimeUnit;

public class DelayedElement implements Delayed {

	private String data;
	private Long startTime; // This is a time when the element should be consumed from the queue.

	public DelayedElement(String data, Long startTime) {
		this.data = data;
		this.startTime = startTime;
	}

	@Override
	public int compareTo(Delayed o) {
		return Long.compare(((DelayedElement) o).startTime, this.startTime);
	}

	// It should return the remaining delay associated with this object in the given
	// time unit
	/*
	 * When the consumer tries to take an element from the queue, the DelayQueue
	 * will execute getDelay() to find out if that element is allowed to be returned
	 * from the queue. If the getDelay() method will return zero or a negative
	 * number, it means that it could be retrieved from the queue.
	 */
	@Override
	public long getDelay(TimeUnit unit) {
		long diff = startTime - System.currentTimeMillis();
		long convert = unit.convert(diff, TimeUnit.MILLISECONDS);
		return convert;
	}

}
