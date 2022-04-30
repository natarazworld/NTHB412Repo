package com.nt.dao;

import java.util.List;
import java.util.Set;

import javax.persistence.Query;

import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.Transaction;

import com.nt.entity.PersonDetails;
import com.nt.entity.PhoneNumber;
import com.nt.utility.HibernateUtil;

public class PersonDetailsDAOImpl implements IPersonDetailsDAO {

	@Override
	public void saveDataUsingParent() {
		//get Accesss to Session object
		Session ses=HibernateUtil.getSession();
		Transaction tx=null;
		try(ses){
			tx=ses.beginTransaction();
			   //prepare  parent obj
			    PersonDetails  pDetails=new PersonDetails();
			    pDetails.setPname("raja"); pDetails.setPaddrs("hyd");
			    //prepare child objs
			    PhoneNumber ph1=new PhoneNumber();
			    ph1.setNumberType("residence"); ph1.setProvider("airtel");
			    ph1.setMobileNo(999999999L);
			    
			    PhoneNumber ph2=new PhoneNumber();
			    ph2.setNumberType("office"); ph2.setProvider("jio");
			    ph2.setMobileNo(888888888L);
			    //set child objs to parent obj
			    pDetails.setPhones(Set.of(ph1,ph2));
			   //save parent obj
			     int idVal=(Integer)ses.save(pDetails);
			     System.out.println("Generated id value::"+idVal);
			tx.commit();
			System.out.println("Parent and the associated childs are saved");
		}//try
		catch(HibernateException he) {
			he.printStackTrace();
			 if(tx!=null && tx.getStatus()!=null && tx.getRollbackOnly()) {
				     tx.rollback();
				     System.out.println("Parent and the associated childs are not saved");
			 }//if
		}//catch
		catch(Exception e) {
			e.printStackTrace();
		}
	}//method
	
	@Override
	public void loadDataUsingParent() {
		//get Accesss to Session object
		Session ses=HibernateUtil.getSession();
		try(ses){
			Query  query=ses.createQuery("from PersonDetails");
			List<PersonDetails> list=query.getResultList();
			list.forEach(pd->{
			    System.out.println("parent ::"+pd);
				Set<PhoneNumber>  childs=pd.getPhones();
				System.out.println("chids count::"+childs.size());
				/*childs.forEach(ph->{
				  System.out.println("child::"+ph);
				});
				  System.out.println("............");*/
			});
		}//try
		catch(HibernateException he) {
			he.printStackTrace();
		}//catch
		catch(Exception e) {
			e.printStackTrace();
		}

	}//method
	
	@Override
	public void addChildToExistingParent() {
		Session ses=HibernateUtil.getSession();
		Transaction tx=null;
		try(ses){
			tx=ses.beginTransaction();
			//Load existing parent
              PersonDetails pd=ses.get(PersonDetails.class, 121);
             //get all childs of parent
              Set<PhoneNumber> childs=pd.getPhones();
              //create new Child obj
              PhoneNumber ph=new PhoneNumber();
              ph.setMobileNo(888887777L);
              ph.setNumberType("office");
              ph.setProvider("vi");
              //add new child to existing parent
              childs.add(ph);
			tx.commit();
			System.out.println("Child is added to existing childs of a parent");
		}
		catch(HibernateException he) {
			 he.printStackTrace();
			if(tx!=null || tx.getRollbackOnly() || tx.getStatus()!=null) {
				tx.rollback();
			}
		}//catch
		catch(Exception e) {
			e.printStackTrace();
		}
	}//method
	
	@Override
	public void deleteAllChildsOfAParent() {
		Session ses=HibernateUtil.getSession();
		Transaction tx=null;
		try(ses){
			tx=ses.beginTransaction();
			//Load a Parent
			PersonDetails details=ses.get(PersonDetails.class,121);
			// get All childs of a parent
			Set<PhoneNumber>  childs=details.getPhones();
			//remove all childs
			  childs.removeAll(childs);
			tx.commit();
			System.out.println("all childs of parent are removed");
		}
		catch(HibernateException he) {
			 he.printStackTrace();
			if(tx!=null || tx.getRollbackOnly() || tx.getStatus()!=null) {
				tx.rollback();
				System.out.println("Problem in removing childs of a parent");
			}
		}//catch
		catch(Exception e) {
			e.printStackTrace();
		}
	}//meethod
	
	@Override
	public void deleteOneChildFromCollectionOfChildsOfAParent() {
		Session ses=HibernateUtil.getSession();
		Transaction tx=null;
		try(ses){
			tx=ses.beginTransaction();
			//Load a Parent
			PersonDetails details=ses.get(PersonDetails.class,2);
			//get all childs of a parent
			Set<PhoneNumber> childs=details.getPhones();
			//Load Specific child that u want to delete
			PhoneNumber ph=ses.get(PhoneNumber.class, 24);
			childs.remove(ph);
			tx.commit();
			System.out.println("Specific child of parent is deleted");
		}//try
		catch(HibernateException he) {
			he.printStackTrace();
			if(tx!=null || tx.getRollbackOnly() || tx.getStatus()!=null) {
				tx.rollback();
				System.out.println("Problem in removing specific child of a parent");
			}//if
		}//catch
	}//method
	
	@Override
	public void deleteParentAndItsChilds() {
		Session ses=HibernateUtil.getSession();
		Transaction tx=null;
		try(ses){
			tx=ses.beginTransaction();
			   //Load a parent  which leads to loading the childs
			   PersonDetails details= ses.get(PersonDetails.class,122);
			    //delete parent   which leads deleting the childs
			   ses.delete(details); 
			tx.commit();
			 System.out.println("parent its associated childs are deleted");
		}//try
		catch(HibernateException he) {
			he.printStackTrace();
			if(tx!=null || tx.getRollbackOnly() || tx.getStatus()!=null) {
				tx.rollback();
				System.out.println("parent its associated childs are not deleted");
			}//if
		}//catch
		
	}
	
}//class
