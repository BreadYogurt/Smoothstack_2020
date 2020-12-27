/**
 * 
 */
package com.smoothstack.lms.daos;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.smoothstack.lms.beans.Author;
import com.smoothstack.lms.beans.Book;
import com.smoothstack.lms.beans.Publisher;

/**
 * @author Brent Yurek
 *
 */
public class BookDAO extends BaseDAO<Book> {

	@Override
	List<Book> extractData(ResultSet rs) throws ClassNotFoundException, SQLException {
		List<Book> books = new ArrayList<>();
		while (rs.next()) {
			Book book = new Book(rs.getInt("bookId"), rs.getString("title"));
			int authorId = rs.getInt("authId");
			if (!rs.wasNull()) {
				book.setAuthor(new Author(authorId, rs.getString("authorName")));
			}
			int publisherId = rs.getInt("pubId");
			if (!rs.wasNull()) {
				book.setPublisher(new Publisher(publisherId, rs.getString("publisherName"), rs.getString("publisherAddress"), rs.getString("publisherPhone")));
			}
		}
		return books;
	}

	@Override
	public void add(Book book) throws ClassNotFoundException, SQLException {
		save("insert into tbl_book (title, authId, pubId) values (?, ?, ?)",
				new Object[] {
						book.getTitle(), 
						((book.getAuthor() != null) ? book.getAuthor().getId() : null),
						((book.getPublisher() != null) ? book.getPublisher().getId() : null)
				});
	}

	@Override
	public void update(Book book) throws ClassNotFoundException, SQLException {
		save("update tbl_book set title = ?, authId = ?, pubId = ? where bookId = ?",
				new Object[] {
						book.getTitle(), 
						((book.getAuthor() != null) ? book.getAuthor().getId() : null),
						((book.getPublisher() != null) ? book.getPublisher().getId() : null),
						book.getId()
				});
	}

	@Override
	public void delete(Book book) throws ClassNotFoundException, SQLException {
		save("delete from tbl_book where bookId = ?", new Object[] { book.getId() });
	}

	@Override
	public List<Book> getAll() throws ClassNotFoundException, SQLException {
		return read("select * from tbl_book "
				+ "left join tbl_author on tbl_book.authId = tbl_author.authorId "
				+ "left join tbl_publisher on tbl_book.pubId = tbl_publisher.publisherId", null);
	}

}
