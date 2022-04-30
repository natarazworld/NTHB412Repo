//DAOImpl class
package com.nt.dao;

import java.time.LocalDate;
import java.util.List;

import javax.persistence.Query;

import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.Transaction;

import com.nt.entity.Passport;
import com.nt.entity.Person;
import com.nt.utility.HibernateUtil;

public class OneToOneFKDAOImpl implements OneToOneFKDAO {

	
	@Override
	public void saveDataUsingChild() {
		Session ses=HibernateUtil.getSession();
		Transaction tx=null;
		try(ses){
			//begin tx
			tx=ses.beginTransaction();
			//prepare objs
			    Person  per=new Person();
			    per.setPname("raja"); per.setPaddrs("hyd");
			    Passport pspt=new Passport();
			    pspt.setCountry("India"); pspt.setExpiryDate(LocalDate.of(2030,10, 2));
			    //set parent to child
			    pspt.setPersonDetails(per);
			   //save objs
			    ses.save(pspt);
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
	public void loadDataUsingChild() {
		Session ses=HibernateUtil.getSession();
		try(ses){
			Query query=ses.createQuery("from Passport");
			List<Passport> list=query.getResultList();
			list.forEach(pspt->{
				System.out.println("child::"+pspt);
				Person per=pspt.getPersonDetails();
				System.out.println("parent::"+per);
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
