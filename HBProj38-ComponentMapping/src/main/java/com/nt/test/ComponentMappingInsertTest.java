package com.nt.test;

import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;

import com.nt.entity.JobDetails;
import com.nt.entity.Person;
import com.nt.utility.HibernateUtil;

public class ComponentMappingInsertTest {

	public static void main(String[] args) {
		  //create SessionFactory,Session objs
		  SessionFactory factory=HibernateUtil.getSessionFactory();
		  Session ses=HibernateUtil.getSession();
		  Transaction tx=null;
		  try {
			  //begin Tx
			   tx=ses.beginTransaction();
			      //prepare objs
			      JobDetails details=new JobDetails();
			      details.setDesg("Developer"); details.setCompany("HCL"); details.setSalary(190000.0);
			      Person  per=new Person();
			    per.setPname("suresh");per.setPaddrs("dehi");
			      per.setDetails(details);
			      
			      //save object
			        int idVal=(Integer)ses.save(per);
			        System.out.println("Person is saved with id value :: "+idVal);
                  //commit tx
			        tx.commit();
		  }//try
		  catch(HibernateException he) {
			  he.printStackTrace();
			  if(tx!=null && tx.getStatus()!=null && tx.getRollbackOnly()) {
				  tx.rollback();
				  System.out.println("Problem in saving data");
			  }//if
		  }
	}//main
}//class
