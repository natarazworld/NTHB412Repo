//HQLSelectTest1.java
package com.nt.test;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;

import com.nt.entity.Product;
import com.nt.utility.HibernateUtil;


public class HQLSelectTest1 {

	public static void main(String[] args) {
		SessionFactory factory=HibernateUtil.getSessionFactory();
		Session ses=HibernateUtil.getSession();
		
		try(factory;ses){
			 //prepare Query object having HQL/JPQL Query
			Query query=ses.createQuery("from  Product");
			List<Product>  list=query.list();  //execute the HQL Query
		/*	//process the Result
				list.forEach(prod->{            //java 8  forEach(-) method
					System.out.println(prod);
				});*/
		}
		catch(Exception e) {
			e.printStackTrace();
		}
			//list.forEach(System.out::println);   //java8  forEach(-) method + method reference
			/*for(Product p:list) {  // enhanced for loop
				System.out.println(p);
			}*/ 
			
			//Executing  HQL/JPQL Query   lazily using query.iterate() method
/*		try {
			Query query=ses.createQuery("from Product");
			Iterator<Product> it=query.iterate();
			while(it.hasNext()) {
				Product prod=it.next();
				System.out.println(prod.getPid()+"  "+prod.getPname()+"  "+prod.getPrice()+"  "+prod.getQty());
			}
		}  */   //try 
		
	

	}

}
