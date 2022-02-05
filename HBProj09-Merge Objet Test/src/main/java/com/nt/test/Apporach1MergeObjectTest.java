package com.nt.test;

import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;

import com.nt.entity.Product;
import com.nt.utility.HibernateUtil;

public class Apporach1MergeObjectTest {

	public static void main(String[] args) {
		//get SessionFactory object
		SessionFactory factory=HibernateUtil.getSessionFactory();
		//get SEssion object
		Session ses=HibernateUtil.getSession();
		Transaction tx=null;
		try(factory;ses){  //try with resource
			  //being Transaction
			  tx=ses.beginTransaction();
			     Product prod=new Product();
			    prod.setPid(1001);
			    prod.setPname("table5");
			    prod.setPrice(456.0f);
			    prod.setQty(56.0f);
			    Product prod1=(Product) ses.merge(prod);
			    tx.commit();
			    System.out.println("Given obejct  data "+prod+" hashCode::"+prod.hashCode());
			    System.out.println("Recived obejct  data "+prod1+" hashCode::"+prod1.hashCode());
			    System.out.println("Object is saved  or updated");
		}//try
		catch(HibernateException he) {
			if(tx!=null  || tx.getStatus()!=null || tx.getRollbackOnly()) {
				 tx.rollback();
				 System.out.println("Object is not saved  or not updated");
			}
			he.printStackTrace();
		}
		
	}//main
}//class
