package com.radhey.main;

import java.util.ArrayList;
import java.util.List;

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
		System.out.println(address.getEmp());
		
		
	}

	public static void main(String[] args) {
		Employee e = new Employee();
		e.setName("Amir Khan");
		e.setCountry("india");
		e.setSalary(222222);
		e.setGender("M");
		
		
		Address add1 = new Address("GZB","UP",e);
		Address add2 = new Address("Noida","UP",e);
		Address add3 = new Address("Meerut","UP",e);
		Address add4 = new Address("Lahore","UP",e);
		
		List<Address> addresses = new ArrayList<Address>();
		addresses.add(add1);
		addresses.add(add2);
		addresses.add(add3);
		addresses.add(add4);
		
		

		
//		e.setAddresses(List.of(add1, add2, add3, add4));
		e.setAddresses(addresses);
		
		SessionFactory sf = HibernateConfig.getSessionFactory();
		Session session = sf.openSession();
		Transaction tx = session.beginTransaction();

		session.persist(e);

		session.persist(add1);
		session.persist(add2);
		session.persist(add3);
		session.persist(add4);
		
		
		tx.commit();
		


		session.close();
		
		session = sf.openSession();
		
		getObjects(session);


	}

}
