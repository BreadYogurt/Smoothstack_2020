/**
 * 
 */
package com.smoothstack.lms.cli;

import java.util.ArrayList;
import java.util.List;

import com.smoothstack.lms.cli.adminchoices.*;
import com.smoothstack.lms.cli.utils.Choice;
import com.smoothstack.lms.cli.utils.QuitException;
import com.smoothstack.lms.cli.utils.Utils;
import com.smoothstack.lms.daos.AuthorDAO;
import com.smoothstack.lms.daos.BookDAO;
import com.smoothstack.lms.daos.BorrowerDAO;
import com.smoothstack.lms.daos.BranchDAO;
import com.smoothstack.lms.daos.PublisherDAO;

/**
 * @author Brent Yurek
 *
 */
public class AdministratorChoice extends Choice {

	@Override
	public void run() {
		List<Choice> choices = new ArrayList<>();
		choices.add(new BookAdminChoice(new BookDAO()));
		choices.add(new AuthorAdminChoice(new AuthorDAO()));
		choices.add(new PublisherAdminChoice(new PublisherDAO()));
		choices.add(new BranchAdminChoice(new BranchDAO()));
		choices.add(new BorrowerAdminChoice(new BorrowerDAO()));
		
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
		return "Administrator";
	}

}
