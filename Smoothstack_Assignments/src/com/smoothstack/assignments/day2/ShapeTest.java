/**
 * 
 */
package com.smoothstack.assignments.day2;

/**
 * @author Brent Yurek
 *
 *	For testing the Shape interface and its implementations.
 */
public class ShapeTest {

	public static void main(String[] args) {
		Shape rect = new Rectangle(4, 6);
		System.out.println(rect.calculateArea());
		rect.display();
		
		Shape tri = new Triangle(5, 3);
		System.out.println(tri.calculateArea());
		tri.display();
		
		Shape circ = new Circle(5);
		System.out.println(circ.calculateArea());
		circ.display();
	}

}
