package com.nt.test;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;

import com.nt.entity.Stock;
import com.nt.utility.HibernateUtil;

public class LoadObjectTest {

	public static void main(String[] args) {
		//get SessionFactory
		SessionFactory factory=HibernateUtil.getSessionFactory();
		//get Session
		Session ses=factory.openSession();
		Transaction tx=null;
		try(factory;ses){
			//Load object
			Stock stock=ses.get(Stock.class, 1);
			if(stock==null) {
				System.out.println("Stock not found");
				return ;
			}
			else {
				//begin Tx 
				 tx=ses.beginTransaction();
                   // modify the loaded object
				  stock.setPrice(66.88);
				  ses.update(stock);
				tx.commit();
				System.out.println("Object/record is lastly updated at:: "+stock.getLastUpdated());
			}
		}//try
		catch(Exception e) {
			if(tx!=null && tx.getStatus()!=null && tx.getRollbackOnly()) {
				tx.rollback();
				System.out.println("Object is not updated");
			}
				
		}//catch
	}//main
}//class
