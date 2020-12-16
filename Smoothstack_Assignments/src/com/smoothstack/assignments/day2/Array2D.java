/**
 * 
 */
package com.smoothstack.assignments.day2;

import java.util.Random;

/**
 * @author Brent Yurek
 *
 * Constructs a 2D array and finds the max number and shows its position in the array
 */
public class Array2D {
	public static void main(String[] args) {
		int size = 5;
		int rMax = 100;
		int rMin = 1;
		
		Random rand = new Random();
		int[][] grid = new int[size][size];
		int max = rMin - 1;
		int maxRow = -1;
		int maxCol = -1;
		for (int i = 0; i < size; i++) {
			for (int j = 0; j < size; j++) {
				grid[i][j] = rand.nextInt((rMax - rMin) + 1) + rMin;
				System.out.print(grid[i][j] + " ");
				if (grid[i][j] > max) {
					max = grid[i][j];
					maxRow = i;
					maxCol = j;
				}
			}
			System.out.println();
		}
		
		System.out.println("Max number is " + max + " at (" + maxCol + ", " + maxRow + ").");
	}
}
