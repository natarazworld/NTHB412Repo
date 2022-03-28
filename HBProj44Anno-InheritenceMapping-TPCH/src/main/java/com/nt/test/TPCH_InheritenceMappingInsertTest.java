package com.nt.test;

import java.time.LocalDateTime;

import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;

import com.nt.entity.CardPayment;
import com.nt.entity.ChequePayment;
import com.nt.utility.HibernateUtil;

public class TPCH_InheritenceMappingInsertTest {

	public static void main(String[] args) {
	   // Get SessionFactory,Session objs
		SessionFactory factory=HibernateUtil.getSessionFactory();
		Session ses=HibernateUtil.getSession();
		Transaction tx=null;
		try(factory;ses){
			//prepare objects
			   ChequePayment cheque=new ChequePayment();
			   cheque.setAmount(45677.0);
			   cheque.setTxDate(LocalDateTime.of(2022,03,10,4,30,12));
			   cheque.setChequeNo(11223344L);
			   cheque.setChequeType("Self");
               
			   CardPayment  card=new CardPayment();
			   card.setAmount(77655.0);
			   card.setTxDate(LocalDateTime.of(2022,01,10,4,31,12));
			   card.setCardNo(436778L);
			   card.setCardType("CREDIT");
			   card.setGateway("VISA");
			 //begin Tx
			 tx=ses.beginTransaction();
			     //save objs
			   ses.save(cheque);
			   ses.save(card);
           tx.commit();
           System.out.println("Objects are saved");
		}//try
		catch(HibernateException he) {
			he.printStackTrace();
			if(tx!=null && tx.getStatus()!=null && tx.getRollbackOnly()) {
				   tx.rollback();
				   System.out.println("Problem is saving objects..");
			}
		}
		catch(Exception  e) {
			e.printStackTrace();
		}
	}//main
}//classs
