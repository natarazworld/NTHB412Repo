package com.nt.test;

import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import com.nt.entity.Product;

public class LoadObjectTestUsingGetMethod {

	public static void main(String[] args) {
		//Configutration obj
		Configuration cfg=new Configuration();
		cfg.configure("com/nt/cfgs/hibernate.cfg.xml");
		//build SEssionFactory obj
		SessionFactory factory=cfg.buildSessionFactory();
		//build Session
		Session ses=factory.openSession();
		try(factory;ses){  //try with resource
			  //Load object using get(-,-) method
			 Product prod=ses.get(Product.class, 1452);
			 if(prod==null)
				 System.out.println("Product not found");
			 else
				 System.out.println(prod); 
		}//try
		catch(HibernateException he) {
			he.printStackTrace();
		}
		
	}//main
}//class
