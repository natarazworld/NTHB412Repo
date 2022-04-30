package com.nt.dao;

import java.util.List;
import java.util.Set;

import javax.persistence.Query;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.JoinType;
import javax.persistence.criteria.Root;

import org.hibernate.HibernateException;
import org.hibernate.Session;

import com.nt.entity.Department;
import com.nt.entity.Employee;
import com.nt.utility.HibernateUtil;

public class CompanyDAOImpl implements ICompanyDAO {

	@Override
	public void loadDataUsingJoinsParentToChild() {
		Session ses=HibernateUtil.getSession();
		try(ses){
			Query query=ses.createQuery("select d.deptNo,d.deptName,d.deptHead,e.empNo,e.empName,e.empSalary from Department d inner join d.employees e");
			List<Object[]> list=query.getResultList();
			list.forEach(row->{
				for(Object val:row) {
					System.out.print(val+"  ");
				}//for
				System.out.println();
			});//forEach
		}//try
		catch(HibernateException he) {
			he.printStackTrace();
		}
		catch(Exception e) {
			e.printStackTrace();
		}
	}//method

	@Override
	public void loadDataUsingJoinsChildToParent() {
		Session ses=HibernateUtil.getSession();
		try(ses){
			//Query query=ses.createQuery("select e.empNo,e.empName,e.empSalary,d.deptNo,d.deptName,d.deptHead from Employee e inner join e.dept d");
			//Query query=ses.createQuery("select e.empNo,e.empName,e.empSalary,d.deptNo,d.deptName,d.deptHead from Employee e left join e.dept d");
			//Query query=ses.createQuery("select e.empNo,e.empName,e.empSalary,d.deptNo,d.deptName,d.deptHead from Employee e right join e.dept d");
			Query query=ses.createQuery("select e.empNo,e.empName,e.empSalary,d.deptNo,d.deptName,d.deptHead from Employee e full  join e.dept d");
			List<Object[]> list=query.getResultList();
			list.forEach(row->{
				for(Object val:row) {
					System.out.print(val+"  ");
				}//for
				System.out.println();
			});//forEach
		}//try
		catch(HibernateException he) {
			he.printStackTrace();
		}
		catch(Exception e) {
			e.printStackTrace();
		}
		
	}

	@Override
	public void loadDataUsingParentHQL() {
		Session ses=HibernateUtil.getSession();
		try(ses){
			Query query=ses.createQuery("from Department");
			List<Department> list=query.getResultList();
			list.forEach(dept->{
				System.out.println("parent ::"+dept);
				Set<Employee> childs=dept.getEmployees();
				childs.forEach(emp->{
					System.out.println("child::"+emp);
				});//forEach
			}); //forEach
		}//try
		catch(HibernateException he) {
			he.printStackTrace();
		}
		catch(Exception e) {
			e.printStackTrace();
		}
		
	}//method
	
	@Override
	public void loadDataUsingJPQBC() {
		Session ses=HibernateUtil.getSession();
		try(ses){
		//create CriteriaBuilder obj
		CriteriaBuilder ctBuilder=ses.getCriteriaBuilder();
		//create CriteriaQuery object
	  CriteriaQuery<Department> ctQuery=ctBuilder.createQuery(Department.class);
	   // create Root object specifying the from operation
	 Root<Department> root=ctQuery.from(Department.class);  //select * from Product
	 root.fetch("employees",JoinType.INNER);
	   //  create Query object having CriteriaQuery object
	 Query query=ses.createQuery(ctQuery);
	 //execute the QBC  logic
	 List<Department> list=query.getResultList();
	 //process the result
	  list.forEach(dept->{
		   System.out.println("parent::"+dept);
		   //get childs
		  Set<Employee> childs=dept.getEmployees();
		   childs.forEach(emp->{
			   System.out.println("Child::"+emp);
		   });
	  });
		}
		catch(HibernateException he) {
			he.printStackTrace();
		}
		
	}

		
}//class
