/**
 * 
 */
package com.smoothstack.assignments.week1;

/**
 * @author Brent Yurek
 *
 */
public class Recursion {
	public static boolean groupSumClump(int place, int[] ints, int target) {
		int nextValue = 0;
		int nextPlace = place;
		while ((nextPlace < ints.length) && (ints[nextPlace] == ints[place])) {
			nextValue += ints[nextPlace++];
		}
		
		if (nextValue == target) {
			return true;
		} else if ((nextValue > target) || (nextPlace >= ints.length)) {
			return false;
		} else {
			return (groupSumClump(nextPlace, ints, target - nextValue) || groupSumClump(nextPlace, ints, target));
		}
	}
}
