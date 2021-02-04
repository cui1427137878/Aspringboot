package com.mybatis.test;

import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.junit.Test;

import com.github.pagehelper.PageHelper;
import com.jt.common.type.DocStatus;
import com.jt.doc.dao.DocumentDao;
import com.jt.doc.entity.Document;

public class TestDocument01 extends TestBase {
	
	@Test
	public void testFindPageObjects() {
		SqlSession session=factory.openSession();
		DocumentDao dao=session.getMapper(DocumentDao.class);
		//PageHelper.startPage(1, 3);
		List<Document> docs=dao.findPageObjects();
		for(Document doc:docs) {
			System.out.println(doc);
		}
		session.close();
	}

	@Test
	public void testInsertObject() {
		SqlSession session=factory.openSession();
		DocumentDao dao=session.getMapper(DocumentDao.class);
		Document d=new Document();
		d.setName("d.doc");
		d.setContentType("application/doc");
		d.setContentDigest("AAAAAAAAAAAAAAAA");
		d.setFilePath("/uploads/projects/b.doc");
        d.setStatus(DocStatus.PUBLISHED);//JavaType
		d.setCreatedUser("admin");
		d.setModifiedUser("admin");
		d.setRemark("aaaaaaaaaa");
		dao.insertObject(d);
		session.commit();
		session.close();
	}
}
