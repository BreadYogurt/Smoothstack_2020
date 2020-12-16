/**
 * 
 */
package com.smoothstack.assignments.day2;

/**
 * @author Brent Yurek
 *
 */
public class Triangle implements Shape {
	private int base, height;
	
	public Triangle(int base, int height) {
		this.base = base;
		this.height = height;
	}
	
	@Override
	public double calculateArea() {
		return (double)(this.base * this.height)/2;
	}

	@Override
	public void display() {
		System.out.println("Pretend there's a triangle here with a base of " + this.base + " and height of " + this.height + " and it's very impressive.");
	}

}
