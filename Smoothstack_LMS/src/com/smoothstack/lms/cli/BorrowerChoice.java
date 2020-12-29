/**
 * 
 */
package com.smoothstack.lms.cli;

import com.smoothstack.lms.cli.utils.Choice;

/**
 * @author Brent Yurek
 *
 */
public class BorrowerChoice extends Choice {

	@Override
	public void run() {
		System.out.println("This is where borrower stuff will go.");
	}

	@Override
	public String getName() {
		return "Borrower";
	}

}
