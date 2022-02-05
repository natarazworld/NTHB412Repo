package com.nt.test;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;

import com.nt.entity.PrgmrProjId;
import com.nt.entity.ProgrammerProjectInfo;
import com.nt.utility.HibernateUtil;

public class LoadObjectTest {

	public static void main(String[] args) {
		//get SessionFactory
		SessionFactory factory=HibernateUtil.getSessionFactory();
		//get Session
		Session ses=factory.openSession();
		try(factory;ses){
			 //prepare id class obj
			PrgmrProjId id=new PrgmrProjId(101,1002);
			//Load object
			ProgrammerProjectInfo info=ses.get(ProgrammerProjectInfo.class, id);
			if(info!=null)
			 System.out.println(info);
			else
				System.out.println("record nof found");
		}//try
		catch(Exception e) {
			 e.printStackTrace();
			}
	}//main
}//class
