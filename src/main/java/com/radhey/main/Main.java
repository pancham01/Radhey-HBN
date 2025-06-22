package com.radhey.main;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;

import com.radhey.configuration.HibernateConfig;
import com.radhey.entity.Employee;

public class Main {
	

	public static void main(String[] args) {
		
		Employee e = new Employee("Muskan", "female", 987650,"India");
		SessionFactory sf = HibernateConfig.getSessionFactory();
		Session session = sf.openSession();
		Transaction tx = session.beginTransaction();
		session.persist(e);
		tx.commit();
		
		session.close();
		
	}

}
