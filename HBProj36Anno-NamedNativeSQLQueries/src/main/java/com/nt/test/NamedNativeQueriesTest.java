//NamedNativeQueriesTest.java
package com.nt.test;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.query.NativeQuery;

import com.nt.entity.Product;
import com.nt.utility.HibernateUtil;

public class NamedNativeQueriesTest {

	public static void main(String[] args) {
		SessionFactory factory=HibernateUtil.getSessionFactory();
		Session ses=HibernateUtil.getSession();
		Transaction tx=null;
		try(factory;ses){
			//get access Named Native SQL Query1
			NativeQuery query1=ses.getNamedNativeQuery("GET_PRODS_BY_PRICE_RANGE");
			//map  Entity query results with Entity query
			query1.addEntity(Product.class);
			//set values to query params
			query1.setParameter(1,1000.0f);
			query1.setParameter(2,50000.0f);
			//execute the Query
			List<Product> list=query1.getResultList();
			//process the Result
			list.forEach(prod->{
				System.out.println(prod);
			});
			System.out.println("====================================");
			//begin the Tx
			tx=ses.beginTransaction();
			//get access Named Native SQL Query2
			 NativeQuery query2=ses.getNamedNativeQuery("HIKE_PRICE_BY_PROD_NAME");
			 //set query param values
			 query2.setParameter(1,200.0f);
			 query2.setParameter(2,"sofa");
			 //execute the qyery
			 int count=query2.executeUpdate();
			 System.out.println("no.of records that are effected are ::"+count);
            //commit the Tx
			 tx.commit();
		}//try
		catch(Exception e) {
			e.printStackTrace();
			if(tx!=null && tx.getStatus()!=null && tx.getRollbackOnly()) {
			   System.out.println("Problem in Query execution");
				tx.rollback();
			}//if
		}//catch
		
	}//main
}//class
