package com.radhey.main;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.boot.Metadata;
import org.hibernate.boot.MetadataSources;
import org.hibernate.boot.registry.StandardServiceRegistry;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;
import org.hibernate.cfg.Configuration;

import com.radhey.entity.Employee;

public class Main {
	
	public static Session getSession()
	{
//		Configuration cfg = new Configuration().configure();
//		SessionFactory sf = cfg.buildSessionFactory();
//		return new Configuration().configure().buildSessionFactory().openSession();
		
		
//		StandardServiceRegistry ssr = new StandardServiceRegistryBuilder().configure().build();
//		Metadata metadata = new MetadataSources(ssr).getMetadataBuilder().build();
//		SessionFactory sessionFactory = metadata.buildSessionFactory();
		
		return new MetadataSources(new StandardServiceRegistryBuilder().configure().build()).getMetadataBuilder().build().buildSessionFactory().openSession();
	}

	public static void main(String[] args) {
		
		Employee e = new Employee(1, "Sukoon", "male", 987650);
		
		Session session = Main.getSession();
		Transaction tx = session.beginTransaction();
		
		session.persist(e);
		tx.commit();
		session.close();
		
	}

}
