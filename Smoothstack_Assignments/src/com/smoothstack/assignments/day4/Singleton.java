/**
 * 
 */
package com.smoothstack.assignments.day4;

/**
 * @author Brent Yurek
 *
 */
public class Singleton {
	volatile public static Singleton instance;
	
	private Singleton() {}
	
	public static Singleton getInstance() {
		if (instance == null) {
			synchronized(Singleton.class) {
				if (instance == null) {
					instance = new Singleton();
				}
			}
		}
		return instance;
	}
}
