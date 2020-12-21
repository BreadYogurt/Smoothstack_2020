package com.smoothstack.assignments.week1;

import java.math.BigDecimal;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class SampleSingleton {
	private Connection conn = null;
	
	private static volatile SampleSingleton instance = null;
	
	private SampleSingleton() {
		try {
			conn = DriverManager.getConnection("url of database");
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
	
	public static SampleSingleton getInstance() {
		if (instance == null) {
			synchronized(SampleSingleton.class) {
				if (instance == null) {
					instance = new SampleSingleton();
				}
			}
		}
		return instance;
	}
	
	public void databaseQuery(BigDecimal input) {
		Statement st;
		try {
			st = conn.createStatement();
			ResultSet rs = st.executeQuery("select id from table");
			int x = 0;
			while(rs.next()) {
				x = rs.getInt(1) * input.intValue();
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
}