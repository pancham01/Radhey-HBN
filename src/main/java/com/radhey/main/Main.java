package com.radhey.main;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.query.Query;

import com.radhey.configuration.HibernateConfig;
import com.radhey.entity.Employee;

public class Main {
	

	public static void main(String[] args) {
		
		Employee e = new Employee("Sukoon", "female", 987650,"India");
		SessionFactory sf = HibernateConfig.getSessionFactory();
		Session session = sf.openSession();
		Transaction tx = session.beginTransaction();
		
		Query query = session.createQuery("from Employee",Employee.class);
		
		List list = query.list();		
		
		
		System.out.println(list);
		
		
		
//		session.persist(e);
//		tx.commit();
		
		session.close();
		
	}

}
