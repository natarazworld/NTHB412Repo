//HQLNon_SelectTest.java
package com.nt.test;

import java.util.List;

import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.query.Query;

import com.nt.entity.Product;
import com.nt.utility.HibernateUtil;


public class HQLNon_SelectTest {

	public static void main(String[] args) {
		SessionFactory factory=HibernateUtil.getSessionFactory();
		Session ses=HibernateUtil.getSession();
		
		Transaction tx=null;
		try(factory;ses){
			tx=ses.beginTransaction();
			 Query query=ses.createQuery("delete from Product where qty<=:value");
			 query.setParameter("value", 25.0f);
			 int count=query.executeUpdate();
			 tx.commit();
			 System.out.println("no.of records that are effected::"+count);
		}
		catch(HibernateException he) {
			he.printStackTrace();
		}
	}//main
}//class
