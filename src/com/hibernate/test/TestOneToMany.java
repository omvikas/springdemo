package com.hibernate.test;

import java.util.HashSet;
import java.util.Set;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;

import com.om.configuration.HibernateUtil;
import com.om.pojo.Address;
import com.om.pojo.Student;

public class TestOneToMany {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		try{
			Set<Address> adress= new HashSet<Address>();
			Student s= new Student();
			s.setStudentName("Swapnil");
			
			HashSet<Address> addlist=(HashSet)getAddress();
			//s.setAddress(add);
			SessionFactory factory= HibernateUtil.getSessionFactory();
			Session session=factory.openSession();
			Transaction tx= session.beginTransaction();
			Integer id=(Integer) session.save(s);
			System.out.println(id);
			Address add= new Address();
			add.setCity("Pune");
			add.setStudent(s);
			//s.getAddress().add(add);
			for(Address addr:addlist) {
				addr.setStudent(s);
				session.save(addr);
			}
			//s.setAddress(addlist);
			tx.commit();
			
			session.close();
			System.out.println(id);
		}
		catch(Exception e ) {
			System.out.println("Exception Occured");
			e.printStackTrace();
		}
		
	}

	public static Set<Address> getAddress(){
		Student s= new Student();
		s.setStudentName("Swapnil");
		Set<Address> address= new HashSet<Address>();
		Address address1= new Address();
		address1.setId(1);
		address1.setCity("kolkata");
		//address1.setStudent(s);
		address.add(address1);
		Address address2= new Address();
		address2.setCity("Pune");
		address2.setId(2);
		//address2.setStudent(s);
		address.add(address2);
		Address address3= new Address();
		address3.setCity("Mumbai");
		address3.setId(3);
		//address3.setStudent(s);
		address.add(address3);
		return address;
	}
}
