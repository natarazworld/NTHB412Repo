//ComponentMappingSelectTest.java
package com.nt.test;

import java.util.List;

import javax.persistence.Query;

import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.internal.build.AllowSysOut;

import com.nt.entity.JobDetails;
import com.nt.entity.Person;
import com.nt.utility.HibernateUtil;

public class ComponentMappingSelectTest {

	public static void main(String[] args) {
		  //create SessionFactory,Session objs
		  SessionFactory factory=HibernateUtil.getSessionFactory();
		  Session ses=HibernateUtil.getSession();
		  try {
				/*  //execute  HQL/JPQL Query
				  Query query1=ses.createQuery("from Person");
				  //execute the query
				  List<Person> list=query1.getResultList();
				  //process the Collection
				  list.forEach(per->{
					  System.out.println("person details ::"+per.getPid()+" "+per.getPname()+"  "+per.getPaddrs());
					  JobDetails details=per.getDetails();
					  System.out.println("Job Details ::"+details.getCompany()+"  "+details.getDesg()+"  "+details.getSalary());
				  });*/
			  
			//execute  HQL/JPQL Query
			  Query query1=ses.createQuery("from Person where details.company=?1");
			  //seet query param value
			  query1.setParameter(1,"HCL");
			  //execute the query
			  List<Person> list=query1.getResultList();
			  //process the Collection
			  list.forEach(per->{
				  System.out.println("person details ::"+per.getPid()+" "+per.getPname()+"  "+per.getPaddrs());
				  JobDetails details=per.getDetails();
				  System.out.println("Job Details ::"+details.getCompany()+"  "+details.getDesg()+"  "+details.getSalary());
			  });
			  
			  
			      
		  }//try
		  catch(HibernateException he) {
			  he.printStackTrace();
		  }
	}//main
}//class
