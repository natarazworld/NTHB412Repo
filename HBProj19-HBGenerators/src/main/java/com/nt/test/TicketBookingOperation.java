package com.nt.test;

import org.hibernate.Session;
import org.hibernate.Transaction;

import com.nt.entity.Product;
import com.nt.utility.HibernateUtil;

public class TicketBookingOperation implements Runnable {

	@Override
	public void run() {
		 //get Session
		Session ses=HibernateUtil.getSession();
		Transaction tx=null;
		try(ses){
			 //begin Tx
			tx=ses.beginTransaction();
			Product prod=new Product();
			prod.setPname("table"); prod.setPrice(90000.0f);
			prod.setQty(67.88f);
			  int idVal=(Integer)ses.save(prod);
			  System.out.println("Generated id value ::"+idVal);
			tx.commit();
			System.out.println("Object is saved");
		}
		catch(Exception e) {
			if(tx!=null && tx.getStatus()!=null && tx.getRollbackOnly()) {
				 tx.rollback();
				 System.out.println("Object is not saved");
			}//if
				
		}//catch
	}
}
