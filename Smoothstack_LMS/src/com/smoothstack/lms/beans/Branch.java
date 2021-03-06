/**
 * 
 */
package com.smoothstack.lms.beans;

/**
 * @author Brent Yurek
 *
 */
public class Branch extends Bean{
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
	
	@Override
	public String toString() {
		if (name != null) {
			return name + ((address != null) ? ", " + address : "");
		} else if (address != null) {
			return address;
		} else {
			return "Branch No. " + id;
		}
	}
	
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + id;
		return result;
	}
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Branch other = (Branch) obj;
		if (id != other.id)
			return false;
		return true;
	}
	
	/**
	 * @return the id
	 */
	public int getId() {
		return id;
	}
	/**
	 * @param id the id to set
	 */
	public void setId(int id) {
		this.id = id;
	}
	/**
	 * @return the name
	 */
	public String getName() {
		return name;
	}
	/**
	 * @param name the name to set
	 */
	public void setName(String name) {
		this.name = name;
	}
	/**
	 * @return the address
	 */
	public String getAddress() {
		return address;
	}
	/**
	 * @param address the address to set
	 */
	public void setAddress(String address) {
		this.address = address;
	}
	
	@Override
	public void printDetails() {
		System.out.println("Branch ID: " + id);
		if (name != null) {
			System.out.println("Branch Name: " + name);
		}
		if (address != null) {
			System.out.println("Branch Address: " + address);
		}
	}
	
}
