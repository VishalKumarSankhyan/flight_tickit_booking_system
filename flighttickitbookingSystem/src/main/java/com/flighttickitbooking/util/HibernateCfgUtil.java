package com.flighttickitbooking.util;

import java.util.Properties;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;
import org.hibernate.cfg.Configuration;
import org.hibernate.cfg.Environment;
import org.hibernate.service.ServiceRegistry;

public class HibernateCfgUtil {
	private static SessionFactory sessionFactory = buildSessionFactory();
	public static SessionFactory buildSessionFactory() {
		if(sessionFactory == null) {
			Configuration configuration = new Configuration();
			Properties properties = new Properties();
			properties.put(Environment.DRIVER, "com.mysql.cj.jdbc.Driver");
			properties.put(Environment.URL, "jdbc:mysql://localhost:3306/flight_tickit_booking_db");
			properties.put(Environment.USER, "root");
			properties.put(Environment.PASS, "sunriser9994");
			
			properties.put(Environment.DIALECT, "org.hibernate.dialect.MySQL8Dialect");
			properties.put(Environment.HBM2DDL_AUTO, "update");
			properties.put(Environment.SHOW_SQL, "true");
			properties.put(Environment.FORMAT_SQL, "true");
			
			configuration.setProperties(properties);
			
			
			ServiceRegistry serviceRegistry = new StandardServiceRegistryBuilder().applySettings(properties).build();
			sessionFactory = configuration.buildSessionFactory(serviceRegistry);
		}
		
		return sessionFactory;
	}
	
	public static SessionFactory getSessionFactory() {
		return sessionFactory;
	}
	
	public static Session getSession() {
		return getSessionFactory().openSession();
	}
	
}
