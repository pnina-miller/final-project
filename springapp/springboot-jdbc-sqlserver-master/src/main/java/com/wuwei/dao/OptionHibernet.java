package com.wuwei.dao;


import java.util.List;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.springframework.stereotype.Repository;
import com.wuwei.util.HibernateUtil;
import com.wuwei.entity.Option;

@Repository("OptionHibernet")
public class OptionHibernet implements IHibernate {

	static final SessionFactory sessionFactory = HibernateUtil.getSessionFactory();
	static Session session = sessionFactory.openSession();
	
	@Override
	public int create(Object object) {
		System.out.println("createOption dao  Option:"+object);
		session = session.getSessionFactory().openSession();
		Transaction tx = session.beginTransaction();
		try {
			session.save(object);
			System.out.println("createOption dao succeed");
			tx.commit();
			return 1;
		} catch (Exception ex) {
			System.out.println("error in createOption: "+ex);
			return 0;
		} finally {
			session.close();
		}

	}

	@Override
	public Object getByName(String Name) {
		try {
			session = session.getSessionFactory().openSession();
			String hql = "FROM Option u where u.optionName= :option";
			Query query = session.createQuery(hql);
			query.setParameter("option", Name);
			@SuppressWarnings("unchecked")
			Object  results = query.list().get(0);
			System.out.println("get " + results + " Option succeeded!");
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
			session = session.getSessionFactory().openSession();
			String hql = "FROM Option u where u.optionId= :option";
			Query query = session.createQuery(hql);
			query.setParameter("option", id);
			@SuppressWarnings("unchecked")
			Object  result = query.list().get(0);
			System.out.println("get " + result + " Option succeeded!");
				return result;
			} catch (Exception ex) {
				System.out.println(ex);
				return null;
			} finally {
				session.close();
			}
	}


	@Override
	public List<Object> getAll() {
		try {
		String hql = "FROM Option u ";
		session = session.getSessionFactory().openSession();
		Query query = session.createQuery(hql);
		@SuppressWarnings("unchecked")
		List<Object> results = query.list();

		System.out.println("Get all ??Options succeeded!");
		return results;
		} catch (Exception ex) {
			System.out.println(ex);
			return null;
		} finally {
			session.close();
		}
	}

	@Override
	public int delete(String option) {
		try {
		session = session.getSessionFactory().openSession();
		String hql = "DELETE FROM Option WHERE optionName = :option";
		Query query = session.createQuery(hql);
		query.setParameter("option", option);
		query.executeUpdate();
			System.out.println("deleteOption dao succeed");
			return 1;
		} catch (Exception ex) {
			System.out.println(ex);
			return 0;
		} finally {
			session.close();
		}
	}

	public int createOptions() {
			try {
 String[] options={"",""};
			System.out.println("createOptions dao  ");
			session = session.getSessionFactory().openSession();
			Transaction tx = session.beginTransaction();
				for (String op : options) {
						Option newOption=new Option(op);
				session.save(newOption);
					}
				System.out.println("createOption dao succeed");
				tx.commit();
				return 1;
			} catch (Exception ex) {
				System.out.println("error: "+ex);
				return 0;
			} finally {
				session.close();
			}

	}

	@Override
	public int update(Object option) {
		try {
		System.out.println("updateOption dao");
		session = session.getSessionFactory().openSession();
		Transaction tx = session.beginTransaction();
			session.update(option);
			System.out.println("postOption dao succeed");
			tx.commit();
			return 1;
		} catch (Exception ex) {
			return 0;
		} finally {
			session.close();
		}
	}


	@Override
	public int deleteAll() {
		try {
			session = session.getSessionFactory().openSession();
			String hql = "DELETE FROM Option";
			Query query = session.createQuery(hql);
			query.executeUpdate();
			System.out.println("deleteOption dao succeed");
			return 1;
			} catch (Exception ex) {
				System.out.println(ex);
				return 0;
			} finally {
				session.close();
			}
	}


}
