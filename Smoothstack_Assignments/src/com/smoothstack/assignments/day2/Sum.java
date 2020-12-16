/**
 * 
 */
package com.smoothstack.assignments.day2;

/**
 * @author Brent Yurek
 *
 * Takes numbers as command line arguments and finds the sum of all of them.
 */
public class Sum {
	public static void main(String[] args) {
		int sum = 0;
		for (String arg : args) {
			sum += Integer.parseInt(arg);
		}
		System.out.println(sum);
	}
}
