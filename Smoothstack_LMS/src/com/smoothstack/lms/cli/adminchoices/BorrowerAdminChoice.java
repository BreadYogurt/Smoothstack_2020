/**
 * 
 */
package com.smoothstack.lms.cli.adminchoices;

import com.smoothstack.lms.beans.Borrower;
import com.smoothstack.lms.cli.utils.QuitException;
import com.smoothstack.lms.cli.utils.Utils;
import com.smoothstack.lms.daos.BaseDAO;

/**
 * @author Brent Yurek
 *
 */
public class BorrowerAdminChoice extends CRUDChoice<Borrower> {

	public BorrowerAdminChoice(BaseDAO<Borrower> dao) {
		super(dao);
	}

	@Override
	String getObjectPlural() {
		return "Borrowers";
	}

	@Override
	String getObjectSingular() {
		return "Borrower";
	}

	@Override
	Borrower creationPrompt() throws QuitException {
		Utils.printQuitNote();
		Borrower borrower = new Borrower();
		borrower.setName(Utils.stringPrompt("Please enter borrower name"));
		borrower.setAddress(Utils.stringPrompt("Please enter borrower address"));
		borrower.setPhone(Utils.stringPrompt("Please enter borrower phone number"));
		return borrower;
	}

	@Override
	Borrower updatePrompt(Borrower borrower) throws QuitException {
		Utils.printQuitNote();
		
		String borrowerName = Utils.stringPrompt("Please enter new borrower name or enter N/A for no change");
		if (!"N/A".equals(borrowerName)) {
			borrower.setName(borrowerName);
		}
		
		String borrowerAddress = Utils.stringPrompt("Please enter new borrower address or enter N/A for no change");
		if (!"N/A".equals(borrowerAddress)) {
			borrower.setAddress(borrowerAddress);
		}
		
		String borrowerPhone = Utils.stringPrompt("Please enter new borrower phone number or enter N/A for no change");
		if (!"N/A".equals(borrowerPhone)) {
			borrower.setPhone(borrowerPhone);
		}
		
		return borrower;
	}

}
