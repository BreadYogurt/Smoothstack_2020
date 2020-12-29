/**
 * 
 */
package com.smoothstack.lms.cli.adminchoices;

import java.sql.SQLException;

import com.smoothstack.lms.beans.Book;
import com.smoothstack.lms.cli.utils.QuitException;
import com.smoothstack.lms.cli.utils.Utils;
import com.smoothstack.lms.daos.AuthorDAO;
import com.smoothstack.lms.daos.BaseDAO;
import com.smoothstack.lms.daos.PublisherDAO;

/**
 * @author Brent Yurek
 *
 */
public class BookAdminChoice extends AdminChoice<Book> {

	public BookAdminChoice(BaseDAO<Book> dao) {
		super(dao);
	}

	@Override
	String getObjectPlural() {
		return "Books";
	}

	@Override
	String getObjectSingular() {
		return "Book";
	}

	@Override
	Book creationPrompt() throws QuitException {	
		try {
			Utils.printQuitNote();
			Book book = new Book();
			book.setTitle(Utils.stringPrompt("Please enter book title", true));
			
			AuthorDAO authorDao = new AuthorDAO();
			System.out.println("Please select the author of this book.");
			book.setAuthor(Utils.createMenu(authorDao.getAll(), "Quit to cancel operation", "No Author"));
			
			PublisherDAO publisherDao = new PublisherDAO();
			System.out.println("Please select the publisher of this book.");
			book.setPublisher(Utils.createMenu(publisherDao.getAll(), "Quit to cancel operation", "No Publisher"));
			
			return book;
		} catch (ClassNotFoundException | SQLException e) {
			e.printStackTrace();
			throw new QuitException();
		}
	}

	@Override
	Book updatePrompt(Book book) throws QuitException {
		try {
			Utils.printQuitNote();
			String bookTitle = Utils.stringPrompt("Please enter new book title or N/A for no change", true);
			if (!"N/A".equals(bookTitle)) {
				book.setTitle(bookTitle);
			}
		
			AuthorDAO authorDao = new AuthorDAO();
			System.out.println("Please select the new author of this book.");
			book.setAuthor(Utils.createMenu(authorDao.getAll(), "Quit to cancel operation", "No Author", book.getAuthor()));
			
			PublisherDAO publisherDao = new PublisherDAO();
			System.out.println("Please select the new publisher of this book.");
			book.setPublisher(Utils.createMenu(publisherDao.getAll(), "Quit to cancel operation", "No Publisher", book.getPublisher()));
			
			return book;
		} catch (ClassNotFoundException | SQLException e) {
			e.printStackTrace();
			throw new QuitException();
		}
	}
	
}
