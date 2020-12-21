/**
 * 
 */
package com.smoothstack.assignments.week1;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

import org.junit.Test;

/**
 * @author Brent Yurek
 *
 */
public class LambdasTest {

	@Test
	public void isOddTest() {
		assertFalse(Lambdas.isOdd.performOperation(4));
		assertTrue(Lambdas.isOdd.performOperation(3));
	}
	
	@Test
	public void isPrimeTest() {
		assertTrue(Lambdas.isPrime.performOperation(5));
		assertFalse(Lambdas.isPrime.performOperation(12));
	}
	
	@Test
	public void isPalindromeTest() {
		assertTrue(Lambdas.isPalindrome.performOperation(898));
		assertFalse(Lambdas.isPalindrome.performOperation(899));
	}
}
