package com.nt.test;

import java.util.List;
import java.util.Map;
import java.util.Set;

import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;

import com.nt.entity.PersonDetails;
import com.nt.utility.HibernateUtil;

public class CollectionMappingInsertTest {

	public static void main(String[] args) {
	  // create SessionFacttory,Session objs
		 SessionFactory factory=HibernateUtil.getSessionFactory();
		 Session ses=HibernateUtil.getSession();
		 Transaction tx=null;
		 try(factory;ses){
			 //begin Tx 
			  tx=ses.beginTransaction();
			    //prepare object
			   PersonDetails details=new PersonDetails();
			   details.setPname("raja"); details.setPaddrs("hyd");  //java 9 feature
			   details.setNickNames(List.of("king","raj"));
			   details.setFriends(List.of("sudheer","mahesh","suresh"));
			   details.setContactNumbers(Set.of(9999999L,8888888L));
			   details.setIdDetails(Map.of("aadhar",54354353L,"voterId",4354353L));
			   int idVal=(int)ses.save(details);
			   System.out.println("Geneged Id vlaue is"+idVal);
			  tx.commit();
		 }
		 catch(HibernateException se) {
			 se.printStackTrace();
			 if(tx!=null || tx.getStatus()!=null || tx.getRollbackOnly()) {
				 tx.rollback();
				 System.out.println("Object is not saved");
			 }
		 }
		 catch(Exception e) {
			 e.printStackTrace();
		 }

	}

}
