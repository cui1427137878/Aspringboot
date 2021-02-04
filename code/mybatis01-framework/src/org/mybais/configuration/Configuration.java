package org.mybais.configuration;
//mybatis-config.xml

import java.util.HashMap;

public class Configuration {
	String url;
	String driver;
	String username;
	String password;

	HashMap<String, SqlMapper> sqlMappers;

	public String getUrl() {
		return url;
	}

	public void setUrl(String url) {
		this.url = url;
	}

	public String getDriver() {
		return driver;
	}

	public void setDriver(String driver) {
		this.driver = driver;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public HashMap<String, SqlMapper> getSqlMappers() {
		return sqlMappers;
	}

	public void setSqlMappers(HashMap<String, SqlMapper> sqlMappers) {
		this.sqlMappers = sqlMappers;
	}

	@Override
	public String toString() {
		return "Configuration [url=" + url + ", driver=" + driver + ", username=" + username + ", password=" + password
				+ ", sqlMappers=" + sqlMappers + "]";
	}

}
