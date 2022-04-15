package com.nt.entity;

import java.util.Set;

public interface IDepartment {
       public   Integer  getDeptNo();
       public void setDeptNo(Integer deptNo);
       public void setDeptName(String deptName);
       public  String getDeptName();
       public  void setDeptHead(String deptHead);
       public  String  getDeptHead();
       public void  setEmployees(Set<Employee> list);
       public  Set<Employee> getEmployees();
}
