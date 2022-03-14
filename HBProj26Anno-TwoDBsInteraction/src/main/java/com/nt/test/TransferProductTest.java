package com.nt.test;

import java.sql.SQLException;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;

import com.nt.entity.Product;
import com.nt.utility.HibernateUtil_MySQL;
import com.nt.utility.HibernateUtil_Oracle;

public class TransferProductTest {

	public static void main(String[] args) {
		SessionFactory oracleFactory=HibernateUtil_Oracle.getSessionFactory();
		SessionFactory  mysqlFactory=HibernateUtil_MySQL.getSessionFactory();
		Session oracleSes=HibernateUtil_Oracle.getSession();
		Session  mysqlSes=HibernateUtil_MySQL.getSession();
		Transaction mysqlTx=null;
		try(oracleFactory;mysqlFactory;oracleSes;mysqlSes){
			//get Object /record from oracle Db table
			Product prod=oracleSes.get(Product.class,28);
			//save the object/record into  mysql db table
			mysqlTx=mysqlSes.beginTransaction();
			      int idVal=(int) mysqlSes.save(prod);
            mysqlTx.commit();
            System.out.println("Record/Object is transffered from oracle to mysql Db table");
		}
		catch(Exception e) {
			
			if(mysqlTx!=null  && mysqlTx.getStatus()!=null && mysqlTx.getRollbackOnly()) {
				  mysqlTx.rollback();
              System.out.println("Problem in transffering record");				  
			}//if
			 e.printStackTrace();
		}//catch
	}//main
}//class
