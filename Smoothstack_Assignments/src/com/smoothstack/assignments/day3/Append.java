/**
 * 
 */
package com.smoothstack.assignments.day3;

import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;

/**
 * @author Brent Yurek
 *
 * Appends text to a file.
 */
public class Append {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		try (Scanner input = new Scanner(System.in)) {
			System.out.print("File to write to: ");
			String dir = input.nextLine();
			
			try (FileWriter file = new FileWriter(dir, true)) {
				System.out.print("Message to append: ");
				String message = input.nextLine();
				file.append(message);
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
	}

}
