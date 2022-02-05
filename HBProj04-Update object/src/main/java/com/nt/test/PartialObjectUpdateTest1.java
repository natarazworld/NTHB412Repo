package com.nt.test;


import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;
import com.nt.entity.Product;

public class PartialObjectUpdateTest1 {

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
			   //load object
			 Product p=ses.get(Product.class, 1001);
			 if(p==null) {
				 System.out.println("record not found");
				 return;
			 }
			 else {
			  // begin Tx
			 tx=ses.beginTransaction();
			     //modify the object partially
			      p.setPrice(1566.0f);
               //Commit the Tx
			        tx.commit();
			        System.out.println("Parital object is  updated");
			 }//else
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
