package com.nt.test;

import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;

import com.nt.entity.Customer;
import com.nt.entity.Employee;
import com.nt.entity.Person;
import com.nt.utility.HibernateUtil;

public class TPCH_InheritenceMappingInsertTest {

	public static void main(String[] args) {
	   // Get SessionFactory,Session objs
		SessionFactory factory=HibernateUtil.getSessionFactory();
		Session ses=HibernateUtil.getSession();
		Transaction tx=null;
		try(factory;ses){
			//prepare objects
			Person per=new Person();
			per.setPname("raja");
			per.setCompany("HCL");
			
			Employee emp=new Employee();
			emp.setPname("rajesh");
			emp.setCompany("Wipro");
			emp.setDesg("DEVELOPER");
			emp.setDeptno(1001);
			emp.setSalary(80000.0);
			
			Customer cust=new Customer();
			cust.setPname("karan");
			cust.setCompany("SAMSUNG");
			cust.setBillAmt(90000.0);
			cust.setBillNo(2345);
			 //begin Tx
			 tx=ses.beginTransaction();
			     //save objs
			   ses.save(per);
			   ses.save(emp);
			   ses.save(cust);
           tx.commit();
           System.out.println("Objects are saved");
		}//try
		catch(HibernateException he) {
			he.printStackTrace();
			if(tx!=null && tx.getStatus()!=null && tx.getRollbackOnly()) {
				   tx.rollback();
				   System.out.println("Problem is saving objects..");
			}
		}
		catch(Exception  e) {
			e.printStackTrace();
		}
	}

}
