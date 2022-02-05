// SaveOrUpdateObjectTest.java
package com.nt.test;


import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

import com.nt.entity.Product;

public class SaveOrUpdateObjectTest1 {

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
			       p.setPid(4001); 
			       p.setPname("chair");
			       p.setPrice(13000.0f);
			       p.setQty(15.0f);
			       
			       //save or update the obejct
			       ses.saveOrUpdate(p);
			       
               //Commit the Tx
			        tx.commit();
			        System.out.println(" object saved or  updated");
		}//try
		catch(Exception e) {
			if(tx!=null && tx.getStatus()!=null  && tx.getRollbackOnly()) {
				  tx.rollback();
				  System.out.println("Object is not saved or updated");
			}
			e.printStackTrace();
		}//catch
		
	}//main
}//class
