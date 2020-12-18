/**
 * 
 */
package com.smoothstack.assignments.day4;

import static org.junit.Assert.assertEquals;

import org.junit.Test;

/**
 * @author Brent Yurek
 *
 */
public class SingletonTest {
	@Test
	public void getInstanceTest() {
		Singleton s1 = Singleton.getInstance();
		Singleton s2 = Singleton.getInstance();
		
		assertEquals(s1, s2);
	}
}
