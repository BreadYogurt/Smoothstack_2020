/**
 * 
 */
package com.smoothstack.lms.daos;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.smoothstack.lms.beans.Author;

/**
 * @author Brent Yurek
 *
 */
public class AuthorDAO extends BaseDAO<Author> {

	@Override
	List<Author> extractData(ResultSet rs) throws ClassNotFoundException, SQLException {
		List<Author> authors = new ArrayList<>();
		while (rs.next()) {
			authors.add(new Author(rs.getInt("authorId"), rs.getString("authorName")));
		}
		return authors;
	}

	@Override
	public void add(Author author) throws ClassNotFoundException, SQLException {
		save("insert into tbl_author (authorName) values (?)",
				new Object[] { author.getName() });
	}

	@Override
	public void update(Author author) throws ClassNotFoundException, SQLException {
		save("update tbl_author set authorName = ? where authorId = ?",
				new Object[] { author.getName(), author.getId() });
	}

	@Override
	public void delete(Author author) throws ClassNotFoundException, SQLException {
		save("delete from tbl_author where authorId = ?",
				new Object[] { author.getId() });
	}

	@Override
	public List<Author> getAll() throws ClassNotFoundException, SQLException {
		return read("select * from tbl_author",
				new Object[] {});
	}

}
