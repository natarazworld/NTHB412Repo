package com.nt.test;

import java.util.List;

import javax.persistence.Query;

import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.SessionFactory;

import com.nt.entity.CardPayment;
import com.nt.entity.ChequePayment;
import com.nt.entity.Payment;
import com.nt.utility.HibernateUtil;
public class TPCH_InheritenceMappingSelectTest {

	public static void main(String[] args) {
	   // Get SessionFactory,Session objs
		SessionFactory factory=HibernateUtil.getSessionFactory();
		Session ses=HibernateUtil.getSession();
		try(factory;ses){
          // execute HQL Query1
			Query query1= ses.createQuery("from CardPayment");
			List<CardPayment> list1=query1.getResultList();
			list1.forEach(card->{
				System.out.println(card);
			});
			System.out.println("================");
			Query query2= ses.createQuery("from ChequePayment");
			List<ChequePayment> list2=query2.getResultList();
			list2.forEach(ch->{
				System.out.println(ch);
			});
			System.out.println("================");
			Query query3= ses.createQuery("from Payment");
			List<Payment> list3=query3.getResultList();
			list3.forEach(pay->{
				System.out.println(pay);
			});
		}//try
		catch(HibernateException he) {
			he.printStackTrace();
		}
		catch(Exception  e) {
			e.printStackTrace();
		}
	}

}
