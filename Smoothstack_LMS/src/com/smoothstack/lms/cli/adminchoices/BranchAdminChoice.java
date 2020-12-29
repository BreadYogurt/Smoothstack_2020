/**
 * 
 */
package com.smoothstack.lms.cli.adminchoices;

import com.smoothstack.lms.beans.Branch;
import com.smoothstack.lms.cli.utils.QuitException;
import com.smoothstack.lms.cli.utils.Utils;
import com.smoothstack.lms.daos.BaseDAO;

/**
 * @author Brent Yurek
 *
 */
public class BranchAdminChoice extends AdminChoice<Branch> {

	public BranchAdminChoice(BaseDAO<Branch> dao) {
		super(dao);
	}

	@Override
	String getObjectPlural() {
		return "Library Branches";
	}

	@Override
	String getObjectSingular() {
		return "Library Branch";
	}

	@Override
	Branch creationPrompt() throws QuitException {
		Utils.printQuitNote();
		Branch branch = new Branch();
		branch.setName(Utils.stringPrompt("Please enter branch name"));
		branch.setAddress(Utils.stringPrompt("Please enter branch address"));
		return branch;
	}

	@Override
	Branch updatePrompt(Branch branch) throws QuitException {
		Utils.printQuitNote();
		String branchName = Utils.stringPrompt("Please enter new branch name or enter N/A for no change");
		if (!"N/A".equals(branchName)) {
			branch.setName(branchName);
		}
		
		String branchAddress = Utils.stringPrompt("Please enter new branch name or enter N/A for no change");
		if (!"N/A".equals(branchAddress)) {
			branch.setAddress(branchAddress);
		}
		
		return branch;
	}

}
