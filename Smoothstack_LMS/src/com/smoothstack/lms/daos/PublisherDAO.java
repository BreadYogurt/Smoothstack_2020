/**
 * 
 */
package com.smoothstack.lms.daos;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.smoothstack.lms.beans.Publisher;

/**
 * @author Brent Yurek
 *
 */
public class PublisherDAO extends BaseDAO<Publisher> {

	@Override
	List<Publisher> extractData(ResultSet rs) throws ClassNotFoundException, SQLException {
		List<Publisher> publishers = new ArrayList<>();
		while (rs.next()) {
			publishers.add(new Publisher(
					rs.getInt("publisherId"),
					rs.getString("publisherName"),
					rs.getString("publisherAddress"),
					rs.getString("publisherPhone")));
		}
		return publishers;
	}

	@Override
	public void add(Publisher publisher) throws ClassNotFoundException, SQLException {
		save("insert into tbl_publisher (publisherName, publisherAddress, publisherPhone) values (?, ?, ?)",
				new Object[] { publisher.getName(), publisher.getAddress(), publisher.getPhone() });
	}

	@Override
	public void update(Publisher publisher) throws ClassNotFoundException, SQLException {
		save("update tbl_publisher set publisherName = ?, publisherAddress = ?, publisherPhone = ? where publisherId = ?",
				new Object[] { publisher.getName(), publisher.getAddress(), publisher.getPhone(), publisher.getId() });
	}

	@Override
	public void delete(Publisher publisher) throws ClassNotFoundException, SQLException {
		save("delete from tbl_publisher where publisherId = ?",
				new Object[] { publisher.getId() });
	}

	@Override
	public List<Publisher> getAll() throws ClassNotFoundException, SQLException {
		return read("select * from tbl_publisher", null);
	}

}
