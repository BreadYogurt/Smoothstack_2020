/**
 * 
 */
package com.smoothstack.lms.beans;

/**
 * @author Brent Yurek
 *
 */
public class Publisher extends Bean{
	private int id;
	private String name, address, phone;
	
	public Publisher(int id, String name, String address, String phone) {
		super();
		this.id = id;
		this.name = name;
		this.address = address;
		this.phone = phone;
	}
	public Publisher() {
		super();
	}
	
	@Override
	public String toString() {
		if (name != null) {
			return name;
		} else {
			return "Unknown Publisher";
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
		Publisher other = (Publisher) obj;
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
	/**
	 * @return the phone
	 */
	public String getPhone() {
		return phone;
	}
	/**
	 * @param phone the phone to set
	 */
	public void setPhone(String phone) {
		this.phone = phone;
	}
	@Override
	public void printDetails() {
		System.out.println("Publisher ID: " + id);
		System.out.println("Publisher Name: " + name);
		if (address != null) {
			System.out.println("Publisher Address: " + address);
		}
		if (address != null) {
			System.out.println("Publisher Phone Number: " + phone);
		}
	}
}
