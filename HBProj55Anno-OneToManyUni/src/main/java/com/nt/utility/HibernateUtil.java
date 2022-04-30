package com.nt.utility;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class HibernateUtil {
	 private static SessionFactory factory;
	static {
		//create  Configuration object
		Configuration cfg=new Configuration();
		//Load and read HB configuration file
		cfg.configure("com/nt/cfgs/hibernate.cfg.xml");
		//build SessionFactory
		factory=cfg.buildSessionFactory();
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
	}//method
	
	
	public static  void closeSessionFactory() {
		   if(factory!=null)
			   factory.close();
			   
	}//method
	
	

}
