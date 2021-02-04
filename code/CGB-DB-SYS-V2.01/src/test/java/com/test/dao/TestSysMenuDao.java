package com.test.dao;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.sql.DataSource;

import org.junit.Test;

import com.test.TestBase;
public class TestSysMenuDao extends TestBase{
	
	@Test
	public void testFindObjects()throws Exception{
		DataSource ds=
		ctx.getBean("druidDataSource",DataSource.class);
	    Connection conn=ds.getConnection();
	    String sql=" select c.*,(select p.name "+
                     " from sys_menus p"+
                     " where c.parentId=p.id) parentName"+
                     " from sys_menus c";
	    Statement stmt=conn.createStatement();
	    ResultSet rs=stmt.executeQuery(sql);
	    ResultSetMetaData rsmd=rs.getMetaData();//id,name,url,type,...
	    List<Map<String,Object>> list=new ArrayList<>();
	    while(rs.next()){//循环一次取一行
	    	Map<String,Object> map=new HashMap<>();
	    	//map.put("id",rs.getInt("id"));
	    	//map.put("name",rs.getString("name"));
	    	//map.put("url",rs.getInt("type"));
	    	//....
	    	for(int i=1;i<=rsmd.getColumnCount();i++){
	    		map.put(rsmd.getColumnLabel(i),
	    				rs.getObject(i));
	    	}
	    	list.add(map);
	    }
	    for(Map<String,Object> map1:list){
	    	System.out.println(map1);
	    }
	    rs.close();
	    stmt.close();
	    conn.close();
	}
	
}


