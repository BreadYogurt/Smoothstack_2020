/**
 * 
 */
package com.smoothstack.assignments.day4;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertThrows;
import static org.junit.Assert.assertTrue;

import org.junit.Test;
import org.junit.function.ThrowingRunnable;

/**
 * @author Brent Yurek
 *
 */
public class LineTest {
	@Test
	public void getSlopeTest() {
		Line lineSloped = new Line(0, 0, 1, 1);
		assertEquals(lineSloped.getSlope(), 1, .0001);
		Line lineFlat = new Line(0, 0, 0, 1);
		assertThrows(ArithmeticException.class, new ThrowingRunnable() {
			@Override
			public void run() throws Throwable {
				lineFlat.getSlope();
			}
		});
	}
	
	@Test
	public void getDistanceTest() {
		Line line1 = new Line(0, 0, 0, 1);
		assertEquals(line1.getDistance(), 1, .0001);
	}
	
	@Test
	public void parallelToTest() {
		Line line1 = new Line(0, 0, 1, 1);
		Line line2 = new Line(1, 1, 2, 2);
		assertTrue(line1.parallelTo(line2));
		assertTrue(line2.parallelTo(line1));
		Line line3 = new Line(2, 2, 0, 0);
		assertFalse(line1.parallelTo(line3));
		assertFalse(line3.parallelTo(line1));
		assertFalse(line2.parallelTo(line3));
		assertFalse(line3.parallelTo(line2));
	}
}
