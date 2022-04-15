package com.nt.test;

import com.nt.dao.HospitableDAOImpl;
import com.nt.dao.IHospitalDAO;
import com.nt.utility.HibernateUtil;

public class ManyToManyTest {

	public static void main(String[] args) {
		// create DAO class obj
		IHospitalDAO dao=new  HospitableDAOImpl();
		   //dao.saveDataUsingParents();
		    //dao.saveDataUsingChilds();
		   dao.loadDataUsingParent();
       //close Session Factory
		    HibernateUtil.closeSessionFactory();
	}

}
