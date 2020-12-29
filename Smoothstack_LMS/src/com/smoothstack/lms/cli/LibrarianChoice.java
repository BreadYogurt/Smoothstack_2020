/**
 * 
 */
package com.smoothstack.lms.cli;

import com.smoothstack.lms.cli.utils.Choice;

/**
 * @author Brent Yurek
 *
 */
public class LibrarianChoice extends Choice {

	@Override
	public void run() {
		System.out.println("This is where librarian stuff should go.");
	}

	@Override
	public String getName() {
		return "Librarian";
	}
}
