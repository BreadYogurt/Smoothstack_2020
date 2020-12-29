/**
 * 
 */
package com.smoothstack.lms.cli.adminchoices;

import java.sql.SQLException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

import com.smoothstack.lms.beans.Borrower;
import com.smoothstack.lms.beans.Branch;
import com.smoothstack.lms.beans.Loan;
import com.smoothstack.lms.cli.utils.Choice;
import com.smoothstack.lms.cli.utils.QuitException;
import com.smoothstack.lms.cli.utils.Utils;
import com.smoothstack.lms.daos.BorrowerDAO;
import com.smoothstack.lms.daos.BranchDAO;
import com.smoothstack.lms.daos.LoanDAO;

/**
 * @author Brent Yurek
 *
 */
public class DueDateAdminChoice extends Choice {

	@Override
	public void run() {
		try {
			BorrowerDAO borrowerDao = new BorrowerDAO();
			System.out.println("Select a borrower to override a due date of.");
			Borrower borrower = Utils.createMenu(borrowerDao.getAll(), "Quit to cancel operation");
			
			BranchDAO branchDao = new BranchDAO();
			System.out.println("Select a library branch.");
			Branch branch = Utils.createMenu(branchDao.getAll(), "Quit to cancel operation");
			
			LoanDAO loanDao = new LoanDAO();
			System.out.println("Select a book to override the due date of.");
			Loan loan = Utils.createMenu(loanDao.getByBorrowerAndBranch(borrower, branch), "Quit to cancel operation");
			
			Utils.printQuitNote();
			SimpleDateFormat df = new SimpleDateFormat("MM-dd-yyyy");
			System.out.println("The current due date for this book is " + df.format(loan.getDueDate()));
			Date newDueDate = null;
			while (newDueDate == null) {
				String dateInput = Utils.stringPrompt("Please enter a new due date (MM-DD-YYYY)", true);
				try {
					newDueDate = df.parse(dateInput);
				} catch (ParseException e) {
					newDueDate = null;
					System.out.println("Please enter a date in the valid format (MM-DD-YYYY).");
				}
			}
			loan.setDueDate(newDueDate);
			loanDao.update(loan);
		} catch (QuitException e) {
		} catch (ClassNotFoundException | SQLException e) {
			e.printStackTrace();
		}
	}

	@Override
	public String getName() {
		return "Override Due Date for a Book Loan";
	}

}
