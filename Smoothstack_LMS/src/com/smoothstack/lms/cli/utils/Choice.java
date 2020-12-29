/**
 * 
 */
package com.smoothstack.lms.cli.utils;

/**
 * @author Brent Yurek
 * 
 * This is an abstract class for implementing choices when used with the createMenu method in Utils
 */
public abstract class Choice {
	public abstract void run();
	public abstract String getName();
	
	public String toString() {
		return getName();
	}
}
