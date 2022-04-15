package com.nt.test;

import com.nt.dao.CompanyDAOImpl;
import com.nt.dao.ICompanyDAO;
import com.nt.utility.HibernateUtil;

public class OneToManyBiTest {

	public static void main(String[] args) {
		ICompanyDAO dao=new CompanyDAOImpl();
		 //dao.saveDataUsingParent();
		//dao.saveDataUsingChild();
		//-------------------------------------------
		  //dao.loadDataUsingParent();
		//dao.loadDataUsingChild();
		
		//dao.loadDataUsingChild();
		dao.loadDataUsingChildWithProxy();
		  
		
		
		
		 //close SessionFactory
		 HibernateUtil.closeSessionFactory();
	}//method
}//class
