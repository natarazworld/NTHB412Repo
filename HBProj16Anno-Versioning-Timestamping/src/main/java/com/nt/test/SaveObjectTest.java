package com.nt.test;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;

import com.nt.entity.CallerTune;
import com.nt.utility.HibernateUtil;

public class SaveObjectTest {

	public static void main(String[] args) {
		//get SessionFactory object
		SessionFactory factory=HibernateUtil.getSessionFactory();
		//get Session object
		Session ses=factory.openSession();
		Transaction tx=null;
		try(factory;ses){
			//begin Tx
			tx=ses.beginTransaction();
			   //prepare object
			    CallerTune tune=new CallerTune();
			    tune.setTuneName("srivalli");
			    tune.setMovieName("pushpa- The raise");
			   //save object
			    ses.save(tune);
			 tx.commit();
			 System.out.println("Object is saved at::"+tune.getLaunchTime());
		}//try
		catch(Exception e) {
			if(tx!=null || tx.getStatus()!=null || tx.getRollbackOnly()) {
				  tx.rollback();
				  System.out.println("Object is not saved");
			}//if
		}//catch
	}//main
}//class
