package com.radhey.main;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

import com.radhey.entity.Employee;

public class Main {
	
	public static Session getSession()
	{
		Configuration cfg = new Configuration().configure("hibernate.cfg.xml");
		SessionFactory sf = cfg.buildSessionFactory();
		return sf.openSession();
	}

	public static void main(String[] args) {
		Employee e = new Employee(2, "Radha", "female", 987650);
		Session session = Main.getSession();
		Transaction tx = session.beginTransaction();
		
		
		session.persist(e);
		tx.commit();
		
	}

}
