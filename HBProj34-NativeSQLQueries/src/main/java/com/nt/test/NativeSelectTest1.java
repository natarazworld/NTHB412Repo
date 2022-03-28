//NativeSelectTest1.java
package com.nt.test;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.internal.build.AllowSysOut;
import org.hibernate.query.NativeQuery;
import org.hibernate.type.StandardBasicTypes;

import com.nt.entity.Product;
import com.nt.utility.HibernateUtil;

public class NativeSelectTest1 {

	public static void main(String[] args) {
		SessionFactory factory=HibernateUtil.getSessionFactory();
		Session ses=HibernateUtil.getSession();
		
		try(factory;ses){
			 //Entity Query
			/*
			  NativeQuery query=ses.createNativeQuery("SELECT *  FROM PRODUCT");
			query.addEntity(Product.class);
			List<Product> list=query.getResultList();
			list.forEach(prod->{
				System.out.println(prod.getPid()+"  "+prod.getPname()+"  "+prod.getPrice()+"  "+prod.getQty());
			});*/
			  //Entity query
			/*	NativeQuery query=ses.createNativeQuery("SELECT *  FROM PRODUCT");
				List<Object[]> list=query.getResultList();
				list.forEach(record->{
					for(Object val:record) {
						System.out.print(val+"  ");
					}//for
					System.out.println();
				});
				*/
			
			/*//Scalar Query (getting specific multiple col values)
			 NativeQuery query=ses.createNativeQuery("SELECT PID,PRICE FROM PRODUCT WHERE PRICE BETWEEN ? AND ? ");
			 //map scalar query results with hiberate  data types
			 query.addScalar("PID",StandardBasicTypes.INTEGER);
			 query.addScalar("PRICE",StandardBasicTypes.FLOAT);
			// set query param values
			  query.setParameter(1,1000.0f);
			  query.setParameter(2, 50000.0f);
			//execute the Query
			  List<Object[]> list=query.getResultList();
			  list.forEach(row->{
				  for(Object val:row) {
					  System.out.print(val+" ");
				  }//for
				  System.out.println();
			  });*/
			
			
			/*	//Scalar Query (getting specific single  col values)
				 NativeQuery query=ses.createNativeQuery("SELECT PID FROM PRODUCT WHERE QTY>=?1");
				 //map scalar query results with hiberate  data types
				 query.addScalar("PID",StandardBasicTypes.INTEGER);
				// set query param values
				  query.setParameter(1,20);
				//execute the Query
				  List<Integer> list=query.getResultList();
				  list.forEach(id->{
					  System.out.println(id);
				  });*/
			
			//Native SQL Entity query  with named params
			 NativeQuery  query=ses.createNativeQuery("SELECT * FROM PRODUCT  WHERE PRICE>=:priceRange  AND QTY>=:qtyRange");
			 // map entity query results with Entity class
			 query.addEntity(Product.class);
			 //set query param values
			 query.setParameter("priceRange", 10000.0);
			 query.setParameter("qtyRange", 20.0);
			 //execute the Query
			 List<Product> list=query.getResultList();
			 //process the Results
			 list.forEach(prod->{
				 System.out.println(prod);
			 });
		}//try
		catch(Exception e) {
			e.printStackTrace();
		}
		
	}//main
}//class
