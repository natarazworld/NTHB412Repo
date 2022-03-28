//JPAQBC_SelectOperationTest.java
package com.nt.test;

import javax.persistence.Query;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaDelete;
import javax.persistence.criteria.Root;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;

import com.nt.entity.Product;
import com.nt.utility.HibernateUtil;

public class JPAQBC_NonSelectOperationTest {

	public static void main(String[] args) {
		SessionFactory factory=HibernateUtil.getSessionFactory();
		Session ses=HibernateUtil.getSession();
		Transaction tx=null;
		try(factory;ses){
			/*//create CriteriaBuilder obj
			CriteriaBuilder ctBuilder=ses.getCriteriaBuilder();
			//create CriteriaUpdate object
			CriteriaUpdate<Product> ctUpdate=ctBuilder.createCriteriaUpdate(Product.class);
			// create Root object specifying the from operation
			Root<Product> root=ctUpdate.from(Product.class);  // from Product
			//specify values to set and the conditions to apply
			ctUpdate.set("price", 20000.0f).where(ctBuilder.le(root.get("qty"),10));
			//  create Query object having CriteriaUpdate object
			Query query=ses.createQuery(ctUpdate);
			//process the Result
			tx=ses.beginTransaction();
			int count=query.executeUpdate();
			System.out.println("no.of records that are effected::"+count);
			tx.commit();*/
			
			//create CriteriaBuilder obj
			CriteriaBuilder ctBuilder=ses.getCriteriaBuilder();
			//create CriteriaDelete object
			CriteriaDelete<Product> ctDelete=ctBuilder.createCriteriaDelete(Product.class);
			// create Root object specifying the from operation
			Root<Product> root=ctDelete.from(Product.class);  // from Product
			//specify values to set and the conditions to apply
			ctDelete.where(ctBuilder.ge(root.get("price"), 50000));
			//  create Query object having CriteriaDelete object
			Query query=ses.createQuery(ctDelete);
			//process the Result
			tx=ses.beginTransaction();
			int count=query.executeUpdate();
			System.out.println("no.of records that are effected::"+count);
			tx.commit();
			
		}//try
		catch(Exception e) {
			if(tx!=null || tx.getStatus()!=null || tx.getRollbackOnly()) {
				tx.rollback();
				System.out.println("Problem in delete operation");
			}
		}//catch
	}//main
}//class
