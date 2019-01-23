package com.jluzh.product.service.impl;

import com.jluzh.product.common.ProductInfoOutput;
import com.jluzh.product.dataobject.ProductInfo;
import com.jluzh.product.enums.ProductStatusEnum;
import com.jluzh.product.repository.ProductInfoRepository;
import com.jluzh.product.service.ProductService;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;


@Service
public class ProductServiceImpl implements ProductService {

    @Autowired
    private ProductInfoRepository productInfoRepository;


    @Override
    public List<ProductInfo> findUpAll() {
        return productInfoRepository.findByProductStatus(ProductStatusEnum.UP.getCode());
    }

    @Override
    public List<ProductInfoOutput> findList(List<String> productIdList) {
        return productInfoRepository.findByProductIdIn(productIdList).stream()
                .map(e -> {
                    ProductInfoOutput output = new ProductInfoOutput();
                    BeanUtils.copyProperties(e, output);
                    return output;
                })
                .collect(Collectors.toList());
    }


}
