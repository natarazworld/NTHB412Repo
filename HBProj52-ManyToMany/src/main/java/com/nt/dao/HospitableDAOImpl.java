package com.nt.dao;

import java.util.List;
import java.util.Set;

import javax.persistence.Query;

import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.Transaction;

import com.nt.entity.Doctor;
import com.nt.entity.Patient;
import com.nt.utility.HibernateUtil;

public class HospitableDAOImpl implements IHospitalDAO {

	@Override
	public void saveDataUsingParents() {
          Session ses=HibernateUtil.getSession();
          Transaction tx=null;
          try(ses){
        	  //prepare parent objs
        	  Doctor doc1=new Doctor();
        	  doc1.setDocName("raja"); doc1.setHospital("apollo");
        	  Doctor doc2=new Doctor();
        	  doc2.setDocName("rajesh"); doc2.setHospital("care");
        	  //prepare child objs
        	  Patient pat1=new Patient();
        	  pat1.setPatName("anil"); pat1.setProblem("heart");
        	  Patient pat2=new Patient();
        	  pat2.setPatName("suresh"); pat2.setProblem("kidney");
        	  Patient pat3=new Patient();
        	  pat3.setPatName("rakesh"); pat3.setProblem("corona");
        	  // assign  childs to parents
        	  doc1.setPatients(Set.of(pat1,pat2));
        	  doc2.setPatients(Set.of(pat1,pat2,pat3));
        	// assign   parents to childs
        	  pat1.setDoctors(Set.of(doc1,doc2));
        	  pat2.setDoctors(Set.of(doc1,doc2));
        	  pat3.setDoctors(Set.of(doc2));
        	  //begin tx
        	  tx=ses.beginTransaction();
        	     //save using parents
        	       ses.save(doc1);ses.save(doc2);
        	   tx.commit();
        	   System.out.println("Objects are saved");
          }//try
          catch(HibernateException he) {
        	  he.printStackTrace();
        	  if(tx!=null && tx.getStatus()!=null && tx.getRollbackOnly()) {
        		  tx.rollback();
        		  System.out.println("Problem is  saving objs");
        	  }
          }
          catch(Exception e) {
        	  e.printStackTrace();
          }
	}//method
	
	@Override
	public void saveDataUsingChilds() {
		  Session ses=HibernateUtil.getSession();
          Transaction tx=null;
          try(ses){
        	  //prepare parent objs
        	  Doctor doc1=new Doctor();
        	  doc1.setDocName("raja1"); doc1.setHospital("apollo1");
        	  Doctor doc2=new Doctor();
        	  doc2.setDocName("rajesh1"); doc2.setHospital("care1");
        	  //prepare child objs
        	  Patient pat1=new Patient();
        	  pat1.setPatName("anil1"); pat1.setProblem("heart1");
        	  Patient pat2=new Patient();
        	  pat2.setPatName("suresh1"); pat2.setProblem("kidney1");
        	  Patient pat3=new Patient();
        	  pat3.setPatName("rakesh1"); pat3.setProblem("corona1");
        	  // assign  childs to parents
        	  doc1.setPatients(Set.of(pat1,pat2));
        	  doc2.setPatients(Set.of(pat1,pat2,pat3));
        	// assign   parents to childs
        	  pat1.setDoctors(Set.of(doc1,doc2));
        	  pat2.setDoctors(Set.of(doc1,doc2));
        	  pat3.setDoctors(Set.of(doc2));
        	  //begin tx
        	  tx=ses.beginTransaction();
        	     //save using childs
        	       ses.save(pat1); ses.save(pat2); ses.save(pat3);
        	   tx.commit();
        	   System.out.println("Objects are saved");
          }//try
          catch(HibernateException he) {
        	  he.printStackTrace();
        	  if(tx!=null && tx.getStatus()!=null && tx.getRollbackOnly()) {
        		  tx.rollback();
        		  System.out.println("Problem is  saving objs");
        	  }
          }
          catch(Exception e) {
        	  e.printStackTrace();
          }
		
	}//method
	
	@Override
	public void loadDataUsingParent() {
		 Session ses=HibernateUtil.getSession();
         Transaction tx=null;
         try(ses){
        	 Query query=ses.createQuery("from Doctor");
        	 List<Doctor> list=query.getResultList();
        	 list.forEach(doc->{
        		System.out.println("parent::"+doc);
        		Set<Patient> childs=doc.getPatients();
        		 childs.forEach(pat->{
        			 System.out.println("child::"+pat);
        		 });
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
