/**
 * 
 */
package com.smoothstack.lms.daos;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.smoothstack.lms.beans.Branch;

/**
 * @author Brent Yurek
 *
 */
public class BranchDAO extends BaseDAO<Branch> {

	@Override
	public void add(Branch branch) throws ClassNotFoundException, SQLException {
		save("insert into tbl_library_branch (branchName, branchAddress) values (?, ?)",
				new Object[] { branch.getName(), branch.getAddress() });
	}

	@Override
	public void update(Branch branch) throws ClassNotFoundException, SQLException {
		save("update tbl_library_branch set branchName = ?, branchAddress = ? where branchId = ?",
				new Object[] { branch.getName(), branch.getAddress(), branch.getId() });
	}
	
	@Override
	public void delete(Branch branch) throws ClassNotFoundException, SQLException {
		save("delete from tbl_library_branch where branchId = ?",
				new Object[] { branch.getId() });
	}
	
	@Override
	public List<Branch> getAll() throws ClassNotFoundException, SQLException {
		return read("select * from tbl_library_branch", null);
	}

	@Override
	List<Branch> extractData(ResultSet rs) throws ClassNotFoundException, SQLException {
		List<Branch> branches = new ArrayList<>();
		while (rs.next()) {
			branches.add(new Branch(rs.getInt("branchId"), rs.getString("branchName"), rs.getString("branchAddress")));
		}
		return branches;
	}
	
}
