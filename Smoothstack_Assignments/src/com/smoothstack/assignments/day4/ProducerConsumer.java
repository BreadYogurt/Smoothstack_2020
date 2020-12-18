/**
 * 
 */
package com.smoothstack.assignments.day4;

import java.util.LinkedList;

/**
 * @author Brent Yurek
 *
 */
public class ProducerConsumer {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		LinkedList<Integer> buffer = new LinkedList<>();
		
		Runnable producer = new Runnable() {

			@Override
			public void run() {
				int i = 0;
				while(true) {
					synchronized (buffer) {
						buffer.add(++i);
					}
					System.out.println("Produced " + i);
				}
			}
			
		};
		
		Runnable consumer = new Runnable() {

			@Override
			public void run() {
				while(true) {
					Integer i = null;
					synchronized (buffer) {
						if (!buffer.isEmpty()) {
							i = buffer.removeFirst();
						}
					}
					if (i != null) {
						System.out.println("Consumed " + i);
					}
				}
			}
			
		};
		
		new Thread(producer).start();
		new Thread(consumer).start();
	}

}
