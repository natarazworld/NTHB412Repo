package com.nt.test;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;

import com.nt.entity.CallerTune;
import com.nt.utility.HibernateUtil;

public class UpdateObjectTest {

	public static void main(String[] args) {
		//get SessionFactory object
		SessionFactory factory=HibernateUtil.getSessionFactory();
		//get Session object
		Session ses=factory.openSession();
		Transaction tx=null;
		try(factory;ses){
			//Load object
			  CallerTune tune=ses.get(CallerTune.class, 22);
			  if(tune==null) {
				  System.out.println("record not found");
				  return;
			  }
			  else {
			//begin Tx
			tx=ses.beginTransaction();
			   //update object
			      tune.setTuneName("sami sami ..");
			     ses.update(tune);
			 tx.commit();
			 System.out.println("Object is updated for   ..."+tune.getUpdationCount()+".. times");
			 System.out.println("Object is lastly update at::"+tune.getLastUpdationTime());
			 }//else
		}//try
		catch(Exception e) {
			if(tx!=null || tx.getStatus()!=null || tx.getRollbackOnly()) {
				  tx.rollback();
				  System.out.println("Object is not updated");
			}//if
		}//catch
	}//main
}//class
