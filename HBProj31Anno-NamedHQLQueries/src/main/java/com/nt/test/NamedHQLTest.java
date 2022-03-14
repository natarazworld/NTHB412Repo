package com.nt.test;

import java.util.List;

import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.query.Query;

import com.nt.entity.Product;
import com.nt.utility.HibernateUtil;

public class NamedHQLTest {

	public static void main(String[] args) {
		//get SessionFactory obj
		SessionFactory factory=HibernateUtil.getSessionFactory();
		//get Session obj
		Session ses=HibernateUtil.getSession();
		Transaction tx=null;
		try {
		   //get Access Named HQL Select Query 
			  Query query=ses.getNamedQuery("HQL_GET_PRODUCTS_BY_PRICE_RANGE");
			  //set values to query params
			  query.setParameter("min", 1000.0f);
			  query.setParameter("max",50000.0f);
			  //execute the query
			  List<Product> list=query.getResultList();			  
			  //process the Result
			  list.forEach(System.out::println);
			  //begin Tx
			    tx=ses.beginTransaction();
			   //get Access Named HQL Non-Select Query 
				  Query query1=ses.getNamedQuery("INCREASE_PRODUCT_PRICE_BY_PRICE_RANGE");
				  //set param values
				  query1.setParameter("newValue", 2000.0f);
				  query1.setParameter("range",40000.0f);
				  //execute the query
				 int count=query1.executeUpdate();
				 System.out.println(" no.of record that are effected::"+count);
                //commit tx
				 tx.commit();
		}//try
		catch(HibernateException he) {
			he.printStackTrace();
			if(tx!=null && tx.getStatus()!=null && tx.getRollbackOnly()) {
				  tx.rollback();
				  System.out.println("problem in executing non-select HQL query");
			}
		}//catch
		

	}//main
}//class
