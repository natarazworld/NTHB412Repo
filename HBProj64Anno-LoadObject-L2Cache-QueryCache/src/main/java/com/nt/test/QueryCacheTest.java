package com.nt.test;

import java.util.List;


import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import org.hibernate.query.Query;

import com.nt.entity.Product;

public class QueryCacheTest {

	public static void main(String[] args) {
		//Configutration obj
		Configuration cfg=new Configuration();
		cfg.configure("com/nt/cfgs/hibernate.cfg.xml");
		//build SEssionFactory obj
		SessionFactory factory=cfg.buildSessionFactory();
		//build Session
		Session ses=factory.openSession();
		try(factory;ses){
			 Query query=ses.createQuery("from Product");
			 query.setCacheable(true);
			 query.setCacheRegion("region1");
			 List<Product> list=query.getResultList();
			 list.forEach(prod->{
				 System.out.println(prod);
			 });
			 System.out.println("------------------------");
			 List<Product> list1=query.getResultList();
			 list1.forEach(prod->{
				 System.out.println(prod);
			 });
			}//try
		catch(HibernateException he) {
			he.printStackTrace();
		}
		
	}//main
}//class
