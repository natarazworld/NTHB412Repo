//JPAQBC_SelectOperationTest.java
package com.nt.test;

import java.util.List;

import javax.persistence.Query;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;

import com.nt.entity.Product;
import com.nt.utility.HibernateUtil;

public class JPAQBC_SelectOperationTest {

	public static void main(String[] args) {
		SessionFactory factory=HibernateUtil.getSessionFactory();
		Session ses=HibernateUtil.getSession();
		Transaction tx=null;
		try(factory;ses){
			/*	//create CriteriaBuilder obj
				CriteriaBuilder ctBuilder=ses.getCriteriaBuilder();
				//create CriteriaQuery object
			  CriteriaQuery<Product> ctQuery=ctBuilder.createQuery(Product.class);
			   // create Root object specifying the from operation
			 Root<Product> root=ctQuery.from(Product.class);  //select * from Product
			   //  create Query object having CriteriaQuery object
			 Query query=ses.createQuery(ctQuery);
			 //execute the QBC  logic
			 List<Product> list=query.getResultList();
			 //process the result
			 list.forEach(System.out::println);*/
			
			/*	//create CriteriaBuilder obj
				CriteriaBuilder ctBuilder=ses.getCriteriaBuilder();
				//create CriteriaQuery object
			  CriteriaQuery<Product> ctQuery=ctBuilder.createQuery(Product.class);
			   // create Root object specifying the from operation
				 Root<Product> root=ctQuery.from(Product.class);  //select * from Product
				//  apply  where clause condition
				 ctQuery.select(root).where(ctBuilder.and(ctBuilder.ge(root.get("price"), 5000.0f),
						                                                                   ctBuilder.le(root.get("price"),20000.0f)));
				 //prepare Query object having CriterQuery obj
				 Query query=ses.createQuery(ctQuery);
				 //execute  the QBC logics
				 List<Product> list=query.getResultList();
				 //process the Result
				 list.forEach(System.out::println);*/
			
			/*	//create CriteriaBuilder obj
				CriteriaBuilder ctBuilder=ses.getCriteriaBuilder();
				//create CriteriaQuery object
			  CriteriaQuery<Product> ctQuery=ctBuilder.createQuery(Product.class);
			   // create Root object specifying the from operation
				 Root<Product> root=ctQuery.from(Product.class);  //select * from Product
				 //apply where clause condition
				 ctQuery.select(root).where(root.get("pname").in("table","sofa","chair")).orderBy(ctBuilder.asc(root.get("price")));
				                                                                       //adds  pname in ('table','soft','chair') order By price asc
				 //prepare Query object having CriterQuery obj
				 Query query=ses.createQuery(ctQuery);
				 //execute  the QBC logics
				 List<Product> list=query.getResultList();
				 //process the Result
				 list.forEach(System.out::println);*/
			
			
			//create CriteriaBuilder obj
			CriteriaBuilder ctBuilder=ses.getCriteriaBuilder();
			//create CriteriaQuery object
		  CriteriaQuery<Product> ctQuery=ctBuilder.createQuery(Product.class);
		   // create Root object specifying the from operation
			 Root<Product> root=ctQuery.from(Product.class);  //select * from Product
			//apply where clause condition
			 ctQuery.select(root).where(ctBuilder.like(root.get("pname"), "s%"));
			 //prepare Query object having CriterQuery obj
			 Query query=ses.createQuery(ctQuery);
			 //execute  the QBC logics
			 List<Product> list=query.getResultList();
			 //process the Result
			 list.forEach(System.out::println);
			
		}//try
		catch(Exception e) {
			e.printStackTrace();
		}//catch
	}//main
}//class
