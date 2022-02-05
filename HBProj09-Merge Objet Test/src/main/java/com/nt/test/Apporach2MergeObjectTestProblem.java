package com.nt.test;

import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;

import com.nt.entity.Product;
import com.nt.utility.HibernateUtil;

public class Apporach2MergeObjectTestProblem {

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
			    prod1.setPid(3001);
			    prod1.setPname("goldspoon4");
			    prod1.setPrice(4561.0f);
			    prod1.setQty(56.0f);
			     ses.save(prod1);
			    //  ses.update(prod1);   // tries to puts another object(3001) same Product class in L1 cache ,
			                                           //So exception will be raised (NonUniqueObjectException)
			    System.out.println("Object is  updated");
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
