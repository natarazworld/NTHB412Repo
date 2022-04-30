package com.nt.test;

import org.hibernate.Cache;
import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import com.nt.entity.Product;

public class L2CacheTest {

	public static void main(String[] args) {
		//Configutration obj
		Configuration cfg=new Configuration();
		cfg.configure("com/nt/cfgs/hibernate.cfg.xml");
		//build SEssionFactory obj
		SessionFactory factory=cfg.buildSessionFactory();
		//build Session
		Session ses=factory.openSession();
		try(factory;ses){
			Product prod=ses.get(Product.class, 25);  //gets from DB and keeps L2, L1 cache
			System.out.println(prod);
			System.out.println("------------------");
			Product prod1=ses.get(Product.class, 25);  //gets from  L1 cache
			System.out.println(prod1);
			System.out.println("__________________");
			ses.evict(prod1);  //removes prod1 from L1 cache
			Product prod2=ses.get(Product.class, 25);  //gets from  L2 cache and keeps L1 cache
			System.out.println(prod2);
			System.out.println("__________________");
			ses.clear(); //removes all from L1 cache
			Cache cache=factory.getCache();
			cache.evictAll(); //emptying L2 cache
			Product prod3=ses.get(Product.class, 25);  //gets from DB and keeps  in L2,L1 caches
			System.out.println(prod3);
		}//try
		catch(HibernateException he) {
			he.printStackTrace();
		}
		
	}//main
}//class
