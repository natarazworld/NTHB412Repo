package com.nt.test;

import org.hibernate.Session;
import org.hibernate.SessionFactory;

import com.nt.entity.Movie;
import com.nt.utility.HibernateUtil;

public class SaveObjectTest {

	public static void main(String[] args) {
		//get SessionFactory object
		SessionFactory factory=HibernateUtil.getSessionFactory();
		//get Session object
		Session ses=HibernateUtil.getSession();
		try(factory;ses){
		// Load object
		Movie movie=(Movie)ses.get(Movie.class, 24);  //Collects from DB and keeps  L1 cache
		System.out.println(movie);
		System.out.println("-------------------------");
		Movie movie1=(Movie)ses.get(Movie.class, 24);  //Collects from   L1 cache
		System.out.println(movie1);
		System.out.println("---------------------");
		Movie movie2=(Movie)ses.get(Movie.class, 25);  //Collects from DB and keeps  L1 cache
		System.out.println(movie2);
		
		ses.evict(movie);  //removes Movie obj with 24 id value from L1 cache
		Movie movie3=(Movie)ses.get(Movie.class, 24);  //Collects from DB  and keeps  in  L1 cache
		System.out.println(movie3);
		
		//To empty the L1 cache
		ses.clear(); // Removes all the objects from L1 cache 
		Movie movie4=(Movie)ses.get(Movie.class, 24);  //Collects from DB  and keeps  in  L1 cache
		System.out.println(movie4);
		 
		
		}//try
		catch(Exception e) {
			e.printStackTrace();
		}
		
		
				
	}//main
}//class
