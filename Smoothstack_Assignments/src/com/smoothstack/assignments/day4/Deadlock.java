/**
 * 
 */
package com.smoothstack.assignments.day4;

import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

/**
 * @author Brent Yurek
 *
 */
public class Deadlock {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		Lock l1 = new ReentrantLock();
		Lock l2 = new ReentrantLock();
		
		Runnable t1 = new TaskThread(l1, l2, "foo");
		Runnable t2 = new TaskThread(l2, l1, "bar");
		
		new Thread(t1).start();
		new Thread(t2).start();
	}
}

class TaskThread implements Runnable {
	private Lock l1, l2;
	private String message;
	
	public TaskThread(Lock l1, Lock l2, String message) {
		super();
		this.l1 = l1;
		this.l2 = l2;
		this.message = message;
	}
	
	@Override
	public void run() {
		try {
			l1.lock();
			l2.lock();
			System.out.println(message);
		} finally {
			l2.unlock();
			l1.unlock();
		}
	}
	
}
