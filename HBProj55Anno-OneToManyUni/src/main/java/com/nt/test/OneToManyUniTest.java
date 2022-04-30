package com.nt.test;

import com.nt.dao.IPersonDetailsDAO;
import com.nt.dao.PersonDetailsDAOImpl;
import com.nt.utility.HibernateUtil;

public class OneToManyUniTest {

	public static void main(String[] args) {
		   IPersonDetailsDAO dao=new PersonDetailsDAOImpl();
		    //dao.saveDataUsingParent();
		   
		  // dao.loadDataUsingParent();
		   
		   //dao.addChildToExistingParent();
		   
		  // dao.deleteAllChildsOfAParent();
		   
		  // dao.deleteOneChildFromCollectionOfChildsOfAParent();
		    
		    dao.deleteParentAndItsChilds();
		    
		    //close SessionFactory
		    HibernateUtil.closeSessionFactory();

	}

}
