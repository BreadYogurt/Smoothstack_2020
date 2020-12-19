/**
 * 
 */
package com.smoothstack.assignments.day5;

import java.time.DayOfWeek;
import java.time.LocalDate;
import java.time.Year;
import java.time.YearMonth;
import java.util.Scanner;

/**
 * @author Brent Yurek
 *
 */
public class DateTime6 {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		int monthInt;
		try (Scanner input = new Scanner(System.in)){
			System.out.print("Enter a month (1-12): ");
			monthInt = input.nextInt();
		}
		
		YearMonth m = Year.now().atMonth(monthInt);
		int day = 1;
		int length = m.lengthOfMonth();
		System.out.println("Mondays that month:");
		while (day <= length) {
			LocalDate date = m.atDay(day);
			if (date.getDayOfWeek() == DayOfWeek.MONDAY) {
				System.out.println(date);
				day += 7;
			} else {
				day += 1;
			}
		}
	}

}
