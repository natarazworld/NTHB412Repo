package com.nt.service;

import java.util.List;

import com.nt.dao.IProductDAO;
import com.nt.dao.ProductDAOImpl;
import com.nt.entity.Product;

public class ProductMgmtServiceImpl implements IProductMgmtService {
	
   private IProductDAO  dao;
	public ProductMgmtServiceImpl() {
		 dao=new ProductDAOImpl();  //DAO class object
	}
	
	@Override
	public long getPagesCount(int pageSize) {
		//get total  no.of records
		long recordsCount=dao.getTotalRecordsCount();
		//get PagesCount
		long pagesCount=recordsCount/pageSize;
		if(recordsCount%pageSize!=0)
			  pagesCount++;
		return pagesCount;
	}
	
	public  List<Product>   getPageData(int pageNo,int pageSize){
		//find out startPosition for pagination
		 int startPosition=(pageNo*pageSize)-pageSize;
		 //use DAO to get the given page Data
		 List<Product> list=dao.getPageData(startPosition, pageSize);
		 return list;
	}


}
