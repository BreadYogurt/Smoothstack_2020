/**
 * 
 */
package com.smoothstack.assignments.day5;

import java.util.List;
import java.util.stream.Collectors;

/**
 * @author Brent Yurek
 *
 */

public class Lambdas {
	public static String stringifyInts(List<Integer> ints) {
		return ints.stream()
				.map(i -> {
					if (i % 2 == 0) {
						return "e"+i;
					} else {
						return "o"+i;
					}
				}).collect(Collectors.joining(","));
	}
	
	public static List<String> listAll3LetterWordsStartingWithA(List<String> words) {
		return words.stream()
				.filter(s -> (s.startsWith("a") && (s.length() == 3)))
				.collect(Collectors.toList());
	}
}
