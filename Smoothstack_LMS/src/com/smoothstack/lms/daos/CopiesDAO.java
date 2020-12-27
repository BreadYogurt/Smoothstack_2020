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
import com.smoothstack.lms.beans.Branch;
import com.smoothstack.lms.beans.Copies;
import com.smoothstack.lms.beans.Publisher;

/**
 * @author Brent Yurek
 *
 */
public class CopiesDAO extends BaseDAO<Copies> {

	@Override
	List<Copies> extractData(ResultSet rs) throws ClassNotFoundException, SQLException {
		List<Copies> copies = new ArrayList<>();
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
			
			copies.add(new Copies(
					book,
					new Branch(rs.getInt("branchId"), rs.getString("branchName"), rs.getString("branchAddress")),
					rs.getInt("noOfCopies")));
		}
		return copies;
	}

	@Override
	public void add(Copies copies) throws ClassNotFoundException, SQLException {
		save("insert into tbl_book_copies (bookId, branchId, noOfCopies) values (?, ?, ?)",
				new Object[] { copies.getBook().getId(), copies.getBranch().getId(), copies.getNoOfCopies() });
	}

	@Override
	public void update(Copies copies) throws ClassNotFoundException, SQLException {
		save("update tbl_book_copies set noOfCopies = ? where bookId = ? and branchId = ?",
				new Object[] { copies.getNoOfCopies(), copies.getBook().getId(), copies.getBranch().getId() });
	}

	@Override
	public void delete(Copies copies) throws ClassNotFoundException, SQLException {
		save("delete from tbl_book_copies where bookId = ? and branchId = ?",
				new Object[] { copies.getBook().getId(), copies.getBranch().getId() });
	}

	@Override
	public List<Copies> getAll() throws ClassNotFoundException, SQLException {
		return read("select * from tbl_book_copies "
				+ "left join tbl_book using (bookId) "
				+ "left join tbl_library_branch using (branchId) "
				+ "left join tbl_author on tbl_book.authId = tbl_author.authorId "
				+ "left join tbl_publisher on tbl_book.pubId = tbl_publisher.publisherId", null);
	}

}
