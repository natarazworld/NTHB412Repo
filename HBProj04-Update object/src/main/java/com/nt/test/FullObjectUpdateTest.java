package com.nt.test;

import java.util.Arrays;

import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

import com.nt.entity.Product;

public class FullObjectUpdateTest {

	public static void main(String[] args) {
		//Configutration obj
		Configuration cfg=new Configuration();
		cfg.configure("com/nt/cfgs/hibernate.cfg.xml");
		//build SEssionFactory obj
		SessionFactory factory=cfg.buildSessionFactory();
		//build Session
		Session ses=factory.openSession();
		Transaction  tx=null;
		try(factory;ses){  //try with resource
			  // begin Tx
			 tx=ses.beginTransaction();
			     //prepare object for Entity class
			       Product p=new Product();
			       p.setPid(1211);  // must be existing id
			       p.setPname("launge1"); //new value
			       p.setPrice(4567.0f); //new value
			       p.setQty(45.4f); //new vlaue
			      //instructio  to update object
			       ses.update(p);
               //Commit the Tx
			        tx.commit();
			        System.out.println("Full object is  objected");
		}//try
		catch(Exception e) {
			if(tx!=null && tx.getStatus()!=null  && tx.getRollbackOnly()) {
				  tx.rollback();
				  System.out.println("Object is not updated");
			}
			e.printStackTrace();
		}//catch
		
	}//main
}//class
