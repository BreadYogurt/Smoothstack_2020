/**
 * 
 */
package com.smoothstack.lms.beans;

/**
 * @author Brent Yurek
 *
 */
public class Author extends Bean {
	private int id;
	private String name;
	
	public Author(int id, String name) {
		super();
		this.id = id;
		this.name = name;
	}
	public Author() {
		super();
	}

	@Override
	public String toString() {
		return name;
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
		Author other = (Author) obj;
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
	
	public void printDetails() {
		System.out.println("Author ID: " + id);
		System.out.println("Author Name: " + name);
	}
}
