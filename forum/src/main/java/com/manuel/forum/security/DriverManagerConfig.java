package com.manuel.forum.security;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

@Component
public class DriverManagerConfig {

	private static String datasourceUrl;

	private static String dbUsername;

	private static String dbPassword;

//	@Value("${spring.datasource.driverClassName}")
//	private static String driverName;

	protected static String getDatasourceUrl() {
		return datasourceUrl;
	}

	protected static String getDbUsername() {
		return dbUsername;
	}

	protected static String getDbPassword() {
		return dbPassword;
	}

	@Value("${spring.datasource.url}")
	private void setDatasourceUrl(String datasource) {
		datasourceUrl = datasource;
	}

	@Value("${spring.datasource.username}")
	private void setDbUsername(String username) {
		dbUsername = username;
	}

	@Value("${spring.datasource.password}")
	private void setDbPassword(String password) {
		dbPassword = password;
	}

//	public static String getDriverName() {
//		return driverName;
//	}

}
