package com.nt.test;

import com.nt.dao.OneToOneFKDAO;
import com.nt.dao.OneToOneFKDAOImpl;
import com.nt.utility.HibernateUtil;

public class OneToOneFKTest {

	public static void main(String[] args) {
		//create DAO class obj
		   OneToOneFKDAO  dao=new OneToOneFKDAOImpl();
		    //dao.saveDataUsingChild();
		     dao.loadDataUsingChild();
       //close Session Factory
		    HibernateUtil.closeSessionFactory();
	}

}
