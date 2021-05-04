package com.wuwei.dao;

import java.util.List;


public interface IHibernate {
	
	List<Object> getAll();

	Object getById(int id);
	
	Object getByName(String Name);

int create(Object object);

	int update(Object object);

	int deleteAll();

	int delete(String option);

}
