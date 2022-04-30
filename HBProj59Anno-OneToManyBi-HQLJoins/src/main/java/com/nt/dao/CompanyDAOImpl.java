package com.nt.dao;

import java.util.List;

import javax.persistence.Query;

import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.internal.build.AllowSysOut;

import com.nt.utility.HibernateUtil;

public class CompanyDAOImpl implements ICompanyDAO {

	@Override
	public void loadDataUsingJoinsParentToChild() {
		Session ses=HibernateUtil.getSession();
		try(ses){
			//Query query=ses.createQuery("select d.deptNo,d.deptName,d.deptHead,e.empNo,e.empName,e.empSalary from Department d inner join d.employees e");
			//Query query=ses.createQuery("select d.deptNo,d.deptName,d.deptHead,e.empNo,e.empName,e.empSalary from Department d left join d.employees e");
			//Query query=ses.createQuery("select d.deptNo,d.deptName,d.deptHead,e.empNo,e.empName,e.empSalary from Department d right  join d.employees e");
			Query query=ses.createQuery("select d.deptNo,d.deptName,d.deptHead,e.empNo,e.empName,e.empSalary from Department d full  join d.employees e");
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
	
	
	

		
}//class
