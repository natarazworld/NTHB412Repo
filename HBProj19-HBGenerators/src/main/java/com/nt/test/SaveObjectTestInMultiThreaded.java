package com.nt.test;

import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

import com.nt.entity.Product;
import com.nt.utility.HibernateUtil;

public class SaveObjectTestInMultiThreaded {

	public static void main(String[] args) {
		
		TicketBookingOperation operation=new TicketBookingOperation();
		Thread th1=new Thread(operation);
		th1.start();
		
		Thread th2=new Thread(operation);
		th2.start();
		
		Thread th3=new Thread(operation);
		th3.start();
		
	
	}//main
}//class
