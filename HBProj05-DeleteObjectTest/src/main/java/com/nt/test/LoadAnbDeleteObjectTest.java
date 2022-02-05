package com.nt.test;


import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

import com.nt.entity.Product;

public class LoadAnbDeleteObjectTest {

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
			  //Load object
			  Product  prod=ses.get(Product.class, 1002);
			  if(prod==null){
				    System.out.println("Record not found to delete");
				    return;
			   }
			  else {
			  // begin Tx
			 tx=ses.beginTransaction();
			       ses.delete(prod);
               //Commit the Tx
			        tx.commit();
			        System.out.println(" object is deleted");
			  }//else
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
