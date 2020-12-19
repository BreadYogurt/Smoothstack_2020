/**
 * 
 */
package com.smoothstack.assignments.day5;

import java.time.DayOfWeek;
import java.time.LocalDate;
import java.util.Scanner;

/**
 * @author Brent Yurek
 *
 */
public class DateTime7 {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		String dateStr;
		try (Scanner input = new Scanner(System.in)){
			System.out.print("Type a date (YYYY-MM-DD): ");
			dateStr = input.next();
		}
		
		LocalDate date = LocalDate.parse(dateStr);
		
		if ((date.getDayOfMonth() == 13) && (date.getDayOfWeek() == DayOfWeek.FRIDAY)) {
			System.out.println("Oh no, that date is Friday the 13th!");
		} else {
			System.out.println("Good news! That date is not Friday the 13th!");
		}
	}

}
