package com.nt.test;

import java.util.Arrays;

import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import com.nt.entity.IProduct;
import com.nt.entity.Product;

public class LoadObjectTestUsingLoadMethod {

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
			 IProduct prod=ses.load(Product.class, 1452);
			 System.out.println(prod.getClass()+"  "+prod.getClass().getSuperclass()+"  "+Arrays.toString(prod.getClass().getInterfaces()));
				/*System.out.println("---------------------");
				System.out.println(prod.getPid()+"  "+prod.getPname()+"  "+prod.getPrice()+"  "+prod.getQty());*/
		}//try
		catch(HibernateException he) {
			System.out.println("Record not found");
			he.printStackTrace();
		}
		
	}//main
}//class
