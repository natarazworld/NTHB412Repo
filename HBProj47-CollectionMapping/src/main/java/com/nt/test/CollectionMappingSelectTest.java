package com.nt.test;

import java.util.List;
import java.util.Map;
import java.util.Set;

import javax.persistence.Query;

import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.SessionFactory;

import com.nt.entity.PersonDetails;
import com.nt.utility.HibernateUtil;

public class CollectionMappingSelectTest {

	public static void main(String[] args) {
	  // create SessionFacttory,Session objs
		 SessionFactory factory=HibernateUtil.getSessionFactory();
		 Session ses=HibernateUtil.getSession();
		 try(factory;ses){
			  //execute  HQL quer
			 Query query=ses.createQuery("from PersonDetails");
			 List<PersonDetails> list=query.getResultList();
			 list.forEach(pd->{
				 System.out.println("Person Info::"+pd.getPid()+"  "+pd.getPname()+"  "+pd.getPaddrs());
				 //NickNames Info
				 List<String> nickNames=pd.getNickNames();
				 System.out.println("nicknames are ::"+nickNames.toString());
				 //Friends  are
				 List<String> friends=pd.getFriends();
				 System.out.println("friends are ::"+nickNames.toString());
				 // Contact Numbers are
				 Set<Long> contactNumbers=pd.getContactNumbers();
				 System.out.println("contact numbers are::"+contactNumbers);
				 //Id Details are
				 Map<String,Long> idDetails=pd.getIdDetails();
				 System.out.println("idDetails  are::"+idDetails);
			 });
		 }//try
		 catch(HibernateException se) {
			 se.printStackTrace();
		 }
		 catch(Exception e) {
			 e.printStackTrace();
		 }

	}//main
}//class
