package com.nt.test;

import java.util.List;

import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.query.Query;

import com.nt.entity.Product;
import com.nt.utility.HibernateUtil;

public class PaginationTest {

	public static void main(String[] args) {
		//get SessionFactory obj
		SessionFactory factory=HibernateUtil.getSessionFactory();
		//get Session obj
		Session ses=HibernateUtil.getSession();
		Transaction tx=null;
		try {
		   //create  HQL Query 
			  Query query=ses.createQuery("from Product");
			  query.setFirstResult(9);  //start Pos
			  query.setMaxResults(3);  //page Size
			  //execute the query
			  List<Product> list=query.getResultList();			  
			  //process the Result
			  list.forEach(System.out::println);
		}//try
		catch(HibernateException he) {
			he.printStackTrace();
		}//catch
		
	}//main
}//class
