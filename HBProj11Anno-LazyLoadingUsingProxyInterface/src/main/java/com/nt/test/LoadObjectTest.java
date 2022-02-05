package com.nt.test;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;

import com.nt.entity.Movie;
import com.nt.utility.HibernateUtil;

public class LoadObjectTest {

	public static void main(String[] args) {
		//get SessionFactory object
		SessionFactory factory=HibernateUtil.getSessionFactory();
		//get Session object
		Session ses=HibernateUtil.getSession();
		try(ses;factory){
			Movie movie=ses.get(Movie.class, 1101);
			if(movie==null) 
				System.out.println("Movie not found");
			else 
				System.out.println(movie);
		}//try
		catch(Exception e) {
			 e.printStackTrace();
		}
		
	}//main
}//class
