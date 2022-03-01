package com.nt.test;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;

import com.nt.entity.Movie;
import com.nt.utility.HibernateUtil;

public class SaveObjectTest {

	public static void main(String[] args) {
		//get SessionFactory object
		SessionFactory factory=HibernateUtil.getSessionFactory();
		//get Session object
		Session ses=HibernateUtil.getSession();
		Transaction tx=null;
		try(ses;factory){
			//begin Tx
			tx=ses.beginTransaction();
			  //prepare object
			   Movie  movie=new Movie();
			   movie.setMid(1201);
			   movie.setMname("Pupsa");
			   movie.setHero("allu-arjun");
			   movie.setBudget(1000000000.0f);
			   //save object
			   int idValue=(Integer)ses.save(movie);
			   tx.commit();
			   System.out.println("Object is saved with id value::"+idValue);
		}//try
		catch(Exception e) {
			 if(tx!=null && tx.getStatus()!=null && tx.getRollbackOnly()) {
				     tx.rollback();
				     System.out.println("Object is not saved");
			 }
			 e.printStackTrace();
		}
		
	}//main
}//class
