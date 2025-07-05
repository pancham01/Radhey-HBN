package com.radhey.configuration;

import java.util.Properties;

import org.hibernate.SessionFactory;
import org.hibernate.boot.MetadataSources;
import org.hibernate.boot.registry.StandardServiceRegistry;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;
import org.hibernate.cfg.Environment;

public class HibernateConfig {
	
	
	
	public static SessionFactory getSessionFactory()
	{
		Properties prop = new Properties();
		
		prop.put(Environment.DIALECT,"org.hibernate.dialect.MySQLDialect");
		prop.put(Environment.JAKARTA_JDBC_URL,"jdbc:mysql://localhost:3306/testDb");
		prop.put(Environment.JAKARTA_JDBC_USER,"root");
		prop.put("jakarta.persistence.jdbc.password","root");
		prop.put(Environment.HBM2DDL_AUTO,"update");
		prop.put(Environment.SHOW_SQL,"true");
		prop.put(Environment.FORMAT_SQL,"true");

//		In XML based configuration		
//		StandardServiceRegistry ssr = new StandardServiceRegistryBuilder().configure().build();
//		Metadata metadata = new MetadataSources(ssr).getMetadataBuilder().build();
//		SessionFactory sessionFactory = metadata.buildSessionFactory();
		
//		In Java based configuration		
//		StandardServiceRegistry ssr = new StandardServiceRegistryBuilder().applySettings(prop).build();
//		MetadataSources metaDataSources =	new MetadataSources(ssr).addAnnotatedClass(com.radhey.entity.Employee.class);
//		SessionFactory sessionFactory = metaDataSources.getMetadataBuilder().build().buildSessionFactory();
		
		StandardServiceRegistry ssr = new StandardServiceRegistryBuilder().applySettings(prop).build();
		return new MetadataSources(ssr).addAnnotatedClasses(com.radhey.entity.Employee.class,com.radhey.entity.Address.class).getMetadataBuilder().build().buildSessionFactory();
	}

}
