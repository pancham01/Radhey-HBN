package com.radhey.main;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;

import com.radhey.configuration.HibernateConfig;
import com.radhey.entity.Address;
import com.radhey.entity.Employee;

public class Main {
	
	public static void getObjects(Session session)
	{

		Employee employee = session.get(Employee.class, 1);

		System.out.println(employee);
		
		System.out.println("<<<<<<<<<<<<<<<<<<<<<<<<<<>>>>>>>>>>>>>>>>>>>>");
		
		Address address = session.get(Address.class, 1);

		System.out.println(address);
		
		
	}

	public static void main(String[] args) {

		Address add1 = new Address("Noida", "UP");

		Employee e = new Employee();
		e.setName("Amir Khan");
		e.setCountry("india");
		e.setSalary(222222);
		e.setGender("M");
		e.setAddress(add1);

		SessionFactory sf = HibernateConfig.getSessionFactory();
		Session session = sf.openSession();
		Transaction tx = session.beginTransaction();

//		session.persist(add1);
		
		session.persist(e);
		
		tx.commit();

		session.close();

	}

}
