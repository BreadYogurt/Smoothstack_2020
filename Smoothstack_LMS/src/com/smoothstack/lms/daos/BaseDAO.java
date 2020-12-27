/**
 * 
 */
package com.smoothstack.lms.daos;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

/**
 * @author Brent Yurek
 *
 */
public abstract class BaseDAO<T> {
	private static String driver = "com.mysql.cj.jdbc.Driver";
	private static String url = "jdbc:mysql://localhost:3306/library";
	private static String username = "root";
	private static String password = "root";
	
	private Connection getConnection() throws ClassNotFoundException, SQLException {
		Class.forName(driver);
		return DriverManager.getConnection(url, username, password);
	}
	
	void save(String sql, Object[] vals) throws ClassNotFoundException, SQLException {
		PreparedStatement pstmt = getConnection().prepareStatement(sql);
		int count = 1;
		for (Object o : vals) {
			pstmt.setObject(count++, o);
		}
		pstmt.executeUpdate();
	}
	
	List<T> read(String sql, Object[] vals) throws ClassNotFoundException, SQLException {
		PreparedStatement pstmt = getConnection().prepareStatement(sql);
		int count = 1;
		for (Object o : vals) {
			pstmt.setObject(count++, o);
		}
		return extractData(pstmt.executeQuery());
	}
	
	abstract List<T> extractData(ResultSet rs) throws ClassNotFoundException, SQLException;
	
	public abstract void add(T t) throws ClassNotFoundException, SQLException;
	public abstract void update(T t) throws ClassNotFoundException, SQLException;
	public abstract void delete(T t) throws ClassNotFoundException, SQLException;
	public abstract List<T> getAll() throws ClassNotFoundException, SQLException;
}
