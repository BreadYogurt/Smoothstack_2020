/**
 * 
 */
package com.smoothstack.lms.cli.adminchoices;

import java.sql.SQLException;

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
			System.out.println("The current due date for this book is " + loan.getDueDate());
			
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
