package com.fedfeu.config;

import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

public class Config {
	private static Properties prop = new Properties();
	
	private static final String CONFIG_FILE = "config.properties";
	public static final String MYSQL_USER = "mysql_user";
	public static final String MYSQL_PASSWORD = "mysql_password";
	public static final String MYSQL_SERVER = "mysql_server";
	public static final String MYSQL_PORT = "mysql_port";
	public static final String MYSQL_DATABASE = "mysql_database";
	
	static {
		try {
			//Java Resources folder
			InputStream input = Config.class.getClassLoader().getResourceAsStream(CONFIG_FILE);
			prop.load(input);
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	public static String getProperty(String property) {
		return prop.getProperty(property);
	}
}
