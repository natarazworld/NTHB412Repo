package com.nt.test;

import java.util.List;
import java.util.Scanner;

import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;

import com.nt.entity.Product;
import com.nt.utility.HibernateUtil;

public class PaginationTest1 {

	public static void main(String[] args) {
		//read inputs  from enduser 
		 Scanner sc=new Scanner(System.in);
		 System.out.println("Enter PageSize::");
		 int pageSize=sc.nextInt();
		 
		//get SessionFactory obj
		SessionFactory factory=HibernateUtil.getSessionFactory();
		//get Session obj
		Session ses=HibernateUtil.getSession();
		try {
			//get  total recods in the db table
			  Query query1=ses.createQuery("select count(*) from Product");
			  long totalRecords=(long) query1.getSingleResult();
			  long pagesCount=totalRecords/pageSize;
			    if(totalRecords%pageSize!=0)
			    	   pagesCount++;
			    
		   //create  HQL Query for pagination 
			  Query query2=ses.createQuery("from Product");
			   for(int pageNo=1;pageNo<=pagesCount;++pageNo) {
				   System.out.println(pageNo+"/"+pagesCount+" page records ");
				    //get startPosition for each page
				   int startPosition=(pageNo*pageSize)-pageSize;
				   // set pagination params
				   query2.setFirstResult(startPosition);
				   query2.setMaxResults(pageSize);
				   //execute the Query
				   List<Product> list=query2.getResultList();
                    list.forEach(System.out::println);
                    System.out.println("--------------------------");
			   }//for
		}//try
		catch(HibernateException he) {
			he.printStackTrace();
		}//catch
		
	}//main
}//class
