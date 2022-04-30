package com.nt.dao;

public interface OneToOnePKDAO {
     public  void  saveDataUsingParent();
     public  void  saveDataUsingChild();
     public  void loadDataUsingParent();
}
