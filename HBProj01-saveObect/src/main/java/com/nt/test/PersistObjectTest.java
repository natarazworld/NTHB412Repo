package com.nt.test;

import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

import com.nt.entity.Product;

public class PersistObjectTest {

	public static void main(String[] args) {
		//Bootstarp / Activate the hibernate
		Configuration cfg=new Configuration();
		cfg.configure("com/nt/cfgs/hibernate.cfg.xml");
        //build SessionFactory having all services specified in cfg file and  mapping file
		SessionFactory factory=cfg.buildSessionFactory();
		// create Session obj 
		Session ses=factory.openSession();
		Transaction tx=null;
		try {
			// begin Transaction
			   tx=ses.beginTransaction();  //internally calls  con.setAutoCommit(false) to disable autoCommit mode on Db s/w
			      //prepare entity object
			        Product prod=new Product();
			        //prod.setPid(345);
			        prod.setPname("spoon"); prod.setPrice(35678.5f);
			        prod.setQty(2.0f); 
                 //save object 
			    ses.persist(prod); // Gives persistence instruction to hibernate to save object (insert object data as the record)
              tx.commit();  // internally calls con.commit() method to make insertion executin result perminent
               System.out.println("Object is saved(Record is inserted)");
		}
		catch(HibernateException he) {
			he.printStackTrace();
			tx.rollback();   //internally calls con.rollback() method to rollback the results of  query execution.
			System.out.println("Object is not saved(Record is not inserted)");
		}
		
		//close Session obj
		ses.close();
		//close SesssionFactory obj
		factory.close(); 
	}//main
}//class
