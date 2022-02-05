package com.nt.test;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;

import com.nt.entity.PrgmrProjId;
import com.nt.entity.ProgrammerProjectInfo;
import com.nt.utility.HibernateUtil;

public class SaveObjectTest {

	public static void main(String[] args) {
		//get SessionFactory
		SessionFactory factory=HibernateUtil.getSessionFactory();
		//get Session
		Session ses=factory.openSession();
		Transaction tx=null;
		try(factory;ses){
			//begin Tx
			tx=ses.beginTransaction();
			    //prepare Id class object
			    PrgmrProjId  id=new PrgmrProjId(101,1002);
			   //prepare Entity class object
			    ProgrammerProjectInfo info=new ProgrammerProjectInfo(id, "mahesh", "openFx",80000, 4000000);
			    //save object
			    PrgmrProjId idVal=(PrgmrProjId) ses.save(info);
              tx.commit();
              System.out.println("Object/record is saved with the id value::"+idVal);

		}//try
		catch(Exception e) {
			if(tx!=null && tx.getStatus()!=null && tx.getRollbackOnly()) {
				tx.rollback();
				System.out.println("Object is not saved");
			}
				
		}//catch
	}//main
}//class
