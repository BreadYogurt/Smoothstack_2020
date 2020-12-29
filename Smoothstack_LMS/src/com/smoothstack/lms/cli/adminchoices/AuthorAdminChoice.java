/**
 * 
 */
package com.smoothstack.lms.cli.adminchoices;

import com.smoothstack.lms.beans.Author;
import com.smoothstack.lms.cli.utils.QuitException;
import com.smoothstack.lms.cli.utils.Utils;
import com.smoothstack.lms.daos.BaseDAO;

/**
 * @author Brent Yurek
 *
 */
public class AuthorAdminChoice extends AdminChoice<Author> {

	public AuthorAdminChoice(BaseDAO<Author> dao) {
		super(dao);
	}

	@Override
	String getObjectPlural() {
		return "Authors";
	}

	@Override
	String getObjectSingular() {
		return "Author";
	}

	@Override
	Author creationPrompt() throws QuitException {
		Utils.printQuitNote();
		Author author = new Author();
		author.setName(Utils.stringPrompt("Please enter author name", true));
		return author;
	}

	@Override
	Author updatePrompt(Author author) throws QuitException {
		Utils.printQuitNote();
		String authorName = Utils.stringPrompt("Please enter new author name or enter N/A for no change", true);
		if (!"N/A".equals(authorName)) {
			author.setName(authorName);
		}
		return author;
	}
	
}
