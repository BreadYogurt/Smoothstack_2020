/**
 * 
 */
package com.smoothstack.assignments.day5;

import java.time.Month;
import java.time.Year;
import java.util.Scanner;

/**
 * @author Brent Yurek
 *
 */
public class DateTime5 {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		int yearInt;
		try (Scanner input = new Scanner(System.in)){
			System.out.print("Enter a year: ");
			yearInt = input.nextInt();
		}
		Year year = Year.of(yearInt);
		for (Month m : Month.values()) {
			System.out.println(m + ": " + year.atMonth(m).lengthOfMonth() + " days");
		}
	}

}
