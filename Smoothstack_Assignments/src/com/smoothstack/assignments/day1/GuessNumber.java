/**
 * 
 */
package com.smoothstack.assignments.day1;

import java.util.Scanner;

/**
 * @author Brent Yurek
 *
 */
public class GuessNumber {
	public static void main(String[] args) {
		int number = (int)(Math.random() * 100) + 1;
		int bottomThresh = number - 10;
		int topThresh = number + 10;
		int chances = 5;
		boolean guessedCorrect = false;
		
		try (Scanner input = new Scanner(System.in)) {		
			System.out.println("I'm thinking of a number between 1 and 100.");
			while (!guessedCorrect && (chances > 0)) {
				int guess;
				do {
					System.out.print("Guess: ");
					guess = input.nextInt();
					if (!inRange(guess)) {
						System.out.println("No, the number has to be between 1 and 100.");
					}
				} while (!inRange(guess));
				if (guess == number) {
					System.out.println("Spot on! The number was indeed " + number + ".");
					guessedCorrect = true;
				} else if ((guess >= bottomThresh) && (guess <= topThresh)) {
					System.out.println("Close enough! The number was " + number + ".");
					guessedCorrect = true;
				} else {
					System.out.println("Wrong!");
					chances--;
					if (chances > 0) {
						System.out.println("Try again, you have " + chances + " chances left.");
					}
				}
			}
			if (!guessedCorrect) {
				System.out.println("Sorry, the number was " + number + ".");
			}
		}
	}
	
	private static boolean inRange(int guess) {
		return ((guess >= 1) && (guess <= 100));
	}
}
