//SaveObjectTest.java
package com.nt.test;

import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;

import com.nt.entity.Product;
import com.nt.utility.HibernateUtil;

public class SaveObjectTest {

	public static void main(String[] args) {
		
		//get SessionFactory object
		SessionFactory factory=HibernateUtil.getSessionFactory();
		//get Session
		Session ses=HibernateUtil.getSession();
		
		Transaction tx=null;
		try{
			// begin Transaction
			   tx=ses.beginTransaction();  //internally calls  con.setAutoCommit(false) to disable autoCommit mode on Db s/w
			      //prepare entity object
			        Product prod=new Product();
			        prod.setPname("table1"); prod.setPrice(1368.5f);
			        prod.setQty(12.0f); 
                 //save object 
			   Integer idVal=  (Integer) ses.save(prod); // Gives persistence instruction to hibernate to save object (insert object data as the record)
			   System.out.println("The Generated id value ::"+idVal);
              tx.commit();  // internally calls con.commit() method to make insertion executin result perminent
               System.out.println("Object is saved(Record is inserted)");
			}///try
		catch(HibernateException he) {
		he.printStackTrace();
			 tx.rollback();   //internally calls con.rollback() method to rollback the results of  query execution.
			  System.out.println("Object is not saved(Record is not inserted)");
		}//catch
		finally {
			ses.close();
			factory.close();
		}
		
	}//main
}//class
