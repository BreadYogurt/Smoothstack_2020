/**
 * 
 */
package com.smoothstack.assignments.week1;

/**
 * @author Brent Yurek
 *
 */
public class Lambdas {
	public static PerformOperation isOdd = num -> (num % 2 == 1);
	
	public static PerformOperation isPrime = num -> {
		int stopPoint = num / 2;
		for (int i = 2; i < stopPoint; i++) {
			if (num % i == 0) {
				return false;
			}
		}
		return true;
	};
	
	public static PerformOperation isPalindrome = num -> {
		char[] numArr = num.toString().toCharArray();
		for (int start = 0, end = numArr.length - 1; start < end; start++, end--) {
			if (numArr[start] != numArr[end]) {
				return false;
			}
		}
		return true;
	};
}

@FunctionalInterface
interface PerformOperation {
	public boolean performOperation(Integer num);
}