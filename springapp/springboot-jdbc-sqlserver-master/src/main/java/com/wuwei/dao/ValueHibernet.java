package com.wuwei.dao;

import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.springframework.stereotype.Repository;

import com.wuwei.entity.*;
import com.wuwei.util.HibernateUtil;

@Repository("ValueHibernet")
public class ValueHibernet implements IHibernate {

	static final SessionFactory sessionFactory = HibernateUtil.getSessionFactory();
	static Session session = sessionFactory.openSession();

	@Override
	public int update(Object object) {

//		System.out.println("updateUser dao  valuesName" + ((values) object).getFirstName() + " " + ((values) object).getLastName());
		session = session.getSessionFactory().openSession();
		Transaction tx = session.beginTransaction();
		try {
			session.update(object);
			System.out.println("postValues dao succeed");
			tx.commit();
			return 1;
		} catch (Exception ex) {
			return 0;
		} finally {
			session.close();
		}

	}

	@Override
	public int create(Object values) {
//		System.out.println("createUser dao  valuesName " + ((values) values).getFirstName() + " " + ((values) values).getLastName());
		session = session.getSessionFactory().openSession();
		Transaction tx = session.beginTransaction();
		try {
			session.save(values);
			System.out.println("createValues dao succeed");
			tx.commit();
			return 1;
		} catch (Exception ex) {
			System.out.println(ex);
			return 0;
		} finally {
			session.close();
		}

	}

	
	public Object get(String email) {
		System.out.println("on get dao email: "+email);
//		String hql = "FROM Value u where u.email= :email INNER JOIN u.optionId INNER JOIN u.userId";
		String hql = "FROM Value v";
		session = session.getSessionFactory().openSession();
		Query query = session.createQuery(hql);
		query.setParameter("email", email);
		@SuppressWarnings("unchecked")
		Object results = query.list().get(0);
		System.out.println("Get " + results + " וvalues succeeded!");
			return results;
	}

	@Override
	public List<Object> getAll() {
		String hql ="select v.valueId, v.valueName, o, u FROM Value v, Option o, User u WHERE v.optionId=o.optionId and v.userId=u.userId";
		session = session.getSessionFactory().openSession();
		Query query = session.createQuery(hql);
		@SuppressWarnings("unchecked")
		List<Object> results = query.list();
		System.out.println("Get all וvaluess succeeded!");
		session.close();
		return results;
	}

	@Override
	public int delete(String email) {
		Value values = (Value) get(email);
		session = session.getSessionFactory().openSession();
		Transaction tx = session.beginTransaction();
		try {
			session.delete(values);
			System.out.println("deleteUser dao succeed");
			tx.commit();
			return 1;
		} catch (Exception ex) {
			System.out.println(ex);
			return 0;
		} finally {
			session.close();
		}
	}

	@Override
	public Object getByName(String Name) {
		System.out.println("on getByName dao email: "+Name);
		String hql = "FROM Value u INNER JOIN u.optionId INNER JOIN u.userId where u.valueName= :valueName ";
		session = session.getSessionFactory().openSession();
		Query query = session.createQuery(hql);
		query.setParameter("valueName", Name);
		@SuppressWarnings("unchecked")
		Object results = query.list();
		System.out.println("Get " + results + " וvalues succeeded!");
			return results;
	}

	@Override
	public Object getById(int Id) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public int deleteAll() {
		// TODO Auto-generated method stub
		return 0;
	}
}