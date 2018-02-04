package com.om.configuration;

import org.hibernate.SessionFactory;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;
import org.hibernate.cfg.Configuration;
import org.hibernate.service.ServiceRegistry;

public class HibernateUtil {
	private static SessionFactory sessionFactory;
	private static SessionFactory buildSessionFactory() {
		String key="";
		try {
		Configuration configuration= new Configuration();
		configuration.configure("/com/om/configuration/hibernate.cfg.xml");
		System.out.println("Configuration loaded with key"+ key);
		ServiceRegistry serviceRegistry = new StandardServiceRegistryBuilder()
				.applySettings(configuration.getProperties()).build();
		 sessionFactory = configuration.buildSessionFactory(serviceRegistry);
		return sessionFactory;
		}
		catch(Throwable e ) {
			System.err.println("Loading of Session Factory failed "+e.getMessage());
			e.printStackTrace();
		}
		return null;
	}
	
	public static SessionFactory getSessionFactory() {
		if(sessionFactory==null)
			sessionFactory=buildSessionFactory();
		return sessionFactory;
	}
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
	}

}
