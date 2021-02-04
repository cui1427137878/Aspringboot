package com.test.dao;
import java.util.List;

import org.junit.Test;

import com.db.sys.dao.SysLogDao;
import com.db.sys.entity.SysLog;
import com.test.TestBase;

public class TestSysLogDao extends TestBase{
	
	@Test
	public void testDeleteObjects(){
		SysLogDao dao=
				ctx.getBean("sysLogDao",SysLogDao.class);
		int rowCount=dao.deleteObjects(1,2,3);
		System.out.println("rowCount="+rowCount);
	}
	@Test
	public void testGetRowCount(){
		SysLogDao dao=
		ctx.getBean("sysLogDao",SysLogDao.class);
		int rowCount=dao.getRowCount("admin");
		System.out.println("rowCount="+rowCount);
	}
	@Test
	public void testFindPageObjects(){
		SysLogDao dao=ctx.getBean("sysLogDao",SysLogDao.class);
		List<SysLog> list=dao.findPageObjects("admin",0, 5);
		for(SysLog log:list){
		   System.out.println(log);
		}
	}
	
	@Test
	public void testFindObjects01(){
		//1.获取SysLogDao接口实现类对象
		SysLogDao dao=
		ctx.getBean("sysLogDaoImpl",SysLogDao.class);
	    //2.输出dao对象
		System.out.println(dao);
		//3.调用对象方法，从数据库获取数据
		List<SysLog> list=dao.findObjects();
		if(list!=null){
		System.out.println(list.size());
		}
	}
	@Test
	public void testFindObjects02(){
		//1.获取SysLogDao接口实现类对象
		SysLogDao dao=
		ctx.getBean("sysLogDao",SysLogDao.class);
		//2.输出dao对象
		System.out.println(dao.getClass().getName());
		//3.调用对象方法，从数据库获取数据
		List<SysLog> list=dao.findObjects();
		if(list!=null){
			System.out.println(list.size());
		}
	}

}
