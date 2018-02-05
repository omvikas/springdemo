package com.hibernate.test;
/**
 * demo git conflictewqe
 */
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;

import com.om.configuration.HibernateUtil;
import com.om.pojo.Actor;
import com.om.pojo.Student;

public class TestHibernate {

	public static void main(String[] args) {
		SessionFactory factory= HibernateUtil.getSessionFactory();
		Session session=factory.openSession();
		String query = "select address_id, address from address";
		Student s= new Student();
		s.setStudentName("Om");
		
		
	
		Transaction tx=session.beginTransaction();
		Integer id=(Integer) session.save(s);
		tx.commit();
		Student newA=(Student) session.get(Student.class, id);
		System.out.println(s.getStudentName());
		session.close();
		
		
		
		
	}
	
}
