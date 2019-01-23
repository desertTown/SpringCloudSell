package com.jluzh.product.service;

import com.jluzh.product.ProductApplicationTests;
import com.jluzh.product.common.DecreaseStockInput;
import com.jluzh.product.common.ProductInfoOutput;
import com.jluzh.product.dataobject.ProductInfo;
import org.junit.Assert;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.Arrays;
import java.util.List;

import static org.junit.Assert.*;

@Component
public class ProductServiceTest extends ProductApplicationTests {
    @Autowired
    private ProductService productService;

    @Test
    public void findUpAll() throws Exception {
        List<ProductInfo> list = productService.findUpAll();
        Assert.assertTrue(list.size() > 0);
    }

    @Test
    public void findList() throws Exception {
        List<ProductInfoOutput> list = productService.findList(Arrays.asList("157875196366160022", "157875227953464068"));
        Assert.assertTrue(list.size() > 0);
    }

}