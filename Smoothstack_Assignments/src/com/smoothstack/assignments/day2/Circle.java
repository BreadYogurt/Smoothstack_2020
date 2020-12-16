/**
 * 
 */
package com.smoothstack.assignments.day2;

/**
 * @author destr
 *
 */
public class Circle implements Shape {

	private int radius;
	
	public Circle(int radius) {
		this.radius = radius;
	}
	
	@Override
	public double calculateArea() {
		return 3.14 * (double)(this.radius * this.radius);
	}

	@Override
	public void display() {
		System.out.println("Pretend there's a circle here with a radius of " + this.radius + " and it's very impressive.");
	}

}
