package com.om.configuration;

import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;

import org.hibernate.SessionFactory;

public class HibernateConfig implements ServletContextListener{

	public static SessionFactory sessionFactory;
	
	@Override
	public void contextDestroyed(ServletContextEvent arg0) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void contextInitialized(ServletContextEvent arg0) {
		// TODO Auto-generated method stub
		 sessionFactory=HibernateUtil.getSessionFactory();
		 arg0.getServletContext().setAttribute("SessionFactory", sessionFactory);
		
	}

}
