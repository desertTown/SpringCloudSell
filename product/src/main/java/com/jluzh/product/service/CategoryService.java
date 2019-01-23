package com.jluzh.product.service;


import com.jluzh.product.dataobject.ProductCategory;

import java.util.List;

public interface CategoryService {

    List<ProductCategory> findByCategoryTypeIn(List<Integer> categoryTypeList);
}
