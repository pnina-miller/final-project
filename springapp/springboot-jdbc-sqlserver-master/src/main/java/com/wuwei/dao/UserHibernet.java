package com.wuwei.dao;

import java.util.List;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.springframework.stereotype.Repository;
import com.wuwei.util.HibernateUtil;

@Repository("UserHibernet")
public class UserHibernet implements IHibernate {

	static final SessionFactory sessionFactory = HibernateUtil.getSessionFactory();
	static Session session = sessionFactory.openSession();
	
	@Override
	public List<Object> getAll() {
		try {
		String hql = "FROM User u ";
		session = session.getSessionFactory().openSession();
		Query query = session.createQuery(hql);
		@SuppressWarnings("unchecked")
		List<Object> results = query.list();
		System.out.println("Get all וusers succeeded!");
		return results;
		} catch (Exception ex) {
			System.out.println(ex);
			return null;
		} finally {
			session.close();
		}
	}
	
	@Override
	public Object getById(int id) {
		try {
			String hql = "FROM User u where u.id= :id";
			session = session.getSessionFactory().openSession();
			Query query = session.createQuery(hql);
			query.setParameter("id", id);
			Object result = query.list().get(0);
			System.out.println("Get " + result + " וuser succeeded!");

				return result;
			} catch (Exception ex) {
				System.out.println(ex);
				return 0;
			} finally {
				session.close();
			}
	}

	@Override
	public Object getByName(String name) {
		try {
			System.out.println("on getByName name: "+name);
		String hql = "FROM User u where u.email= :email";
		session = session.getSessionFactory().openSession();
		Query query = session.createQuery(hql);
		query.setParameter("email", name);
		Object result = query.list().get(0);
		System.out.println("Get " + result + " וuser succeeded!");

			return result;
		} catch (Exception ex) {
			System.out.println("error in getByName: "+ex);
			return 0;
		} finally {
			session.close();
		}
	}
	
	@Override
	public int create(Object user) {
		session = session.getSessionFactory().openSession();
		Transaction tx = session.beginTransaction();
		try {
			session.save(user);
			System.out.println("createUser dao succeed");
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
	public int update(Object object) {//not finished

	session = session.getSessionFactory().openSession();
		Transaction tx = session.beginTransaction();
		try {
			session.update(object);
			System.out.println("postUser dao succeed");
			tx.commit();
			return 1;
		} catch (Exception ex) {
			return 0;
		} finally {
			session.close();
		}

	}
	
	@Override
	public int delete(String email) {
		try {
			String hql = "DELETE FROM User WHERE email = :option";
			session = session.getSessionFactory().openSession();
			Query query = session.createQuery(hql);
			query.setParameter("email", email);
			query.executeUpdate();
			System.out.println("delete וuser succeeded!");
			return 1;
			} catch (Exception ex) {
				System.out.println(ex);
				return 0;
			} finally {
				session.close();
			}
	}

	@Override
	public int deleteAll() {
		try {
			String hql = "DELETE FROM User";
			session = session.getSessionFactory().openSession();
			Query query = session.createQuery(hql);
			query.executeUpdate();
			System.out.println("delete וuser succeeded!");
			return 1;
			} catch (Exception ex) {
				System.out.println(ex);
				return 0;
			} finally {
				session.close();
			}
	}

	public String tryFunc() {
		String str="work";
		return str;
	}
}
