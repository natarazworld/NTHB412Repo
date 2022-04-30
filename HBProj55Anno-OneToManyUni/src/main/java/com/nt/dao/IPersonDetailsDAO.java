package com.nt.dao;

public interface IPersonDetailsDAO {
     public void saveDataUsingParent();
     public void   loadDataUsingParent();
     public void  addChildToExistingParent();
     public void  deleteAllChildsOfAParent();
     public  void deleteOneChildFromCollectionOfChildsOfAParent();
     public void  deleteParentAndItsChilds();
}
