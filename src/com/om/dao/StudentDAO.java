package com.om.dao;

import org.hibernate.FlushMode;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.EnableTransactionManagement;

import com.om.pojo.Address;
import com.om.pojo.Student;

@Repository
@EnableTransactionManagement
public class StudentDAO implements StudentTransaction{

	
	@Autowired
	@Qualifier("hibernate5SessionFactory")
	private SessionFactory sessionFactory;
	
	/*public SessionFactory getSessionFactory() {
		return sessionFactory;
	}

	public void setSessionFactory(SessionFactory sessionFactory) {
		this.sessionFactory = sessionFactory;
	}*/

	public Session getSession() {
		//return HibernateUtil.getSessionFactory().openSession();
		return this.sessionFactory.getCurrentSession();
	}
	
	
	@Override
	public int save(Student s) {
		Session session=getSession();
		try {
			if(s!=null) {
			//Transaction tx=session.beginTransaction();
			session.setFlushMode(FlushMode.AUTO);
			Integer id =(Integer)session.save(s);
			//tx.commit();
			return id;
			}
		}
		catch(Exception e) {
			System.err.println("Error in save student method ");
			
			e.printStackTrace();
		}
		finally {
			//session.close();
		}
		return (Integer) null;
	}
	
}
