/**
 * 
 */
package com.smoothstack.lms.beans;

/**
 * @author Brent Yurek
 *
 */
public class Copies extends Bean{
	private Book book;
	private Branch branch;
	private int noOfCopies = 0;
	
	/**
	 * @param book
	 * @param branch
	 * @param noOfCopies
	 */
	public Copies(Book book, Branch branch, int noOfCopies) {
		super();
		this.book = book;
		this.branch = branch;
		this.noOfCopies = noOfCopies;
	}
	/**
	 * 
	 */
	public Copies() {
		super();
	}
	
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((book == null) ? 0 : book.hashCode());
		result = prime * result + ((branch == null) ? 0 : branch.hashCode());
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
		Copies other = (Copies) obj;
		if (book == null) {
			if (other.book != null)
				return false;
		} else if (!book.equals(other.book))
			return false;
		if (branch == null) {
			if (other.branch != null)
				return false;
		} else if (!branch.equals(other.branch))
			return false;
		return true;
	}
	
	/**
	 * @return the book
	 */
	public Book getBook() {
		return book;
	}
	/**
	 * @param book the book to set
	 */
	public void setBook(Book book) {
		this.book = book;
	}
	/**
	 * @return the branch
	 */
	public Branch getBranch() {
		return branch;
	}
	/**
	 * @param branch the branch to set
	 */
	public void setBranch(Branch branch) {
		this.branch = branch;
	}
	/**
	 * @return the noOfCopies
	 */
	public int getNoOfCopies() {
		return noOfCopies;
	}
	/**
	 * @param noOfCopies the noOfCopies to set
	 */
	public void setNoOfCopies(int noOfCopies) {
		this.noOfCopies = noOfCopies;
	}
	
	@Override
	public void printDetails() {
		book.printDetails();
		branch.printDetails();
		System.out.println("Number of copies: " + noOfCopies);
	}
	
}
