package com.nt.test;

import com.nt.dao.OneToOnePKDAO;
import com.nt.dao.OneToOnePKDAOImpl;
import com.nt.utility.HibernateUtil;

public class OneToOnePKTest {

	public static void main(String[] args) {
		//create DAO class obj
		   OneToOnePKDAO  dao=new OneToOnePKDAOImpl();
		    //dao.saveDataUsingParent();
		     //dao.saveDataUsingChild();
		   dao.loadDataUsingParent();
       //close Session Factory
		    HibernateUtil.closeSessionFactory();
	}

}
