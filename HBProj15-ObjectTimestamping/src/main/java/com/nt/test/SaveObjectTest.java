package com.nt.test;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;

import com.nt.entity.Stock;
import com.nt.utility.HibernateUtil;

public class SaveObjectTest {

	public static void main(String[] args) {
		//get SessionFactory
		SessionFactory factory=HibernateUtil.getSessionFactory();
		//get Session
		Session ses=factory.openSession();
		Transaction tx=null;
		try(factory;ses){
			//begin Tx
			tx=ses.beginTransaction();
			   //prepare object
			     Stock stock=new Stock("TCS",56.77,"BSE");
			     int idVal=(Integer)ses.save(stock);
              tx.commit();
              System.out.println("Object/record is saved with the id value::"+idVal);
              System.out.println("Object/record is saved at::"+stock.getLastUpdated());
		}//try
		catch(Exception e) {
			if(tx!=null && tx.getStatus()!=null && tx.getRollbackOnly()) {
				tx.rollback();
				System.out.println("Object is not saved");
			}
				
		}//catch
	}//main
}//class
