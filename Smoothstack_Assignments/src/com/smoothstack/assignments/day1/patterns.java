/**
 * 
 */
package com.smoothstack.assignments.day1;

/**
 * @author Brent Yurek
 *
 */
public class patterns {
	public static void main(String[] args) {
		int number = 1;
		int rows = 4;
		int lineLength = 9;
		
		printItemNumber(number++);
		for (int i = 1; i <= rows; i++) {
			printTriangleRow(i);
		}
		printLine(lineLength++);
		System.out.println();
		
		printItemNumber(number++);
		printLine(lineLength++);
		for (int i = rows; i > 0; i--) {
			printTriangleRow(i);
		}
		System.out.println();
		
		printItemNumber(number++);
		for (int i = 0; i < rows; i++) {
			printPyramidRow(rows, i);
		}
		printLine(lineLength++);
		System.out.println();
		
		printItemNumber(number++);
		printLine(lineLength++);
		for (int i = rows - 1; i >= 0; i--) {
			printPyramidRow(rows, i);
		}
		System.out.println();
	}
	
	private static void printItemNumber(int number) {
		System.out.println(number + ")");
	}
	
	private static void printLine(int length) {
		for (int i = 0; i < length; i++) {
			System.out.print("-");
		}
		System.out.println();
	}
	
	private static void printTriangleRow(int length) {
		for (int i = 0; i < length; i++) {
			System.out.print("*");
		}
		System.out.println();
	}
	
	private static void printPyramidRow(int base, int length) {
		System.out.print("  ");
		int whitespace = base - length - 1;
		for (int i = 0; i < whitespace; i++) {
			System.out.print(" ");
		}
		for (int i = 0; i < length; i++) {
			System.out.print("*");
		}
		System.out.print("*");
		for (int i = 0; i < length; i++) {
			System.out.print("*");
		}
		System.out.println();
	}
}
