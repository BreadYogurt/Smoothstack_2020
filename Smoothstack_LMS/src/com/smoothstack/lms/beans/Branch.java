/**
 * 
 */
package com.smoothstack.lms.beans;

/**
 * @author Brent Yurek
 *
 */
public class Branch {
	public Branch(int id, String name, String address) {
		super();
		this.id = id;
		this.name = name;
		this.address = address;
	}
	public Branch() {
		super();
	}
	
	private int id;
	private String name, address;
	
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getAddress() {
		return address;
	}
	public void setAddress(String address) {
		this.address = address;
	}
	
	
}
