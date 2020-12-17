/**
 * 
 */
package com.smoothstack.assignments.day3;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.Scanner;

/**
 * @author Brent Yurek
 * 
 * Counts the times a character appears in a file.
 */
public class CharCount {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		char character = 0;
		String filename;
		int count = 0;
		try (Scanner input = new Scanner(System.in)) {
			if (args.length > 0) {
				character = args[0].toCharArray()[0];
			} else {
				System.out.print("Character to count: ");
				character = input.nextLine().toCharArray()[0];
			}
			
			System.out.print("File to read: ");
			filename = input.nextLine();
		}
		
		try (BufferedReader file = new BufferedReader(new FileReader(filename))) {
			int c;
			while ((c = file.read()) != -1) {
				if ((char) c == character) {
					count++;
				}
			}
			System.out.println("The character '" + character + "' has been counted in the file '" + filename + "' " + count + " times.");
		} catch (FileNotFoundException e) {
			System.out.println("File '" + filename + "' not found.");
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

}
