/**
 * 
 */
package com.smoothstack.assignments.day5;

import java.util.Arrays;

/**
 * @author Brent Yurek
 *
 */
public class LambdasSort {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		String[] stuff = {"things", "are", "more", "like", "they", "are", "now", "than", "they", "have", "ever", "been", "before"};
		System.out.println("ORIGINAL");
		printArray(stuff);
		
		//Sort by length
		Arrays.sort(stuff, (s1, s2) -> s1.length() - s2.length());
		System.out.println("LENGTH");
		printArray(stuff);
		
		//Sort by reverse length
		Arrays.sort(stuff, (s1, s2) -> s2.length() - s1.length());
		System.out.println("REVERSE LENGTH");
		printArray(stuff);
		
		//Sort by strings containing 'e' first
		Arrays.sort(stuff, (a1, a2) -> {
			String s1 = (String) a1;
			String s2 = (String) a2;
			if (s1.contains("e") && s2.contains("e")) {
				return 0;
			} else if (s1.contains("e")) {
				return -1;
			} else if (s2.contains("e")) {
				return 1;
			}
			return 0;
		});
		System.out.println("E FIRST");
		printArray(stuff);
		
		String[] words = {"things", "are", "more", "like", "they", "are", "now", "than", "they", "have", "ever", "been", "before"};
		System.out.println("ORIGINAL");
		printArray(words);
		
		//Sort by length
		Arrays.sort(words, (s1, s2) -> Utils.lengthCompare(s1, s2));
		System.out.println("LENGTH");
		printArray(words);
		
		//Sort by reverse length
		Arrays.sort(words, (s1, s2) -> Utils.reverseLengthCompare(s1, s2));
		System.out.println("REVERSE LENGTH");
		printArray(words);
		
		//Sort by strings containing 'e' first
		Arrays.sort(words, (s1, s2) -> Utils.containsECompare(s1, s2));
		System.out.println("E FIRST");
		printArray(words);
	}

	public static void printArray(String[] stuff) {
		for(String s : stuff) {
			System.out.println(s);
		}
		System.out.println();
	}

}

class Utils {
	public static int lengthCompare(String s1, String s2) {
		return s1.length() - s2.length();
	}
	
	public static int reverseLengthCompare(String s1, String s2) {
		return s2.length() - s1.length();
	}
	
	public static int containsECompare(String s1, String s2) {
		if (s1.contains("e") && s2.contains("e")) {
			return 0;
		} else if (s1.contains("e")) {
			return -1;
		} else if (s2.contains("e")) {
			return 1;
		}
		return 0;
	}
}
