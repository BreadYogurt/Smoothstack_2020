/**
 * 
 */
package com.smoothstack.lms.cli;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import com.smoothstack.lms.beans.Book;
import com.smoothstack.lms.beans.Branch;
import com.smoothstack.lms.beans.Copies;
import com.smoothstack.lms.cli.utils.Choice;
import com.smoothstack.lms.cli.utils.QuitException;
import com.smoothstack.lms.cli.utils.Utils;
import com.smoothstack.lms.daos.BookDAO;
import com.smoothstack.lms.daos.BranchDAO;
import com.smoothstack.lms.daos.CopiesDAO;

/**
 * @author Brent Yurek
 *
 */
public class LibrarianChoice extends Choice {

	@Override
	public void run() {
		List<Choice> choices = new ArrayList<>();
		choices.add(new EnterBranchChoice());
		
		boolean quit = false;
		while (!quit) {
			try {
				Utils.createMenu(choices, "Quit to previous").run();
			} catch (QuitException e) {
				quit = true;
			}
		}
	}

	@Override
	public String getName() {
		return "Librarian";
	}
}

class EnterBranchChoice extends Choice {
	BranchDAO branchDao = new BranchDAO();
	Branch branch;
	
	@Override
	public void run() {
		boolean quit = false;
		while (!quit) {
			try {
				branch = Utils.createMenu(branchDao.getAll(), "Quit to previous");
				branchManagement();
			} catch (QuitException e) {
				quit = true;
			} catch (ClassNotFoundException | SQLException e) {
				e.printStackTrace();
			}
		}
	}

	@Override
	public String getName() {
		return "Enter Branch you manage";
	}
	
	private void branchManagement() {
		List<Choice> choices = new ArrayList<>();
		choices.add(new UpdateBranchChoice());
		choices.add(new AddBooksChoice());
		
		boolean quit = false;
		while (!quit) {
			try {
				Utils.createMenu(choices, "Quit to previous").run();
			} catch (QuitException e) {
				quit = true;
			}
		}
	}
	
	private class UpdateBranchChoice extends Choice {

		@Override
		public void run() {
			try {
				System.out.println("You have chosen to update the Branch with Branch Id: " + branch.getId() + " and Branch Name: " + branch.getName() + ".");
				Utils.printQuitNote();
				String branchName = Utils.stringPrompt("Please enter new branch name or enter N/A for no change");
				if (!"N/A".equals(branchName)) {
					branch.setName(branchName);
				}
				
				String branchAddress = Utils.stringPrompt("Please enter new branch name or enter N/A for no change");
				if (!"N/A".equals(branchAddress)) {
					branch.setAddress(branchAddress);
				}
				
				try {
					branchDao.update(branch);
				} catch (ClassNotFoundException | SQLException e) {
					e.printStackTrace();
				}
			} catch (QuitException e) {}
		}

		@Override
		public String getName() {
			return "Update the details of the Library";
		}
		
	}
	
	private class AddBooksChoice extends Choice {

		@Override
		public void run() {
			try {
				System.out.println("Pick the Book you want to add copies of, to your branch:");
				BookDAO bookDao = new BookDAO();
				Book book = Utils.createMenu(bookDao.getAll(), "Quit to cancel operation");
				
				CopiesDAO copiesDao = new CopiesDAO();
				boolean noEntry = false;
				Copies copies = copiesDao.getByBookAndBranch(book, branch);
				if (copies == null) {
					noEntry = true;
					copies = new Copies(book, branch, 0);
				}
				int noToAdd = -1;
				while (noToAdd < 0) {
					System.out.println("Existing number of copies: " + copies.getNoOfCopies());
					System.out.println("Enter new number of copies:");
					@SuppressWarnings("resource")
					Scanner input = new Scanner(System.in);
					noToAdd = input.nextInt();
					if (noToAdd < 0) {
						System.out.println("Number of copies must be non-negative.");
					}
				}
				
				copies.setNoOfCopies(noToAdd);
				if (noEntry) {
					copiesDao.add(copies);
				} else {
					copiesDao.update(copies);
				}
			} catch (QuitException e) {
			} catch (ClassNotFoundException | SQLException e) {
				e.printStackTrace();
			}
		}

		@Override
		public String getName() {
			return "Add copies of Book to the Branch";
		}
		
	}
}