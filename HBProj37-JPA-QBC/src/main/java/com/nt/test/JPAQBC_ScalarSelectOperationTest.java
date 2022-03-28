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

public class JPAQBC_ScalarSelectOperationTest {

	public static void main(String[] args) {
		SessionFactory factory=HibernateUtil.getSessionFactory();
		Session ses=HibernateUtil.getSession();
		Transaction tx=null;
		try(factory;ses){
			/*//create CriteriaBuilder obj
			CriteriaBuilder ctBuilder=ses.getCriteriaBuilder();
			//create CriteriaQuery object
			CriteriaQuery<Object[]> ctQuery=ctBuilder.createQuery(Object[].class);
			// create Root object specifying the from operation
			Root<Product> root=ctQuery.from(Product.class);  // from Product
			// specify specific multiple cols and where clause conditions
			ctQuery.multiselect(root.get("pid"),root.get("pname")).where(ctBuilder.and(ctBuilder.ge(root.get("price"), 5000.0f),
				                                                                                                                ctBuilder.le(root.get("price"),20000.0f))).orderBy(ctBuilder.asc(root.get("pname")));
			       //select pid,pname  from Product where price>=5000  and price<=20000 order by pname asc
			
			//  create Query object having CriteriaQuery object
			Query query=ses.createQuery(ctQuery);
			//execute the QBC  logic
			List<Object[]> list=query.getResultList();
			//process the result
			list.forEach(row->{
			  for(Object val:row) {
				  System.out.print(val+" ");
			  }
			  System.out.println();
			});*/
			
			
			/*	//create CriteriaBuilder obj
				CriteriaBuilder ctBuilder=ses.getCriteriaBuilder();
				//create CriteriaQuery object
				CriteriaQuery<String> ctQuery=ctBuilder.createQuery(String.class);
				// create Root object specifying the from operation
				Root<Product> root=ctQuery.from(Product.class);  // from Product
				// specify specific multiple cols and where clause conditions
				ctQuery.multiselect(root.get("pname")).where(ctBuilder.like(root.get("pname"),"s%"));
				       //selectpname  from Product where pname like 's%'
				
				//  create Query object having CriteriaQuery object
				Query query=ses.createQuery(ctQuery);
				//execute the QBC  logic
				List<String> list=query.getResultList();
				//process the result
				list.forEach(System.out::println);*/
			
			/*			//create CriteriaBuilder obj
						CriteriaBuilder ctBuilder=ses.getCriteriaBuilder();
						//create CriteriaQuery object
						CriteriaQuery<Long> ctQuery=ctBuilder.createQuery(Long.class);
						// create Root object specifying the from operation
						Root<Product> root=ctQuery.from(Product.class);  // from Product
						// specify specific multiple cols and where clause conditions
						ctQuery.multiselect(ctBuilder.count(root.get("pid")));
						       //select count(pid)  from Product 
						//  create Query object having CriteriaQuery object
						Query query=ses.createQuery(ctQuery);
						//execute the QBC  logic
			  Long count=(Long) query.getSingleResult();
						//process the result
						System.out.println("count of records ::"+count);
			*/			
			
			/*//create CriteriaBuilder obj
			CriteriaBuilder ctBuilder=ses.getCriteriaBuilder();
			//create CriteriaQuery object
			CriteriaQuery<Object[]> ctQuery=ctBuilder.createQuery(Object[].class);
			// create Root object specifying the from operation
			Root<Product> root=ctQuery.from(Product.class);  // from Product
			// specify specific multiple cols and where clause conditions
			ctQuery.multiselect(ctBuilder.count(root.get("pid")),
					                            ctBuilder.sum(root.get("price")),
					                            ctBuilder.avg(root.get("price")),
					                            ctBuilder.max(root.get("price")),
					                            ctBuilder.min(root.get("price")));
			       //select count(pid)  from Product 
			//  create Query object having CriteriaQuery object
			Query query=ses.createQuery(ctQuery);
			//execute the QBC  logic
			  Object result[]=(Object[])query.getSingleResult();
			//process the result
			System.out.println("count of records:"+result[0]);
			System.out.println("sum of prices:"+result[1]);
			System.out.println("avg of prices:"+result[2]);
			System.out.println("max  price value:"+result[3]);
			System.out.println("min  price value:"+result[4]);
			*/
			
			//create CriteriaBuilder obj
			CriteriaBuilder ctBuilder=ses.getCriteriaBuilder();
			//create CriteriaQuery object
			CriteriaQuery<Product> ctQuery=ctBuilder.createQuery(Product.class);
			// create Root object specifying the from operation
			Root<Product> root=ctQuery.from(Product.class);  // from Product
			//  create Query object having CriteriaQuery object
			Query query=ses.createQuery(ctQuery);
			  //perform pagination activities
			  query.setFirstResult(0);
			  query.setMaxResults(3);
		    //process the Result
			  List<Product> list=query.getResultList();
			  list.forEach(prod->{
				  System.out.println(prod);
			  });
		}//try
		catch(Exception e) {
			e.printStackTrace();
		}//catch
	}//main
}//class
