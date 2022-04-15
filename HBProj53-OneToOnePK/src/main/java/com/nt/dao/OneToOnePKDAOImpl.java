package com.nt.dao;

import java.time.LocalDate;
import java.util.List;

import javax.persistence.Query;

import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.Transaction;

import com.nt.entity.LibraryMembership;
import com.nt.entity.Student;
import com.nt.utility.HibernateUtil;

public class OneToOnePKDAOImpl implements OneToOnePKDAO {

	@Override
	public void saveDataUsingParent() {
		Session ses=HibernateUtil.getSession();
		Transaction tx=null;
		try(ses){
			//begin tx
			tx=ses.beginTransaction();
			//prepare objs   
			Student stud=new Student();
			   stud.setSname("raja"); stud.setSadd("hyd");
			   LibraryMembership lib=new LibraryMembership();
			   lib.setType("gold"); lib.setDoj(LocalDate.now());
			   //set parent to child
			   lib.setStudentDetails(stud);
			   stud.setLibraryDetails(lib);
			   //save objs
			    ses.save(stud);
			tx.commit();
			System.out.println("Objects are saved");
			
		}//try
		catch(HibernateException he) {
			he.printStackTrace();
           if(tx!=null && tx.getStatus()!=null && tx.getRollbackOnly()) {
        	   tx.rollback();
        	   System.out.println("Problem in objs saving");
           }
		}//catch

	}//method

	@Override
	public void saveDataUsingChild() {
		Session ses=HibernateUtil.getSession();
		Transaction tx=null;
		try(ses){
			//begin tx
			tx=ses.beginTransaction();
			//prepare objs   
			Student stud=new Student();
			   stud.setSname("suresh"); stud.setSadd("vizag");
			   LibraryMembership lib=new LibraryMembership();
			   lib.setType("silver"); lib.setDoj(LocalDate.now());
			   //set parent to child
			   lib.setStudentDetails(stud);
			   stud.setLibraryDetails(lib);
			   //save objs
			    ses.save(lib);
			tx.commit();
			System.out.println("Objects are saved");
		}//try
		catch(HibernateException he) {
			he.printStackTrace();
           if(tx!=null && tx.getStatus()!=null && tx.getRollbackOnly()) {
        	   tx.rollback();
        	   System.out.println("Problem in objs saving");
           }
		}//catch
	}//method
	
	@Override
	public void loadDataUsingParent() {
		Session ses=HibernateUtil.getSession();
		Transaction tx=null;
		try(ses){
			Query query=ses.createQuery("from Student");
			List<Student> list=query.getResultList();
			list.forEach(stud->{
				System.out.println("parent::"+stud);
				LibraryMembership lib=stud.getLibraryDetails();
				System.out.println("child::"+lib);
			});
		}//try
		catch(HibernateException he) {
			he.printStackTrace();
		}
		catch(Exception e) {
			e.printStackTrace();
		}
	}//method

}//class
