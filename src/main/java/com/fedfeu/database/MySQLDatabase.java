package com.fedfeu.database;

import java.sql.Connection;
import java.sql.SQLException;

import com.mysql.jdbc.jdbc2.optional.MysqlDataSource;

public class MySQLDatabase {
	private static MysqlDataSource dataSource;
	
	private static final String MYSQL_USER = "";
	private static final String MYSQL_PASSWORD = "";
	private static final String MYSQL_SERVER_NAME = "";

    static {
        dataSource = new MysqlDataSource();
        dataSource.setUser(MYSQL_USER);
        dataSource.setPassword(MYSQL_PASSWORD);
        dataSource.setServerName(MYSQL_SERVER_NAME);
    }

    public static Connection getConnection() {
        try {
			return dataSource.getConnection();
		} catch (SQLException e) {
			e.printStackTrace();
			return null;
		}
    }
}
