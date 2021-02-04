package com.test;
import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.junit.Test;

import com.pt.member.dao.MemberDao;
import com.pt.member.entity.Member;

public class TestMember02 extends TestBase{

	@Test
	public void testFindPageObjects()throws Exception{
		//1.获取sqlsession对象
		SqlSession session=factory.openSession();
		//2.获取MemberDao接口类型对象
		MemberDao dao=
		//当我们执行getMapper方法时，系统底层
		//会为指定接口产生一个实现类的对象。
		session.getMapper(MemberDao.class);
		//输出接口类型
		//System.out.println(MemberDao.class.getName());
		//输出实现类的类型
		System.out.println(dao.getClass().getName());
		//3.调用接口方法执行查询操作
		List<Member> list=dao.findPageObjects(0,2);//底层会调用session.selectList(statement)
		//当我们调用接口的方法时，底层运行时会调用具体实现类的
		//方法($Proxy.findPageObjects())
		for(Member m:list){
			System.out.println(m);
		}
		//4.释放资源
		session.close();
	}
	
}
