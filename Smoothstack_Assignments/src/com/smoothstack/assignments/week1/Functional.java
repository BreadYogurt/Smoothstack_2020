/**
 * 
 */
package com.smoothstack.assignments.week1;

import java.util.List;
import java.util.stream.Collectors;

/**
 * @author Brent Yurek
 *
 */
public class Functional {
	public static List<Integer> rightDigit(List<Integer> ints) {
		return ints.stream().map(i -> i % 10).collect(Collectors.toList());
	}
	
	public static List<Integer> doubling(List<Integer> ints) {
		return ints.stream().map(i -> i * 2).collect(Collectors.toList());
	}
	
	public static List<String> noX(List<String> strs) {
		return strs.stream().map(s -> s.replace("x", "")).collect(Collectors.toList());
	}
}
