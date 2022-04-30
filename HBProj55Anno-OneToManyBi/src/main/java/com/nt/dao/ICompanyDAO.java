package com.nt.dao;

public interface ICompanyDAO {
    public void  saveDataUsingParent();
    public void  saveDataUsingChild();
    public  void   loadDataUsingParent();
    public  void  loadDataUsingChild();
}
