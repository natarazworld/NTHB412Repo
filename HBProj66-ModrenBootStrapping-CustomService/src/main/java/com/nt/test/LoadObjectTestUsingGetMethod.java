package com.nt.test;

import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import com.nt.entity.Product;
import com.nt.utility.HibernateUtil;

public class LoadObjectTestUsingGetMethod {

	public static void main(String[] args) {
		//get SessionFactory object
		SessionFactory factory=HibernateUtil.getSessionFactory();
		//get SEssion object
		Session ses=HibernateUtil.getSession();
		try(factory;ses){  //try with resource
			  //Load object using get(-,-) method
			 Product prod=ses.get(Product.class, 25);
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
