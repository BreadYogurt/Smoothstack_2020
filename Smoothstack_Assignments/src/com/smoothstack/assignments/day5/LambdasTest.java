/**
 * 
 */
package com.smoothstack.assignments.day5;

import org.junit.Test;
import static org.junit.Assert.assertEquals;

import java.util.Arrays;
import java.util.List;
/**
 * @author Brent Yurek
 *
 */
public class LambdasTest {
	@Test
	public void stringifyIntsTest() {
		List<Integer> i1 = Arrays.asList(3, 44);
		assertEquals(Lambdas.stringifyInts(i1), "o3,e44");
	}
	
	@Test
	public void listAll3LetterWordsStartingWithATest() {
		List<String> s1 = Arrays.asList("all", "any", "ambiguous", "fatigue", "sat", "sit");
		assertEquals(Lambdas.listAll3LetterWordsStartingWithA(s1), Arrays.asList("all", "any"));
	}
}
