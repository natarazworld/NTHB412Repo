package com.nt.test;

import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

import com.nt.entity.Product;

public class SaveObjectTestUsingTWR2 {

	public static void main(String[] args) {
		//Bootstarp / Activate the hibernate
		Configuration cfg=new Configuration();
		//specify the  hibernate cfg file name and location
		cfg.configure("com/nt/cfgs/hibernate.cfg.xml");
        //build SessionFactory having all services specified in cfg file and  mapping file
		SessionFactory factory=cfg.buildSessionFactory();
		// create Session obj 
      Session ses=factory.openSession();
		Transaction tx=null;
		try(factory;ses){   //form java 9
			// begin Transaction
			   tx=ses.beginTransaction();  
			      //prepare entity object
			        Product prod=new Product();
			        prod.setPid(1234);
			        prod.setPname("spoon"); //prod.setPrice(35678.5f);
			       // prod.setQty(2.0f); 
                 //save object 
			   Integer idVal=  (Integer) ses.save(prod); // save obj
			   System.out.println("The Generated id value ::"+idVal);
			   tx.commit();
			   System.out.println("Object is saved");
		} // The SessionFactory, SEsssion objs will be closed here automatically
		catch(HibernateException he) {
			he.printStackTrace();
			if(tx!=null && tx.getRollbackOnly() && tx.getStatus()!=null) {
				 tx.rollback();
				 System.out.println("Obj is not saved");
			}
		}
		
	}//main
}//class
