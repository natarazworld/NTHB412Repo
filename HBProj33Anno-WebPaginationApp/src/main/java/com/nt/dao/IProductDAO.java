package com.nt.dao;

import java.util.List;

import com.nt.entity.Product;

public interface IProductDAO {
    public  long  getTotalRecordsCount();
    public  List<Product> getPageData(int startPosition, int pageSize);
}
