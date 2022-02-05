package com.nt.test;

import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;

import com.nt.entity.Product;
import com.nt.utility.HibernateUtil;

public class Apporach2MergeObjectTestSolution {

	public static void main(String[] args) {
		//get SessionFactory object
		SessionFactory factory=HibernateUtil.getSessionFactory();
		//get SEssion object
		Session ses=HibernateUtil.getSession();
		Transaction tx=null;
		boolean flag=false;
		try{  //try with resource
			 //being Transaction
			  tx=ses.beginTransaction();

			  //Load object Object
		     Product prod=ses.get(Product.class, 3001);  //Loads Product class object(3001) and puts in L1 cache
		      if(prod!=null)
		        System.out.println(prod); 
		     
			     //update object
			     Product prod1=new Product();
			    prod1.setPid(3002);
			    prod1.setPname("SS poon1");
			    prod1.setPrice(4561.0f);
			    prod1.setQty(100.0f);
			    System.out.println(prod.hashCode()+"  "+prod1.hashCode());
			   Product prod2=(Product) ses.merge(prod1);
			   System.out.println(prod2);
			   System.out.println(prod.hashCode()+"  "+prod1.hashCode()+"  "+prod2.hashCode());
			   System.out.println("Object is  merged");
			   flag=true;
		}//try
		catch(HibernateException he) {
			flag=false;
			he.printStackTrace();
		}//catch
		
		finally {
			if(flag)
				tx.commit();
			else
				tx.rollback();
		   //close objs
			ses.close();
			factory.close();
		}
	}//main
}//class
