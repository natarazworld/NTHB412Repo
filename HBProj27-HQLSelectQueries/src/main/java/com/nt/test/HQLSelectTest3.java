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


public class HQLSelectTest3 {

	public static void main(String[] args) {
		SessionFactory factory=HibernateUtil.getSessionFactory();
		Session ses=HibernateUtil.getSession();
		try(factory;ses){
			/*	//executing HQL scalar select Query (retrieving specific multiple col values)
				Query query=ses.createQuery("select pid,pname,price  from Product where  price>=:min and price<=:max");
				query.setParameter("min", 1000.0f);
				query.setParameter("max",30000.0f);
				List<Object[]> list=query.list();
				list.forEach(row->{
					for(Object val:row) {
						System.out.print(val+ "  ");
					}
				   	System.out.println();	
				});
			
			System.out.println("------------------------------------------");
			//executing HQL scalar select Query (retrieving specific single  col value)
			Query query1=ses.createQuery("select pname  from Product where  qty>=:min and qty<=:max");
			query1.setParameter("min", 10.0f);
			query1.setParameter("max", 20.0f);
			List<String> list1=query1.list();
			list1.forEach(name->{
				System.out.println(name);
			});*/
			
			/*	//executing HQL Entity select Query giving single record
				Query query2=ses.createQuery(" from Product where pid=:id");
				query2.setParameter("id", 25);
				Product prod=(Product) query2.getSingleResult();
				if(prod==null)
					System.out.println("Record not found");
				else {
					System.out.println("Record found");
					System.out.println(prod);
				}*/
			
			/*			//executing HQL scalar select Query giving single record multiple col values
						Query query3=ses.createQuery("select pid,pname from Product where pid=:id");
						query3.setParameter("id",25);
						Object result=query3.getSingleResult();
						Object values[]=(Object[])result;
						System.out.println(values[0]+"   "+values[1]);
			*/			
			
			/*			//executing HQL scalar select Query giving single record single col value
						Query query4=ses.createQuery("select pname from Product where pid=:id");
						query4.setParameter("id",25);
						String name=(String)query4.getSingleResult();
						System.out.println("25 pid  pname ::"+name);
			*/			
			
			//executing HQL scalar select Query giving single record single col value
	/*		Query query5=ses.createQuery("select count(*)  from Product");
			long count=(Long)query5.getSingleResult();
			System.out.println("Records count::"+count); */
			
	/*	Query query6=ses.createQuery("select min(price),max(price),sum(price),avg(price)  from Product");
		Object results[]=(Object[])query6.getSingleResult();
		System.out.println("min price ::"+results[0]);
		System.out.println("max price ::"+results[1]);
		System.out.println("sum of  all prices ::"+results[2]);
		System.out.println("avg of  all prices ::"+results[3]);
	*/
			Query query7=ses.createQuery("from Product  where price=(select max(price) from Product)");
			List<Product> list=query7.getResultList();
			list.forEach(prod->{
				System.out.println(prod);
			});
	}//try
	
	catch(HibernateException he) {
		he.printStackTrace();
	}
	}//main
}//class
