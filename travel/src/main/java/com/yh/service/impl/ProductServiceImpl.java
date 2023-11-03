package com.yh.service.impl;

import com.yh.mapper.OrderMapper;
import com.yh.mapper.ProductMapper;
import com.yh.pojo.Product;
import com.yh.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @Auther: Yanjw
 * @Date: 2023/11/2 - 11 - 02 - 14:25
 * @Description: com.yh.service.impl
 * @version: 1.0
 */
@Service
public class ProductServiceImpl implements ProductService {

    @Autowired
    ProductMapper productMapper;

    @Autowired
    OrderMapper orderMapper;

    @Override
    public List<Product> findAll() {
        return productMapper.findAll();
    }

    @Override
    public void save(Product product) {
        productMapper.save(product);
    }

    @Override
    public Product findById(int pid) {
        return productMapper.findById(pid);
    }

    @Override
    public void edit(Product product) {
        productMapper.edit(product);
    }

    @Override
    public void deleteById(Integer pid) {
        orderMapper.updateById(pid);
        productMapper.deleteById(pid);
    }
}
