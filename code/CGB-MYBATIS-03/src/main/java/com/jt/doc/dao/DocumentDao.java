package com.jt.doc.dao;

import java.util.List;

import com.jt.doc.entity.Document;

public interface DocumentDao {
	  List<Document> findPageObjects();
	  int insertObject(Document entity);
}
