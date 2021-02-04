package org.mybatis.config;

import java.util.HashMap;

//放mybatis-config.xml中的信息
public class Configuration {
    String driver,url,username,password;
    //放所有select标签信息
    HashMap<String,SqlMapper> sqlMappers=new HashMap<>();

    @Override
    public String toString() {
        return "Configuration{" +
                "driver='" + driver + '\'' +
                ", url='" + url + '\'' +
                ", username='" + username + '\'' +
                ", password='" + password + '\'' +
                ", sqlMappers=" + sqlMappers +
                '}';
    }

    public String getDriver() {
        return driver;
    }

    public void setDriver(String driver) {
        this.driver = driver;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
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
}
