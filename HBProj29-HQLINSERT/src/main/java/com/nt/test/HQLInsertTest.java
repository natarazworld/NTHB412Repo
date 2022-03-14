//HQLInsertTest.java
package com.nt.test;

import java.util.List;

import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.query.Query;

import com.nt.entity.Product;
import com.nt.utility.HibernateUtil;


public class HQLInsertTest {

	public static void main(String[] args) {
		SessionFactory factory=HibernateUtil.getSessionFactory();
		Session ses=HibernateUtil.getSession();
		
		Transaction tx=null;
		try(factory;ses){
			tx=ses.beginTransaction();
			Query query=ses.createQuery("INSERT INTO SpecialProduct(pid,pname,price,qty) SELECT p.pid,p.pname,p.price,p.qty from Product as p WHERE p.price>=:min ");
			query.setParameter("min", 20000.0f);
			int count=query.executeUpdate();
			tx.commit();
			System.out.println("no.of records that are copied::"+ count);
		}
		catch(HibernateException he) {
			he.printStackTrace();
			if(tx!=null && tx.getStatus()!=null && tx.getRollbackOnly()) {
				tx.rollback();
				System.out.println("Problem in HQL INSERT Query execution ");
			}
		}
	}//main
}//class
