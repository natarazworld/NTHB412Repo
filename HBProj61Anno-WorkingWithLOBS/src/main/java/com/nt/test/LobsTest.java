package com.nt.test;

import com.nt.dao.CompanyDAOImpl;
import com.nt.dao.ICompanyDAO;
import com.nt.utility.HibernateUtil;

public class LobsTest {

	public static void main(String[] args) {
	     ICompanyDAO dao=new CompanyDAOImpl();
	        //dao.saveData();
	     dao.loadData();
		
		 //close SessionFactory
		 HibernateUtil.closeSessionFactory();
	}//method
}//class
