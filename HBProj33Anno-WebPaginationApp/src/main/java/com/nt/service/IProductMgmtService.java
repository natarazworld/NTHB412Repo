package com.nt.service;

import java.util.List;
import com.nt.entity.Product;

public interface IProductMgmtService {
	public long  getPagesCount(int pageSize) ;
	public  List<Product>   getPageData(int pageNo,int pageSize);
}
