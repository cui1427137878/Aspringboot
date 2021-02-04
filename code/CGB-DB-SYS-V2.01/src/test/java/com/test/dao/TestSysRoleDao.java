package com.test.dao;

import org.junit.Test;

import com.db.sys.dao.SysRoleDao;
import com.db.sys.vo.SysRoleMenuVo;
import com.test.TestBase;

public class TestSysRoleDao extends TestBase {

	@Test
	public void testFindObjectById(){
		SysRoleDao roleDao=
		ctx.getBean("sysRoleDao",SysRoleDao.class);
		
		SysRoleMenuVo sysRoleMenuVo=
		roleDao.findObjectById(47);
		
		System.out.println(sysRoleMenuVo);
		
	}
}
