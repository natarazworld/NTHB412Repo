package com.nt.test;


import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;
import com.nt.entity.Product;

public class ObjectReloadTest {

	public static void main(String[] args) {
		//Configutration obj
		Configuration cfg=new Configuration();
		cfg.configure("com/nt/cfgs/hibernate.cfg.xml");
		//build SEssionFactory obj
		SessionFactory factory=cfg.buildSessionFactory();
		//build Session
		Session ses=factory.openSession();
		try(factory;ses){  //try with resource
			   //load object
			 Product p=ses.get(Product.class, 1001);
			 if(p==null) {
				 System.out.println("record not found");
				 return;
			 }
			 else {
				 //display record
				 System.out.println(p);
				 System.out.println("App going into sleep state.....");
				 Thread.sleep(30000);  //sleep the app for 30 ms
				    // During this sleep time modify the db table record
				 ses.refresh(p);  //reloads the object data from db table record
				 System.out.println(p);
			 }//else
		}//try
		catch(Exception e) {
			e.printStackTrace();
		}//catch
		
	}//main
}//class
