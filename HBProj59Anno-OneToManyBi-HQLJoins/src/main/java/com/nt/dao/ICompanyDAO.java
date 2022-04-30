package com.nt.dao;

public interface ICompanyDAO {
   public   void  loadDataUsingJoinsParentToChild();
   public   void  loadDataUsingJoinsChildToParent();
   
   public   void loadDataUsingParent();
   
}
