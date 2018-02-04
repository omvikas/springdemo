package com.hibernate.test;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;

import com.om.configuration.HibernateUtil;
import com.om.pojo.Address;
import com.om.pojo.Student;

public class TestOneToOne {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		Student s= new Student();
		s.setStudentName("Swapnil");
		Address address= new Address();
		address.setCity("kolkata");
		s.setStudentAddress(address);
		address.setStudent(s);
		SessionFactory factory= HibernateUtil.getSessionFactory();
		Session session=factory.openSession();
		Transaction tx=session.beginTransaction();
		Integer id=(Integer) session.save(s);
		tx.commit();
		session.close();
		System.out.println(id);
		
		
	}

}
