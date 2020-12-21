/**
 * 
 */
package com.smoothstack.assignments.week1;

import org.junit.Test;
import static org.junit.Assert.assertEquals;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * @author Brent Yurek
 *
 */
public class FunctionalTest {

	private class TestCase<T> {
		public final List<T> testCase, expResult;
		
		public TestCase(T[] testCase, T[] expResult) {
			this.testCase = Arrays.asList(testCase);
			this.expResult = Arrays.asList(expResult);
		}
	}
	
	@Test
	public void rightDigitTest() {
		List<TestCase<Integer>> tests = new ArrayList<>();
		tests.add(new TestCase<>(new Integer[] {1, 22, 93}, new Integer[] {1, 2, 3}));
		tests.add(new TestCase<>(new Integer[] {16, 8, 886, 8, 1}, new Integer[] {6, 8, 6, 8, 1}));
		tests.add(new TestCase<>(new Integer[] {10, 0}, new Integer[] {0, 0}));
		
		tests.forEach(t -> assertEquals(t.expResult, Functional.rightDigit(t.testCase)));
	}
	
	@Test
	public void doublingTest() {
		List<TestCase<Integer>> tests = new ArrayList<>();
		tests.add(new TestCase<>(new Integer[] {1, 2, 3}, new Integer[] {2, 4, 6}));
		tests.add(new TestCase<>(new Integer[] {6, 8, 6, 8, -1}, new Integer[] {12, 16, 12, 16, -2}));
		tests.add(new TestCase<>(new Integer[] {}, new Integer[] {}));
		
		tests.forEach(t -> assertEquals(t.expResult, Functional.doubling(t.testCase)));
	}
	
	@Test
	public void noXTest() {
		List<TestCase<String>> tests= new ArrayList<>();
		tests.add(new TestCase<>(new String[] {"ax", "bb", "cx"}, new String[] {"a", "bb", "c"}));
		tests.add(new TestCase<>(new String[] {"xxax", "xbxbx", "xxcx"}, new String[] {"a", "bb", "c"}));
		tests.add(new TestCase<>(new String[] {"x"}, new String[] {""}));
		
		tests.forEach(t -> assertEquals(t.expResult, Functional.noX(t.testCase)));
	}
}
