package com.nt.test;

import java.util.Arrays;

import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

import com.nt.entity.Product;

public class DeleteObjectTest {

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
			       p.setPid(1001);  // must be existing id
			         //only  id property value is sufficient .. no need of
			         // placing other property values
			      //instruct  to delete the object
			       ses.delete(p);
               //Commit the Tx
			        tx.commit();
			        System.out.println(" object is deleted");
		}//try
		catch(Exception e) {
			if(tx!=null && tx.getStatus()!=null  && tx.getRollbackOnly()) {
				  tx.rollback();
				  System.out.println("Object is not deleted");
			}
			e.printStackTrace();
		}//catch
		
	}//main
}//class
