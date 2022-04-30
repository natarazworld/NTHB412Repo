package com.nt.utility;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.boot.registry.StandardServiceRegistry;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;
import org.hibernate.boot.registry.classloading.spi.ClassLoaderService;
import org.hibernate.boot.registry.selector.spi.StrategySelector;
import org.hibernate.cfg.Configuration;
import org.hibernate.engine.jdbc.connections.spi.ConnectionProvider;

import com.nt.service.CustomJDBCConnectionService;

public class HibernateUtil {
	 private static SessionFactory factory;
		/*static {
			System.out.println("HibernateUtil.static block");
			//create  Configuration object
			Configuration cfg=new Configuration();
			//Load and read HB configuration file
			cfg.configure("com/nt/cfgs/hibernate.cfg.xml");
			cfg.addResource("com/nt/entity/Product.hbm.xml");
			//create SErviceRegistryBuilder
			StandardServiceRegistryBuilder builder=new StandardServiceRegistryBuilder();
			//create SErvice Registry
			StandardServiceRegistry registry=builder.applySettings(cfg.getProperties()).build();
			//build SessionFactory
			factory=cfg.buildSessionFactory(registry);
		}*/
	 
	   //more improved static  block
	 
	 static {
			System.out.println("HibernateUtil.static block");
			//create  Configuration object
			Configuration cfg=new Configuration();
			//create SErviceRegistryBuilder
			StandardServiceRegistryBuilder builder=new StandardServiceRegistryBuilder();
			builder.addService(ConnectionProvider.class, new CustomJDBCConnectionService());
			//create SErvice Registry
			StandardServiceRegistry registry=builder.configure("com/nt/cfgs/hibernate.cfg.xml").build();
			System.out.println(registry.getParentServiceRegistry());
			System.out.println(registry.getService(ClassLoaderService.class)+"  "+registry.getService(ConnectionProvider.class)+"  "+registry.getService(StrategySelector.class));
			//build SessionFactory
			factory=cfg.buildSessionFactory(registry);
		}
	 
	
	//static factory method for SessionFactory object
	public  static SessionFactory getSessionFactory() {
		        	return factory;
	}
	
	//static factory  method  for session obj  
	public  static   Session  getSession() {
		        Session ses=null;
		        if(factory!=null)
		        	ses=factory.openSession();
		        return ses;
	}
	
	
	

}
