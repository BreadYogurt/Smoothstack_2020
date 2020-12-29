/**
 * 
 */
package com.smoothstack.lms.daos;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.smoothstack.lms.beans.Borrower;

/**
 * @author Brent Yurek
 *
 */
public class BorrowerDAO extends BaseDAO<Borrower> {

	@Override
	List<Borrower> extractData(ResultSet rs) throws ClassNotFoundException, SQLException {
		List<Borrower> borrowers = new ArrayList<>();
		while (rs.next()) {
			borrowers.add(new Borrower(rs.getInt("cardNo"), rs.getString("name"), rs.getString("address"), rs.getString("phone")));
		}
		return borrowers;
	}

	@Override
	public void add(Borrower borrower) throws ClassNotFoundException, SQLException {
		save("insert into tbl_borrower (name, address, phone) values (?, ?, ?)",
				new Object[] { borrower.getName(), borrower.getAddress(), borrower.getPhone() });
	}

	@Override
	public void update(Borrower borrower) throws ClassNotFoundException, SQLException {
		save("update tbl_borrower set name = ?, address = ?, phone = ? where cardNo = ?",
				new Object[] { borrower.getName(), borrower.getAddress(), borrower.getPhone(), borrower.getCardNo() });
	}

	@Override
	public void delete(Borrower borrower) throws ClassNotFoundException, SQLException {
		save("delete from tbl_borrower where cardNo = ?",
				new Object[] { borrower.getCardNo() });
	}

	@Override
	public List<Borrower> getAll() throws ClassNotFoundException, SQLException {
		return read("select * from tbl_borrower",
				new Object[] {});
	}

}
