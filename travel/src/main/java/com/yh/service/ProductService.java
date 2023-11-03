package com.yh.service;

import com.yh.pojo.Product;

import java.util.List;

/**
 * @Auther: Yanjw
 * @Date: 2023/11/2 - 11 - 02 - 14:25
 * @Description: com.yh.service
 * @version: 1.0
 */
public interface ProductService {
    List<Product> findAll();
    void save(Product product);
    Product findById(int pid);
    void edit(Product product);
    void deleteById(Integer pid);
}
