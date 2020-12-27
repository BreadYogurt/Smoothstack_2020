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
import com.smoothstack.lms.beans.Borrower;
import com.smoothstack.lms.beans.Branch;
import com.smoothstack.lms.beans.Loan;
import com.smoothstack.lms.beans.Publisher;

/**
 * @author Brent Yurek
 *
 */
public class LoanDAO extends BaseDAO<Loan> {

	@Override
	List<Loan> extractData(ResultSet rs) throws ClassNotFoundException, SQLException {
		List<Loan> loans = new ArrayList<>();
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
			
			loans.add(new Loan(
					book,
					new Branch(rs.getInt("branchId"), rs.getString("branchName"), rs.getString("branchAddress")),
					new Borrower(rs.getInt("cardNo"), rs.getString("name"), rs.getString("address"), rs.getString("phone")),
					rs.getDate("dateOut"),
					rs.getDate("dueDate")));
		}
		return loans;
	}

	@Override
	public void add(Loan loan) throws ClassNotFoundException, SQLException {
		save("insert into tbl_book_loans (bookId, branchId, cardNo, dateOut, dueDate) values (?, ?, ?, ?, ?)",
				new Object[] { loan.getBook().getId(), loan.getBranch().getId(), loan.getBorrower().getCardNo(), loan.getDateOut(), loan.getDueDate() });
	}

	@Override
	public void update(Loan loan) throws ClassNotFoundException, SQLException {
		save("update tbl_book_loans set dateOut = ?, dueDate = ? where bookId = ? and branchId = ? and cardNo = ?",
				new Object[] { loan.getDateOut(), loan.getDueDate(), loan.getBook().getId(), loan.getBranch().getId(), loan.getBorrower().getCardNo() });
	}

	@Override
	public void delete(Loan loan) throws ClassNotFoundException, SQLException {
		save("delete from tbl_book_loans where bookId = ? and branchId = ? and cardNo = ?",
				new Object[] { loan.getBook().getId(), loan.getBranch().getId(), loan.getBorrower().getCardNo() });
	}

	@Override
	public List<Loan> getAll() throws ClassNotFoundException, SQLException {
		return read("select * from tbl_book_loans "
				+ "left join tbl_book using (bookId) "
				+ "left join tbl_library_branch using (branchId) "
				+ "left join tbl_borrower using (cardNo) "
				+ "left join tbl_author on tbl_book.authId = tbl_author.authorId "
				+ "left join tbl_publisher on tbl_book.pubId = tbl_publisher.publisherId", null);
	}

}
