/**
 * 
 */
package com.smoothstack.assignments.day2;

/**
 * @author Brent Yurek
 *
 */
public class Rectangle implements Shape {

	private int length, width;
	
	public Rectangle(int length, int width) {
		this.length = length;
		this.width = width;
	}
	
	@Override
	public double calculateArea() {
		return this.length * this.width;
	}

	@Override
	public void display() {
		if (this.length > 0) {
			for (int i = 0; i < this.width; i++) {
				System.out.print("[]");
			}
			System.out.println();
		}
		for (int i = 2; i < this.length; i++) {
			System.out.print("[]");
			for (int j = 2; j < this.width; j++) {
				System.out.print("  ");
			}
			if (this.width > 1) {
				System.out.print("[]");
			}
			System.out.println();
		}
		if (this.length > 1) {
			for (int i = 0; i < this.width; i++) {
				System.out.print("[]");
			}
			System.out.println();
		}
	}

}
