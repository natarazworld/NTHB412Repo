//HQLSelectTest1.java
package com.nt.test;

import java.util.List;

import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.internal.build.AllowSysOut;
import org.hibernate.query.Query;

import com.nt.entity.Product;
import com.nt.utility.HibernateUtil;


public class HQLSelectTest2 {

	public static void main(String[] args) {
		SessionFactory factory=HibernateUtil.getSessionFactory();
		Session ses=HibernateUtil.getSession();
		
		try(factory;ses){
			/*	 //prepare Query object having HQL/JPQL Query
				Query query=ses.createQuery("from  Product where pid>=?11 and pid<=?10");
				//set query param values
				query.setParameter(11, 20);
				query.setParameter(10, 25);
				 //execute the HQL Query
				List<Product>  list=query.list();
				//proess the Result
				list.forEach(prod->{
					System.out.println(prod);
				});*/
			
			// HQL/JPL Query With Named Parameters
			Query query=ses.createQuery("from  Product where pname in(?1,:prod2,?2) order by  pname asc");
			//set values to named parameeters
			 query.setParameter(1,"sofa");
			 query.setParameter("prod2","chair");
			 query.setParameter(2,"table1");
			 
			 //execute  the query
            List<Product> list=query.list();
            //process the Result
            list.forEach(prod->{
            	System.out.println(prod);
            });
			
		} //try
		catch(HibernateException he) {
			he.printStackTrace();
		}

	}//main
}//class
