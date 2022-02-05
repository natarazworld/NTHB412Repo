package com.nt.test;

import java.util.Arrays;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;

import com.nt.entity.Movie;
import com.nt.proxy.IMovie;
import com.nt.utility.HibernateUtil;

public class LoadObjectTestUsingLoadMethod {

	public static void main(String[] args) {
		//get SessionFactory object
		SessionFactory factory=HibernateUtil.getSessionFactory();
		//get Session object
		Session ses=HibernateUtil.getSession();
		try(ses;factory){
			IMovie movie=ses.load(IMovie.class, 1101);
			System.out.println(movie.getClass()+" <------->  "+movie.getClass().getSuperclass()+ " <--->  "+Arrays.toString(movie.getClass().getInterfaces()));
				//System.out.println(movie);
		}//try
		catch(Exception e) {
			 e.printStackTrace();
		}
		
	}//main
}//class
