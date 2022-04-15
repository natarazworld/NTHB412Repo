package com.nt.dao;

import java.util.List;
import java.util.Set;

import javax.persistence.Query;

import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.Transaction;

import com.nt.entity.Department;
import com.nt.entity.Employee;
import com.nt.entity.IDepartment;
import com.nt.utility.HibernateUtil;

public class CompanyDAOImpl implements ICompanyDAO {

	@Override
	public void saveDataUsingParent() {
		Session ses=HibernateUtil.getSession();
		Transaction tx=null;
		try(ses){
			//begin Tx
			tx=ses.beginTransaction();
			  //prepare parent objs
			 Department dept=new Department();
			 dept.setDeptName("IT"); dept.setDeptHead("JAMES");
			 //prepare child objs
			 Employee emp1=new Employee();
			 emp1.setEmpName("rajesh"); emp1.setEmpSalary(898989.0f);
			 Employee emp2=new Employee();
			 emp2.setEmpName("ramesh"); emp2.setEmpSalary(898989.0f);
			 //set childs to parent  (for one to many)
			 dept.setEmployees(Set.of(emp1,emp2));
			 //set parent to childs (for many to one)
			 emp1.setDept(dept); emp2.setDept(dept);
			 
			 //save  through parent
			 ses.save(dept);
			tx.commit();
			System.out.println("parent to childs are saved");
		}
		catch(HibernateException he) {
			he.printStackTrace();
			if(tx!=null && tx.getStatus()!=null && tx.getRollbackOnly()) {
				tx.rollback();
				System.out.println("Problem in saving objs (parent to childs)");
			}
		}//catch
	}//method
	
	@Override
	public void saveDataUsingChild() {
		Session ses=HibernateUtil.getSession();
		Transaction tx=null;
		try(ses){
			//begin Tx
			tx=ses.beginTransaction();
			  //prepare parent objs
			 Department dept=new Department();
			 dept.setDeptName("ACCOUNTS"); dept.setDeptHead("JHON");
			 //prepare child objs
			 Employee emp1=new Employee();
			 emp1.setEmpName("suresh"); emp1.setEmpSalary(818981.0f);
			 Employee emp2=new Employee();
			 emp2.setEmpName("naresh"); emp2.setEmpSalary(828282.0f);
			 //set childs to parent  (for one to many)
			 dept.setEmployees(Set.of(emp1,emp2));
			 //set parent to childs (for many to one)
			 emp1.setDept(dept); emp2.setDept(dept);
			 
			 //save  through childs
			 ses.save(emp1); ses.save(emp2);
			tx.commit();
			System.out.println(" childs to parent are saved");
		}
		catch(HibernateException he) {
			he.printStackTrace();
			if(tx!=null && tx.getStatus()!=null && tx.getRollbackOnly()) {
				tx.rollback();
				System.out.println("Problem in saving objs ( childs to parent)");
			}
		}//catch
	}//method
	
	@Override
	public void loadDataUsingParent() {
		Session ses=HibernateUtil.getSession();
		try(ses){
			//Load  parents and the associated childs
			Query query=ses.createQuery("from Department");
			List<Department> list=query.getResultList();
			list.forEach(dept->{
				System.out.println("parent ::"+dept);
				Set<Employee> childs=dept.getEmployees();
				childs.forEach(emp->{
					System.out.println(emp);
				});
			});
		}//try
		catch(HibernateException he) {
			he.printStackTrace();
		}
		catch(Exception e) {
			e.printStackTrace();
		}
		
	}//method
	
	/*@Override
	public void loadDataUsingChild() {
		Session ses=HibernateUtil.getSession();
		try(ses){
			//Load  parents and the associated childs
			Query query=ses.createQuery("from Employee");
			List<Employee> list=query.getResultList();
			list.forEach(emp->{
				System.out.println("child ::"+emp);
				Department dept=emp.getDept();
				System.out.println("parent::"+dept);
			});
		}//try
		catch(HibernateException he) {
			he.printStackTrace();
		}
		catch(Exception e) {
			e.printStackTrace();
		}
		
	}*/
	
	@Override
	public void loadDataUsingChildWithProxy() {
		Session ses=HibernateUtil.getSession();
		try(ses){
			//Load  parents and the associated childs
			Query query=ses.createQuery("from Employee");
			List<Employee> list=query.getResultList();
			list.forEach(emp->{
				System.out.println("child ::"+emp);
				IDepartment dept=emp.getDept();
				System.out.println("parent::"+dept);
			});
		}//try
		catch(HibernateException he) {
			he.printStackTrace();
		}
		catch(Exception e) {
			e.printStackTrace();
		}
		
	}
	
}//class
